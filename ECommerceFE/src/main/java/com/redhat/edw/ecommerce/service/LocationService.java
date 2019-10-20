package com.redhat.edw.ecommerce.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.service.LocationService
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 19 Okt 2019 22:21
 */
@Service
public class LocationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${endpoint.location}")
    private String locationEndpoint;

    @HystrixCommand(fallbackMethod = "getLocations_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public List<String> getLocations() {
        return restTemplate.getForObject(locationEndpoint, List.class);
    }

    private List<String> getLocations_fallback() {
        return Arrays.asList(new String[]{"No City Found"});
    }
}
