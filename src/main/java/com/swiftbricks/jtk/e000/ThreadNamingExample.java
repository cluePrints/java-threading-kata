package com.swiftbricks.jtk.e000;

import java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;

public class ThreadNamingExample {
    private Thread thread;
    private ExecutorService threadPool;
    
    public void startStuff() {
        thread = new Thread() {
            public void run() {
                sleeep();
            };
        };
        thread.start();
        
        threadPool = Executors.newSingleThreadExecutor();
        threadPool.submit(new Runnable() {            
            public void run() {
                sleeep();
            }
        });
    }
    
    private void sleeep() {
        try {
            Thread.sleep(500000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
