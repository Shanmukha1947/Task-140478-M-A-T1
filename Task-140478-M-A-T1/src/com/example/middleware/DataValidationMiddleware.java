package com.example.middleware;

import java.util.function.Supplier;

public interface DataValidationMiddleware {
    <T> T validateData(Supplier<T> dataScrapingFunction);
}
