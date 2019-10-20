package com.redhat.edw.ecommerce.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.service.ProductService
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 Okt 2019 11:06
 */
@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.location}")
    private String productEndpoint;

    @HystrixCommand(fallbackMethod = "getProducts_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public List<Map> getProducts() {
        return restTemplate.getForObject(productEndpoint, List.class);
    }

    private List<Map> getProducts_fallback() {
        return Arrays.asList(new HashMap[]{
                new HashMap(){{
                    put("stock", "0");
                    put("productName", "Product Zero One");
                    put("productId", "1");
                    put("productDescription", "test test test test test test test test ");
                }}
        });
    }
}
