package id.ac.ui.cs.advprog.bookubehistory.service;

import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDetailDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.Book;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseItem;

import java.util.List;
import java.util.UUID;

public interface PurchaseHistoryService {
    PurchaseHistory createPurchaseHistory(PurchaseHistoryDTO purchaseHistoryDTO, Book[] books);
    List<PurchaseHistory> getPurchaseHistoryByUser(UUID userId);
//    List<PurchaseItem> getPurchaseItemsByHistoryId(UUID historyId);
    PurchaseHistoryDetailDTO getPurchaseHistoryDetails(UUID historyId);
}
