package id.ac.ui.cs.advprog.history.repository;

import id.ac.ui.cs.advprog.history.model.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, UUID> {
    List<PurchaseHistory> findByUserId(UUID userId);
}
