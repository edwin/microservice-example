package com.redhat.edw.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.controller.StockController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 Okt 2019 09:48
 */
@RestController
public class StockController {
    @GetMapping("/{id}")
    public Map getStock(@PathVariable Integer id) throws Exception {
        if(id == 1) {
            return new HashMap(){{
                put("stock", 4);
            }};
        }
        if(id == 2) {
            return new HashMap(){{
                put("stock", 10);
            }};
        }
        if(id == 3) {
            return new HashMap(){{
                put("stock", 0);
            }};
        }
        else {
            throw new Exception("Stock doesnt Exist");
        }
    }

    @GetMapping("/purchase/{id}")
    public Map puchase(@PathVariable Integer id) throws Exception {
        if(id == 1) {
            return new HashMap(){{
                put("success", true);
            }};
        }
        if(id == 2) {
            return new HashMap(){{
                put("success", true);
            }};
        }
        if(id == 3) {
            throw new Exception("Stock doesnt Exist");
        }
        else {
            return new HashMap(){{
                put("success", true);
            }};
        }
    }
}
