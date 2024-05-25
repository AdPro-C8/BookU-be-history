package id.ac.ui.cs.advprog.bookubehistory.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private Date purchaseDate;

    @OneToMany(mappedBy = "purchaseHistory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseItem> purchaseItems;

    @Column(nullable = false)
    private UUID userId;
}
