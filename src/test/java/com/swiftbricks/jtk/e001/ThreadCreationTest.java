package com.swiftbricks.jtk.e001;

import com.swiftbricks.jtk.e000.ThreadCreationExample;
import org.junit.After;
import org.junit.Test;

/**
 * All the code which runs is executed by some thread.
 * So even if you haven't explicitly tried threading before, you was using at least one thread of execution.
 * 
 * In this example Java Thread object is created but it is
 * executed by current thread. 
 * 
 * Your mission here is to tell it to be started for concurrent execution.
 * 
 * Mind the difference in the logged messages once you've made the test green.
 */
public class ThreadCreationTest {
    private ThreadCreationExample example = new ThreadCreationExample();
    
    /**
     * Hint: cmVwbGFjZSBydW4oKSB3aXRoIHN0YXJ0KCk=
     * 
     * Did you know: VG8gaGFuZGxlIHRpbWVvdXQ9MTAwMCwgSlVuaXQgcnVucyB5b3VyIGNvZGUgaW4gYW5vdGhlciB0aHJlYWQuIE1haW4gdGhyZWFkIGlzIHNsZWVwaW5nIHRoZSBzcGVjaWZpZWQgdGltZW91dCBhbmQgY2hlY2tzIGlmIHRoZSB0ZXN0IG1ldGhvZCBpcyBmaW5pc2hlZC4gSWYgbm8gLSB0aGUgZXhjZXB0aW9uIGlzIHJhaXNlZC4gVGhhdCdzIHdoeSB3ZSBoYXZlIDMgdGhyZWFkcyBpbiB0aGUgbG9nOiAxLiBKVW5pdCBtYWluLCAyLiBKVW5pdCBoZWxwZXIsIDMuIE91ciB0aHJlYWQ=
     */
    @Test(timeout=1000)
    public void testThreadCreation() {
        example.doStuff();
    }
    
    @After
    public void after() {
        example.stop();
    }
}
