package com.redhat.edw.ecommerce.controller;

import com.redhat.edw.ecommerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.controller.PurchaseController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 Okt 2019 12:07
 */
@RestController
public class PurchaseController {

    @Autowired
    private StockService stockService;

    private List<String> products = new ArrayList<>();

    @GetMapping("/{id}")
    public Map purchase(@PathVariable Integer id) {
        products.addAll(Arrays.asList(new String[]{"", "Red Hat TShirt", "Shoes", "Engineering Book", "Something"}));
        return new HashMap() {{
            putAll(stockService.getPurchase(id));
            put("productName", products.get(id));
            put("productId", id);
            put("productDescription", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam " +
                    "aspernatur!");
        }};
    }
}
