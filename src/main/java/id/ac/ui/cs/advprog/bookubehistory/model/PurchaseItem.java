package id.ac.ui.cs.advprog.bookubehistory.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID bookId;

    @Column(nullable = false)
    private String bookTitle;

    @Column(nullable = false)
    private String bookImageUrl;

    @Column(nullable = false)
    private int price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "purchase_history_id", nullable = false)
    private PurchaseHistory purchaseHistory;
}
