package id.ac.ui.cs.advprog.bookubehistory.controller;
import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDetailDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.Book;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseItem;
import id.ac.ui.cs.advprog.bookubehistory.model.User;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;
import id.ac.ui.cs.advprog.bookubehistory.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/history")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

//    @GetMapping("/")
//    PurchaseHistory getUser(@AuthenticationPrincipal User user) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//        String email = user.getEmail();
//        String role = user.getRole(); // ADMIN atau CUSTOME
//        return new PurchaseHistory();
//        }

    @PostMapping("/createPurchaseHistory")
    public ResponseEntity<?> createPurchaseHistory(@RequestBody PurchaseHistoryDTO purchaseDTO) {
        List<UUID> bookIds = purchaseDTO.getBookIds();
        String url = "http://localhost:7000/book/get-multiple";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<UUID>> entity = new HttpEntity<>(bookIds, headers);

        ResponseEntity<Book[]> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Book[].class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            Book[] books = response.getBody();
            PurchaseHistory history = purchaseHistoryService.createPurchaseHistory(purchaseDTO, books);
            return ResponseEntity.ok(history);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch book details");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PurchaseHistory>> getPurchaseHistory(@PathVariable UUID userId) {
        return ResponseEntity.ok(purchaseHistoryService.getPurchaseHistoryByUser(userId));
    }

    @GetMapping("/{userId}/{purchaseHistoryId}")
    public ResponseEntity<PurchaseHistoryDetailDTO> getPurchaseHistoryDetails(@PathVariable UUID userId, @PathVariable UUID purchaseHistoryId) {
        PurchaseHistoryDetailDTO details = purchaseHistoryService.getPurchaseHistoryDetails(purchaseHistoryId);
        return ResponseEntity.ok(details);
    }
}
