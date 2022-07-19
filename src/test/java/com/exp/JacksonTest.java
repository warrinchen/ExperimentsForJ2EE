package com.exp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JacksonTest {
    @Test
    public void testJackson(){
        Map<String, String> map = new HashMap<>();
        map.put("Stringing", "str");
        try {
            System.out.println(new ObjectMapper().writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
