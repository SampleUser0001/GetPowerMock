package sample;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;
import static org.powermock.api.mockito.PowerMockito.when;

import static org.mockito.Mockito.anyString;


import sample.bean.Bean;
import sample.Taisyou2;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import org.mockito.InjectMocks;


/**
 * staticメソッドをMockにする
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Taisyou2.class})
public class Taisyou2Test {
    
    /**
     * public staticメソッドを普通にテストする
     */
    @Test
    public void publicStaticMethod_notMocked() throws Exception {
        assertThat(Taisyou2.callPrivateStatic() , is("hoge"));
    }
    
    /**
     * public staticメソッドをMock化する
     */ 
    @Test
    public void publicStaticMethod_mocked() throws Exception {
        PowerMockito.mockStatic(Taisyou2.class);
        
        when(Taisyou2.callPrivateStatic()).thenReturn("mocked");        
        assertThat(Taisyou2.callPrivateStatic() , is("mocked"));
    }
    
    /**
     * private staticメソッドをMock化する
     */
    @Test
    public void privateStaticMethod_mocked() throws Exception {
        PowerMockito.spy(Taisyou2.class);
        PowerMockito.doReturn("mocked").when(Taisyou2.class, "getHogeValue", anyString());

        assertThat(Taisyou2.callPrivateStatic() , is("mocked"));
    }
    
    /**
     * private staticメソッドをMock化する
     * Mock化したメソッドはprivateメソッド内で呼ばれる。
     */
    @Test
    public void usePrivateStaticMethod_mocked() throws Exception {
        Bean bean = new Bean();
        
        Taisyou2 mock = PowerMockito.mock(Taisyou2.class);
        
        PowerMockito.spy(Taisyou2.class);
        PowerMockito.doReturn("mocked").when(Taisyou2.class, "getHogeValue", anyString());

        Method method = Taisyou2.class.getDeclaredMethod("editBean", Bean.class);
        method.setAccessible(true);
        method.invoke(mock, bean);

        assertThat(bean.getValue(), is("mocked"));
    }
    
}
