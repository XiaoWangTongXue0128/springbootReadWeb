package com.example.springbootreadweb.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.16", 6379);
        jedis.set("jedis", "hello jedis");
        System.out.println(jedis.get("jedis"));

        jedis.close();
    }
}
