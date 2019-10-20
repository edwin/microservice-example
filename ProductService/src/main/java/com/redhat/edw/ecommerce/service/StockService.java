package com.redhat.edw.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.service.StockService
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 Okt 2019 10:43
 */
@Service
public class StockService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${stock.location}")
    private String stockLocation;

    public Map getStock(Integer id) {
        return restTemplate.getForObject(stockLocation+id, Map.class);
    }

}
