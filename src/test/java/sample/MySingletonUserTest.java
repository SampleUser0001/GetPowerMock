package sample;

import sample.MyPowerMockTest;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit3.PowerMockSuite;

import junit.framework.TestCase;
import junit.framework.TestSuite;

@PrepareForTest(MySingleton.class)
public class MySingletonUserTest extends TestCase {

    public static TestSuite suite() throws Exception {
        return new PowerMockSuite("Unit tests for " + MySingletonUserTest.class.getSimpleName(),MySingletonUserTest.class);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testUseSingleton() {
        
        String expectedStr = "pallab";
        
        MySingletonUser user = new MySingletonUser();
        
        PowerMockito.suppress(PowerMockito.constructor(MySingleton.class));
        MySingleton mySingletonMock = PowerMockito.mock(MySingleton.class);
        PowerMockito.mockStatic(MySingleton.class);
        
        Mockito.when(MySingleton.getInstance()).thenReturn(mySingletonMock);
        
        Mockito.when(mySingletonMock.doSomething()).thenReturn(expectedStr);
        
        assertEquals(expectedStr,user.useSingleton());
    }
}
