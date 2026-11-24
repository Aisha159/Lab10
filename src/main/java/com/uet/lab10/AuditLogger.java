
package com.uet.lab10;

public class AuditLogger {

    // Naive Singleton: not thread-safe
    private static AuditLogger instance;

    // Private constructor
    private AuditLogger() {
        System.out.println("AuditLogger constructor executed.");
    }

    // Naive getInstance method
    public static AuditLogger getInstance() {

        if (instance == null) {

            try {
                // Delay to make race condition easier to observe
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            instance = new AuditLogger();
        }

        return instance;
    }
}
