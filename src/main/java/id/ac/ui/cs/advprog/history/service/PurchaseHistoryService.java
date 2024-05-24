package id.ac.ui.cs.advprog.history.service;

import id.ac.ui.cs.advprog.history.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.history.model.PurchaseHistory;

import java.util.List;
import java.util.UUID;

public interface PurchaseHistoryService {
    PurchaseHistory createPurchaseHistory(PurchaseHistoryDTO purchaseHistoryDTO);
    List<PurchaseHistory> getPurchaseHistoryByUser(UUID userId);
}
