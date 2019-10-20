package com.redhat.edw.ecommerce.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.service.RestTemplateConfig
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 19 Okt 2019 22:19
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
