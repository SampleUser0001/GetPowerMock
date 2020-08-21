package sample;

import java.util.HashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit3.PowerMockSuite;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.runner.Version;

@PrepareForTest(MyFinal.class)
public class MyPowerMockTest extends TestCase {

    public MyPowerMockTest(String name) {
        super(name);
        System.out.println("JUNIT VERSION: " + Version.id());
    }

    public static TestSuite suite() throws Exception {
        return new PowerMockSuite("Unit tests for " + MyPowerMockTest.class.getSimpleName(),MyPowerMockTest.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testretrieveMapFromMyFinal() throws Exception {

        PowerMockito.mockStatic(MyFinal.class);
        Map testMap = new HashMap();
        testMap.put("VALUE", "pallab");
        Mockito.when(MyFinal.getObjectFromSomewhere("key")).thenReturn(testMap);
        assertEquals(testMap, PowerMockStaticFinalClass.returnMap("key"));
    }

}