package com.example.middleware;

import java.util.function.Function;

public interface ErrorHandlingMiddleware {
    <T, R> R handleError(Function<T, R> scrapingFunction, T input);
}

