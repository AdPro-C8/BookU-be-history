package id.ac.ui.cs.advprog.bookubehistory.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PurchaseHistoryDetailDTO {
    private UUID historyId;
    private Date purchaseDate;
    private int totalPrice;
    private List<PurchaseItemDTO> items;

    public PurchaseHistoryDetailDTO(UUID historyId, Date purchaseDate, int totalPrice, List<PurchaseItemDTO> items) {
        this.historyId = historyId;
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    // Getters and setters
    // Lombok @Getter and @Setter can simplify this code
}