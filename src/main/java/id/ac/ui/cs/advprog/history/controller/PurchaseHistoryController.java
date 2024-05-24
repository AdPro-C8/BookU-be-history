package id.ac.ui.cs.advprog.history.controller;

import id.ac.ui.cs.advprog.history.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.history.model.PurchaseHistory;
import id.ac.ui.cs.advprog.history.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/history")
public class PurchaseHistoryController {

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
