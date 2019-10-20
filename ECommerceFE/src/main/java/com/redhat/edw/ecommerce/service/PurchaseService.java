package com.redhat.edw.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.service.PurchaseService
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 Okt 2019 12:46
 */
@Service
public class PurchaseService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${purchase.location}")
    private String purchaseEndpoint;

    public Map getPurchase(Integer id) throws Exception {
        return restTemplate.getForObject(purchaseEndpoint+id, Map.class);
    }
}
