package com.example.middleware;

import java.util.function.Function;

public class LoggingErrorHandlingMiddleware implements ErrorHandlingMiddleware {

    @Override
    public <T, R> R handleError(Function<T, R> scrapingFunction, T input) {
        try {
            return scrapingFunction.apply(input);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            // Advanced error handling can be added here (retry/fallback)
            throw e;
        }
    }
}

