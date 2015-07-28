package com.swiftbricks.jtk.e000;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * One about the basic problems with debugging multithreading is that my brain can operate on 7-2=5 things.
 * While number of threads we have usually exceeds that amount. To make matters worse, by default names are not that helpful.
 * 
 * This exercise is about naming these things.
 */
public class ThreadNamingTest {
    private ThreadNamingExample example = new ThreadNamingExample();
    
    @Before
    public void start() {
        example.startStuff();
    }
    
    /** 
     * Hint: dXNlIFRocmVhZChTdHJpbmcgbmFtZSkgY29uc3RydWN0b3I=
     */    
    @Test
    public void testSingleThreadWasNamed() {
        assertThreadExists("single_thread");
    }
    
    /** 
     * Hint: Q3JlYXRlIGEgVGhyZWFkRmFjdG9yeSBpbnN0YW5jZSBhbmQgcGFzcyB0aGF0IHRvIGV4ZWN1dG9yIHNlcnZpY2UgY3JlYXRpbmcgZmFjdG9yeSBtZXRob2Q=
     */
    @Test
    public void testPooledThreadWasNamed() {
        assertThreadExists("poolish_thread-0");
    }
    
    /**
     * That's a tricky one!
     * 
     * Hint #1: aXQgYXNzdW1lcyB5b3VyIHBvb2wgd2lsbCBoYXZlIHR3byB0aHJlYWRz
     * Hint #2: c28geW91IHdpbGwgaGF2ZSB0byBjYWxsIHN1Ym1pdCBmdW5jdGlvbiBhdCBsZWFzdCB0d2ljZQ==
     * Hint #3: YWxzbyB5b3Ugd2lsbCBuZWVkIHRvIGNyZWF0ZSBhIHBvb2wgd2hpY2ggbWFpbnRhaW5zIG1vcmUgdGhhbiBvbmUgdGhyZWFkIHJ1bm5pbmcgc2ltdWx0YW5lb3VzbHk=
     * Hint #4: RXhlY3V0b3JzLm5ld0ZpeGVkVGhyZWFkUG9vbChuVGhyZWFkcyk=
     */
    @Test
    public void testPooledThread2WasCreated() {
        assertThreadExists("poolish_thread-1");
    }

    private List<String> assertThreadExists(String expectedName) {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
        List<String> threadNames = new ArrayList<String>();
        for (Thread thread : threadArray) {
            threadNames.add(thread.getName());
        }
        
        Assert.assertTrue(threadNames + " should contain a thread named " + expectedName, threadNames.contains(expectedName));
        return threadNames;
    }
}
