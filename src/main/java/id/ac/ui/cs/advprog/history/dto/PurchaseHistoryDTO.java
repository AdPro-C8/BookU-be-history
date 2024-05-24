package id.ac.ui.cs.advprog.history.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PurchaseHistoryDTO {
    private List<UUID> bookIds;
    private UUID userId;
    private Date purchaseDate;
    private int totalPrice;

    // Constructors, Getters, Setters (Lombok will generate these)
}
