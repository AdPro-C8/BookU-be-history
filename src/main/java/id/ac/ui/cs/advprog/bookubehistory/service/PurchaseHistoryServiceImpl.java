package id.ac.ui.cs.advprog.bookubehistory.service;

import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseItem;
import id.ac.ui.cs.advprog.bookubehistory.repository.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory createPurchaseHistory(PurchaseHistoryDTO purchaseHistoryDTO) {
        UUID userId = purchaseHistoryDTO.getUserId(); // Langsung dari DTO

        List<PurchaseItem> purchaseItems = purchaseHistoryDTO.getBookIds().stream()
                .map(bookId -> PurchaseItem.builder()
                        .bookId(bookId)
                        .bookTitle("Dummy Title") // This should be fetched from a book service or repository
                        .bookImageUrl("Dummy Image URL") // This should be fetched from a book service or repository
                        .price(100) // This should be fetched from a book service or repository
                        .build())
                .collect(Collectors.toList());

        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                .userId(userId)
                .purchaseItems(purchaseItems)
                .totalPrice(purchaseHistoryDTO.getTotalPrice())
                .purchaseDate(purchaseHistoryDTO.getPurchaseDate())
                .build();

        purchaseItems.forEach(item -> item.setPurchaseHistory(purchaseHistory));

        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoryByUser(UUID userId) {
        return purchaseHistoryRepository.findByUserId(userId);
    }
}
