package com.example.demo.utils;

import java.security.SecureRandom;

public class MathTest {

    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        byte[] bytes = sr.generateSeed(10);


        System.out.println("bytes.toString() = " + sr.nextLong());
    }
}
