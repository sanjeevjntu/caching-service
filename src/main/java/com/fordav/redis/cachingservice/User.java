package com.fordav.redis.cachingservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("USER")
@Data
public class User {

    private String id;
    private String name;
    private String vin;

    public User(String name, String vin) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.vin = vin;
    }
}
