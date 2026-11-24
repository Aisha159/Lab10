
package com.uet.lab10;

public class Lab10 {

    public static void main(String[] args) {

        // ================= TASK 1 =================

        System.out.println("===== TASK 1: DATABASE MANAGER =====");

        DatabaseConnectionManager studentPortal =
                DatabaseConnectionManager.getInstance();

        DatabaseConnectionManager feeBillingService =
                DatabaseConnectionManager.getInstance();

        DatabaseConnectionManager attendanceTracker =
                DatabaseConnectionManager.getInstance();

        System.out.println("\n--- Identity Hash Codes ---");

        System.out.println("StudentPortal: "
                + System.identityHashCode(studentPortal));

        System.out.println("FeeBillingService: "
                + System.identityHashCode(feeBillingService));

        System.out.println("AttendanceTracker: "
                + System.identityHashCode(attendanceTracker));

        System.out.println("\n--- Executing Queries ---");

        studentPortal.executeQuery(
                "StudentPortal",
                "SELECT * FROM Students"
        );

        feeBillingService.executeQuery(
                "FeeBillingService",
                "SELECT * FROM Fees"
        );

        attendanceTracker.executeQuery(
                "AttendanceTracker",
                "SELECT * FROM Attendance"
        );

        System.out.println("\n--- Reference Equality ---");

        System.out.println("studentPortal == feeBillingService: "
                + (studentPortal == feeBillingService));

        System.out.println("feeBillingService == attendanceTracker: "
                + (feeBillingService == attendanceTracker));

        System.out.println("studentPortal == attendanceTracker: "
                + (studentPortal == attendanceTracker));

        System.out.println("Constructor executions: "
                + DatabaseConnectionManager.getConstructorCount());


        // ================= TASK 2 =================

        System.out.println("\n\n===== TASK 2: PRINT SPOOLER =====");

        // Submit jobs from both labs
        SoftwareLab1.submitJobs();

        NetworkingLab2.submitJobs();

        // Get shared spooler
        PrintSpooler spooler = PrintSpooler.getInstance();

        System.out.println("\nPending jobs: "
                + spooler.getPendingJobCount());

        // Process all jobs in FIFO order
        System.out.println("\n--- Processing Print Jobs ---");

        while (spooler.getPendingJobCount() > 0) {
            spooler.processNextJob();
        }

        System.out.println("\nPending jobs after processing: "
                + spooler.getPendingJobCount());


        // ================= TASK 3 =================

        runAuditLoggerTest();
    }


    // ================= TASK 3 TEST METHOD =================

    public static void runAuditLoggerTest() {

        System.out.println("\n===== TASK 3: NAIVE SINGLETON =====");

        // Store five threads
        Thread[] threads = new Thread[5];

        // Store the references returned to the threads
        AuditLogger[] references = new AuditLogger[5];

        // Create five threads
        for (int i = 0; i < 5; i++) {

            final int index = i;

            threads[i] = new Thread(() -> {

                // Each thread requests AuditLogger
                AuditLogger logger = AuditLogger.getInstance();

                // Store the received reference
                references[index] = logger;

                // Print identity hash code
                System.out.println(
                        Thread.currentThread().getName()
                        + " received hash: "
                        + System.identityHashCode(logger)
                );

            }, "Thread-" + (i + 1));
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Check whether all references are the same
        boolean sameInstance = true;

        for (int i = 1; i < references.length; i++) {

            if (references[i] != references[0]) {
                sameInstance = false;
                break;
            }
        }

        System.out.println("\nAll threads share the same object: "
                + sameInstance);
    }
}
