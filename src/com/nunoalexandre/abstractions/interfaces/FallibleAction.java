package com.nunoalexandre.abstractions.interfaces;

@FunctionalInterface
public interface FallibleAction<T, E> {
    T result() throws Exception;
}
