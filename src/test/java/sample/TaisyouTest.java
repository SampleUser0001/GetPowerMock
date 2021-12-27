package sample;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Taisyou.class, Util.class})
public class TaisyouTest {
   
    /**
     * privateメソッドのテスト
     */
    @Test
    public void test_privateMethodTest() throws Exception {
        Taisyou mock = PowerMockito.spy(new Taisyou());
        PowerMockito.when(mock, "print").thenReturn("hoge");

        Method method = Taisyou.class.getDeclaredMethod("callPrivatePrint_meToo");
        method.setAccessible(true);

        assertThat(method.invoke(mock), is("hoge"));
    }

    /**
     * staticメソッドのモック化
     */
    @Test
    public void test_staticMethodTest() {
        // モック化していない
        assertThat(Taisyou.staticMethod(), is("staticメソッドのMockができていない"));

        // staticメソッドモック化
        PowerMockito.mockStatic(Taisyou.class);
        PowerMockito.when(Taisyou.staticMethod()).thenReturn("staticメソッドモック化済み");
        assertThat(Taisyou.staticMethod(), is("staticメソッドモック化済み"));
        
    }    
}
