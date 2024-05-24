package id.ac.ui.cs.advprog.history.repository;

import id.ac.ui.cs.advprog.history.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, UUID> {
}
