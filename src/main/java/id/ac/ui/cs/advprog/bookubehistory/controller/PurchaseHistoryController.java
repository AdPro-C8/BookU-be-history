package id.ac.ui.cs.advprog.bookubehistory.controller;
import id.ac.ui.cs.advprog.bookubehistory.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;
import id.ac.ui.cs.advprog.bookubehistory.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/history")
public class PurchaseHistoryController {

    @GetMapping("/")
    PurchaseHistory getUser(@AuthenticationPrincipal User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String role = user.getRole(); // ADMIN atau CUSTOME
        return new PurchaseHistory();
        }

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @PostMapping("/create")
    public ResponseEntity<PurchaseHistory> createPurchaseHistory(@RequestBody PurchaseHistoryDTO purchaseHistoryDTO) {
        PurchaseHistory purchaseHistory = purchaseHistoryService.createPurchaseHistory(purchaseHistoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseHistory);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PurchaseHistory>> getPurchaseHistory(@PathVariable UUID userId) {
        return ResponseEntity.ok(purchaseHistoryService.getPurchaseHistoryByUser(userId));
    }
}
