package id.ac.ui.cs.advprog.history.model;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PurchaseHistory {
    private Long id;
    private Double totalCost;
    private Date purchaseDate;
    private List<PurchaseItem> purchaseItems;
    private Long userId;
}

