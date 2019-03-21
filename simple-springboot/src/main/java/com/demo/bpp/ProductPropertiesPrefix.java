package com.demo.bpp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author junhong
 */

@ConfigurationProperties("product")
public class ProductPropertiesPrefix {

    private Map<String, String> map = new HashMap<>(5);

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

}

