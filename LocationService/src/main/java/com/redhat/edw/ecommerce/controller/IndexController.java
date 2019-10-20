package com.redhat.edw.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 19 Okt 2019 22:29
 */
@RestController
public class IndexController {
    @GetMapping("/")
    public List<String> index() {
        return Arrays.asList(new String[]{"Kuala Lumpur", "Jakarta", "Singapore", "Manila"});
    }
}
