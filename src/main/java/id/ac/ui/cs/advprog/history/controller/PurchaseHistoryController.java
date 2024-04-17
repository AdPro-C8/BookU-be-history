package id.ac.ui.cs.advprog.history.controller;

import id.ac.ui.cs.advprog.history.model.PurchaseHistory;
import id.ac.ui.cs.advprog.history.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @GetMapping("/purchases")
    public String listUserPurchases(Model model) {
        Long userId = 1L;
        List<PurchaseHistory> purchases = purchaseHistoryService.findPurchasesByUserId(userId);
        model.addAttribute("purchases", purchases);
        return "purchases"; //
    }
}
