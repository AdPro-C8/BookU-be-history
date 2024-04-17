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

    private PurchaseHistory(Builder builder) {
        this.id = builder.id;
        this.totalCost = builder.totalCost;
        this.purchaseDate = builder.purchaseDate;
        this.purchaseItems = builder.purchaseItems;
        this.userId = builder.userId;
    }

    public static class Builder {
        private Long id;
        private Double totalCost;
        private Date purchaseDate;
        private List<PurchaseItem> purchaseItems;
        private Long userId;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTotalCost(Double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder withPurchaseDate(Date purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public Builder withPurchaseItems(List<PurchaseItem> purchaseItems) {
            this.purchaseItems = purchaseItems;
            return this;
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public PurchaseHistory build() {
            return new PurchaseHistory(this);
        }
    }
}
