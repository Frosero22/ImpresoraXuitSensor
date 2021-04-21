package ec.com.xuit.util;

import javax.print.DocPrintJob;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class PrintJobWatcher {

    boolean booDone = false;

    PrintJobWatcher(DocPrintJob job) {
        job.addPrintJobListener(new PrintJobAdapter() {
            @Override
            public void printJobCanceled(PrintJobEvent pje) {
                synchronized (PrintJobWatcher.this) {
                    booDone = true;
                    PrintJobWatcher.this.notify();
                }
            }

            @Override
            public void printJobCompleted(PrintJobEvent pje) {
                System.out.println("Completado...");
                synchronized (PrintJobWatcher.this) {
                    booDone = true;
                    PrintJobWatcher.this.notify();
                }
            }

            @Override
            public void printJobFailed(PrintJobEvent pje) {
                synchronized (PrintJobWatcher.this) {
                    booDone = true;
                    PrintJobWatcher.this.notify();
                }
            }

            @Override
            public void printJobNoMoreEvents(PrintJobEvent pje) {
                synchronized (PrintJobWatcher.this) {
                    booDone = true;
                    PrintJobWatcher.this.notify();
                }
            }
        });
    }
    
    public synchronized void waitForDone() {
        try {
            System.out.println("Esperando...");
            while (!booDone) {
                wait();
            }
        } catch (InterruptedException e) { }
    }
    
}
