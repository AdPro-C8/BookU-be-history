package id.ac.ui.cs.advprog.bookubehistory.dto;

import java.util.UUID;

public class PurchaseItemDTO {
    private UUID bookId;
    private String bookTitle;
    private int price;
    private String bookImageUrl;

    public PurchaseItemDTO(UUID bookId, String bookTitle, int price, String bookImageUrl) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.price = price;
        this.bookImageUrl = bookImageUrl;
    }
}