package id.ac.ui.cs.advprog.history.service;
import id.ac.ui.cs.advprog.history.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.history.model.PurchaseHistory;
import id.ac.ui.cs.advprog.history.model.PurchaseItem;
import id.ac.ui.cs.advprog.history.repository.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory createPurchaseHistory(PurchaseHistoryDTO purchaseHistoryDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UUID userId = UUID.fromString(userDetails.getUsername()); // Assuming username is user ID

        List<PurchaseItem> purchaseItems = purchaseHistoryDTO.getBookIds().stream()
                .map(bookId -> PurchaseItem.builder()
                        // data dummy, ambil dari reyhan.
                        // Tapi karena di fitur ini hanya menampilkan info singkat terkait buku

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
                .purchaseDate(new Date())
                .build();

        purchaseItems.forEach(item -> item.setPurchaseHistory(purchaseHistory));

        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoryByUser(UUID userId) {
        return purchaseHistoryRepository.findByUserId(userId);
    }
}
