package com.swiftbricks.jtk.e000;

public class ThreadCreationExample {
    private Thread thread; 
    public void doStuff() {
        log("doStuff() started");
        log("Created a thread object");
        thread = new Thread() {
            @Override
            public void run() {
                log("run() entered");
                spendTime();
                log("run() done");
            }
        };
        
        thread.run();
        log("doStuff() done");
    }
    
    public void stop() {
        log("stopping the thread");
        thread.interrupt();
    }
    
    private final void spendTime() {
        try {
            Thread.sleep(120000);
        } catch (InterruptedException ex) {
            log("Ah, we're interrupted - no more waiting then!");
        }
    }
    
    private final void log(String msg) {
        System.out.println(Thread.currentThread().getName() + ": " + msg); 
    }
}
