
package com.uet.lab10;

public class SoftwareLab1 {

    public static void submitJobs() {

        // Get the shared PrintSpooler object
        PrintSpooler spooler = PrintSpooler.getInstance();

        // Submit two print jobs
        spooler.addPrintJob(
                "SoftwareLab1",
                "Java_Assignment.pdf"
        );

        spooler.addPrintJob(
                "SoftwareLab1",
                "Lab_Report.docx"
        );
    }
}
