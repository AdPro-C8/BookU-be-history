package id.ac.ui.cs.advprog.bookubehistory.controller;

import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDetailDTO;
import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.Book;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;
import id.ac.ui.cs.advprog.bookubehistory.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("api/history")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @PostMapping("/createPurchaseHistory")
    public ResponseEntity<?> createPurchaseHistory(@RequestBody PurchaseHistoryDTO purchaseDTO) {
        List<UUID> bookIds = purchaseDTO.getBookIds();
        String url = "http://localhost:8003/book/get-multiple";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, List<UUID>> body = Map.of("bookIds", bookIds);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, List<UUID>>> entity = new HttpEntity<>(body, headers);

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
