package com.example.middleware;

import java.util.function.Supplier;

public class WebScraper {
    private ErrorHandlingMiddleware errorHandlingMiddleware;
    private DataValidationMiddleware dataValidationMiddleware;

    public WebScraper(ErrorHandlingMiddleware errorHandlingMiddleware, DataValidationMiddleware dataValidationMiddleware) {
        this.errorHandlingMiddleware = errorHandlingMiddleware;
        this.dataValidationMiddleware = dataValidationMiddleware;
    }

    public void scrapeData() {
        String url = "https://example.com";

        // Step 1: Use Error Handling Middleware for response management
        errorHandlingMiddleware.handleError(this::fetchResponse, url);
    }

    private String fetchResponse(String url) {
        // Simulate fetching the response
        throw new RuntimeException("Failed to fetch response!");
    }

    public void scrapeAndValidateData() {
        // Step 2: Use Data Validation Middleware for data parsing
        dataValidationMiddleware.validateData(this::scrapeDataFromSource);
    }

    private String scrapeDataFromSource() {
        // Simulate data scraping
        return ""; // Replace this with the actual scraped data
    }

    public static void main(String[] args) {
        WebScraper scraper = new WebScraper(new LoggingErrorHandlingMiddleware(), new SampleDataValidationMiddleware());
        try {
            scraper.scrapeData();
        } catch (Exception e) {
            System.err.println("Caught error in scrapeData: " + e.getMessage());
        }

        try {
            scraper.scrapeAndValidateData();
        } catch (Exception e) {
            System.err.println("Caught error in scrapeAndValidateData: " + e.getMessage());
        }
    }
}
