package id.ac.ui.cs.advprog.history.model;


import java.util.Date;
import java.util.List;
import lombok.Getter;


@Getter
public class PurchaseHistory {
    private final Long id;
    private final Double totalCost;
    private final Date purchaseDate;
    private final List<PurchaseItem> purchaseItems;
    private final Long userId;


    // Konstruktor langsung tanpa Builder
    public PurchaseHistory(Long id, Double totalCost, Date purchaseDate, List<PurchaseItem> purchaseItems, Long userId) {
        this.id = id;
        this.totalCost = totalCost;
        this.purchaseDate = purchaseDate;
        this.purchaseItems = purchaseItems;
        this.userId = userId;
    }
}
