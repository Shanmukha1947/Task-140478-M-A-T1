package com.example.middleware;

import java.util.function.Supplier;

public class SampleDataValidationMiddleware implements DataValidationMiddleware {

    @Override
    public <T> T validateData(Supplier<T> dataScrapingFunction) {
        T data = dataScrapingFunction.get();
        if (data instanceof String && ((String) data).isEmpty()) {
            throw new IllegalStateException("Scraped data is empty.");
        }
        return data;
    }
}
