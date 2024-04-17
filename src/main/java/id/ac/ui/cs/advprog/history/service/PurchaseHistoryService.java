package id.ac.ui.cs.advprog.history.service;

import id.ac.ui.cs.advprog.history.model.*;
import java.util.List;

public interface PurchaseHistoryService {
    List<PurchaseHistory> findPurchasesByUserId(Long userId);
}

