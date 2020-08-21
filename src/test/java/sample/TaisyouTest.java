package sample;

import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import junit.framework.TestCase;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import org.junit.Rule;
import org.powermock.modules.junit4.rule.PowerMockRule;

// import org.junit.runner.RunWith;
// import org.powermock.modules.junit4.PowerMockRunner;

// @RunWith(PowerMockRunner.class)
@PrepareForTest({Taisyou.class, Util.class})
public class TaisyouTest extends TestCase {
    
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    /**
     * privateメソッドのテスト
     */
    @Test
    public void privateMethodTest() throws Exception {
        Taisyou mock = PowerMockito.spy(new Taisyou());
        PowerMockito.when(mock, "print").thenReturn("hoge");

        Method method = Taisyou.class.getDeclaredMethod("print");
        method.setAccessible(true);

        assertThat(method.invoke(mock), is("hoge"));
    }
    
}