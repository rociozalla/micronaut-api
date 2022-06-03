package com.rociozalla.controller;

import com.rociozalla.service.ArithmeticService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Controller("/math")
public class ArithmeticController {
    @Inject
    private ArithmeticService arithmeticService;

    @Get("/sum/{number1}/{number2}")
    public float getSum(float number1, float number2) {
        return arithmeticService.add(number1, number2);
    }

    @Get("/subtract/{number1}/{number2}")
    public float getDifference(float number1, float number2) {
        return arithmeticService.subtract(number1, number2);
    }

    @Get("/multiply/{number1}/{number2}")
    public float getMultiplication(float number1, float number2) {
        return arithmeticService.multiply(number1, number2);
    }

    @Get("/divide/{number1}/{number2}")
    public float getDivision(float number1, float number2) {
        return arithmeticService.divide(number1, number2);
    }

    @Get("/isPrime/{number}")
    public boolean getIsPrime(int number) {
        return arithmeticService.isPrime(number);
    }

    @Get("/memory")
    public String getMemoryStatus() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        String memoryStats = "";

        String init = String.format(
                "Initial: %.2f GB \n",
                (double)memoryBean.getHeapMemoryUsage().getInit() /1073741824);
        String usedHeap = String.format("Used: %.2f GB \n",
                (double)memoryBean.getHeapMemoryUsage().getUsed() /1073741824);
        String maxHeap = String.format("Max: %.2f GB \n",
                (double)memoryBean.getHeapMemoryUsage().getMax() /1073741824);
        String committed = String.format("Committed: %.2f GB \n",
                (double)memoryBean.getHeapMemoryUsage().getCommitted() /1073741824);
        memoryStats += init;
        memoryStats += usedHeap;
        memoryStats += maxHeap;
        memoryStats += committed;

        return memoryStats;
    }
}
