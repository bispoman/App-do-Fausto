package com.example.danielbispo.myapp1312lication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app1312 under test.
        Context app1312Context = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.danielbispo.myapp1312lication", app1312Context.getPackageName());
    }
}
