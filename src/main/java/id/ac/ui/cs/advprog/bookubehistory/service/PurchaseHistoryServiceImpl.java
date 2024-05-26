package id.ac.ui.cs.advprog.bookubehistory.service;
import id.ac.ui.cs.advprog.bookubehistory.dto.PurchaseHistoryDTO;
import id.ac.ui.cs.advprog.bookubehistory.model.Book;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseHistory;
import id.ac.ui.cs.advprog.bookubehistory.model.PurchaseItem;
import id.ac.ui.cs.advprog.bookubehistory.repository.PurchaseHistoryRepository;
import id.ac.ui.cs.advprog.bookubehistory.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @Override
    public PurchaseHistory createPurchaseHistory(PurchaseHistoryDTO purchaseDTO, Book[] books) {
        PurchaseHistory history = new PurchaseHistory();
        history.setUserId(purchaseDTO.getUserId());
        history.setTotalPrice(purchaseDTO.getTotalPrice());
        history.setPurchaseDate(purchaseDTO.getPurchaseDate());
        history.setPurchaseItems(new ArrayList<>());

        for (Book book : books) {
            PurchaseItem item = new PurchaseItem();
            item.setBookId(book.getId());
            item.setBookTitle(book.getTitle());
            item.setPrice(book.getPrice());
            item.setBookImageUrl(book.getPhotoUrl());
            item.setPurchaseHistory(history);
            history.getPurchaseItems().add(item);
        }

        return purchaseHistoryRepository.save(history);
    }


    @Override
    public List<PurchaseHistory> getPurchaseHistoryByUser(UUID userId) {
        return purchaseHistoryRepository.findByUserId(userId);
    }

    // Dapatkan semua items dari sebuah history
    public List<PurchaseItem> getPurchaseItemsByHistoryId(UUID historyId) {
        return purchaseItemRepository.findByPurchaseHistoryId(historyId);
    }
}
