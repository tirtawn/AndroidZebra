package com.shurik.droidzebra;

import android.test.ActivityInstrumentationTestCase2;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.shurik.droidzebra.DroidZebraTest \
 * com.shurik.droidzebra.tests/android.test.InstrumentationTestRunner
 */
public class DroidZebraTest extends ActivityInstrumentationTestCase2<ZebraActivity> {

    public DroidZebraTest() {
        super("com.shurik.droidzebra", ZebraActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

//    public TestView_Functional_Test() {
//    	super("project.base", TestView.class);
//    }

    public void testDroidZebraJson() {
        String test = "";
        for (int i = 0; i < 1000; i++) {
            test += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        }
        for (int i = 0; i < 100000; i++) {
            JSONObject json = new JSONObject();
            try {
                json.put("testin", test);
                this.getActivity().mZebraThread.zeJsonTest(json);
                assertEquals("JSON object test: in and out", test, json.getString("testout"));
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
