package com.redhat.edw.ecommerce.controller;

import com.redhat.edw.ecommerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.controller.ProductController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 Okt 2019 10:40
 */
@RestController
public class ProductController {

    @Autowired
    private StockService stockService;

    private List<String> products = new ArrayList<>();

    @GetMapping("/")
    public List<HashMap> getDashboard() {
        products.addAll(Arrays.asList(new String[]{"", "Red Hat TShirt", "Shoes", "Engineering Book", "Something"}));
        List<HashMap> hashMaps = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            hashMaps.add(new HashMap() {{
                putAll(stockService.getStock(id));
                put("productName", products.get(id));
                put("productId", id);
                put("productDescription", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam " +
                        "aspernatur!");
            }});
        }

        return hashMaps;
    }

}
