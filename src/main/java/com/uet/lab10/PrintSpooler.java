
package com.uet.lab10;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {

    // Single shared PrintSpooler instance
    private static PrintSpooler instance;

    // Shared queue for print jobs
    private final Queue<String> printQueue = new LinkedList<>();

    // Private constructor
    private PrintSpooler() {
        System.out.println("Print Spooler created.");
    }

    // Singleton method
    public static synchronized PrintSpooler getInstance() {

        if (instance == null) {
            instance = new PrintSpooler();
        }

        return instance;
    }

    // Add a print job
    public synchronized void addPrintJob(
            String labName, String documentName) {

        String job = labName + " - " + documentName;

        printQueue.add(job);

        System.out.println("Job added: " + job);
    }

    // Process the next job in FIFO order
    public synchronized void processNextJob() {

        if (printQueue.isEmpty()) {
            System.out.println("No pending print jobs.");
        } else {
            String job = printQueue.poll();

            System.out.println("Printing: " + job);
        }
    }

    // Return the number of pending jobs
    public synchronized int getPendingJobCount() {

        return printQueue.size();
    }
}
