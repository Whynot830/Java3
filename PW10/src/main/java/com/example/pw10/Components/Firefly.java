package com.example.pw10.Components;

import com.example.pw10.Interfaces.Lighter;
import org.springframework.stereotype.Component;

@Component("firefly")
public class Firefly implements Lighter {
    @Override
    public void doLight() {
        System.out.println("Light by firefly");
    }
}
