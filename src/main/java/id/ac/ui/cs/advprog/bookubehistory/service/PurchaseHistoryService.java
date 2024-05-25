package id.ac.ui.cs.advprog.bookubehistory.service;

import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;

import java.util.List;
import java.util.UUID;

public interface PurchaseHistoryService {
    PurchaseHistory createPurchaseHistory(PurchaseHistoryDTO purchaseHistoryDTO);
    List<PurchaseHistory> getPurchaseHistoryByUser(UUID userId);
}
