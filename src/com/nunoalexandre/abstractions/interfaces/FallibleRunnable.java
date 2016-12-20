package com.nunoalexandre.abstractions.interfaces;

@FunctionalInterface
public interface FallibleRunnable {
    void run() throws Exception;
}