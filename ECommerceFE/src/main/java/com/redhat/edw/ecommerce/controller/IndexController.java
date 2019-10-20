package com.redhat.edw.ecommerce.controller;

import com.redhat.edw.ecommerce.service.LocationService;
import com.redhat.edw.ecommerce.service.ProductService;
import com.redhat.edw.ecommerce.service.PurchaseService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 19 Okt 2019 19:43
 */
@Controller
public class IndexController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/hello")
    public @ResponseBody HashMap sayHelloApi() {
        return new HashMap(){{
            put("Message", "Hello World ");
        }};
    }

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("locations", locationService.getLocations());
        modelMap.put("products", productService.getProducts());
        return "index";
    }

    @GetMapping("/purchase/{id}")
    public String purchase(ModelMap modelMap, @PathVariable Integer id) {
        modelMap.put("locations", locationService.getLocations());
        try {
            modelMap.put("item", purchaseService.getPurchase(id));
        } catch (Exception e) {
            modelMap.put("error", MDC.get("X-B3-SpanId"));
        }
        return "purchase";
    }
}
