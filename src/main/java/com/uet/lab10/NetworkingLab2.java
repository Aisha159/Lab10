
package com.uet.lab10;

public class NetworkingLab2 {

    public static void submitJobs() {

        // Get the same shared PrintSpooler object
        PrintSpooler spooler = PrintSpooler.getInstance();

        // Submit one print job
        spooler.addPrintJob(
                "NetworkingLab2",
                "Network_Notes.pdf"
        );
    }
}
