package com.rociozalla.service;

import jakarta.inject.Singleton;
import java.util.stream.IntStream;

@Singleton
public class ArithmeticService {
    public float add(float number1, float number2) {
        return number1 + number2;
    }

    public float subtract(float number1, float number2) {
        return number1 - number2;
    }

    public float multiply(float number1, float number2) {
        return number1 * number2;
    }

    public float divide(float number1, float number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("'number2' cannot be zero");
        }
        return number1 / number2;
    }

    public boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}

