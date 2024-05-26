package id.ac.ui.cs.advprog.bookubehistory.repository;

import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, UUID> {
    List<PurchaseItem> findByPurchaseHistoryId(UUID historyId);
}
