package com.example.websocket;

import org.junit.Test;

import java.math.BigDecimal;


public class WebsocketApplicationTests {

    @Test
    public void contextLoads() {
        BigDecimal a =new BigDecimal(String.valueOf(2)).subtract(new BigDecimal(String.valueOf(1.1)));
        //BigDecimal c = new BigDecimal(a);
        System.out.println("!!!!!!!!!!!!!!!"+a);
    }

}
