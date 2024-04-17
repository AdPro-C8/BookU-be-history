package id.ac.ui.cs.advprog.history.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItem {
    private Long id;
    private String bookName;
    private String bookPhotoUrl;
    private Double price;

    public PurchaseItem(Long id, String bookName, String bookPhotoUrl, Double price) {
        this.id = id;
        this.bookName = bookName;
        this.bookPhotoUrl = bookPhotoUrl;
        this.price = price;
    }
}

