package id.ac.ui.cs.advprog.history.service;

import id.ac.ui.cs.advprog.history.model.PurchaseHistory;
import id.ac.ui.cs.advprog.history.model.PurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    // Nanti kalo pake repository
    // @Autowired
    // private PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public List<PurchaseHistory> findPurchasesByUserId(Long userId) {
        return generateDummyData(userId);
    }

    private List<PurchaseHistory> generateDummyData(Long userId) {
        List<PurchaseHistory> purchases = new ArrayList<>();
        List<PurchaseItem> items = new ArrayList<>();

        items.add(new PurchaseItem(1L, "1984", "/images/1984.jpg", 15.0));
        items.add(new PurchaseItem(2L, "To Kill a Mockingbird", "/images/tkam.jpg", 12.5));

        PurchaseHistory purchase = new PurchaseHistory();
        purchase.setId(1L);
        purchase.setTotalCost(27.5);
        purchase.setPurchaseDate(new Date());
        purchase.setPurchaseItems(items);
        purchase.setUserId(userId);

        purchases.add(purchase);
        return purchases;
    }
}

