package sample;


import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

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

        // private printメソッドをmockにする。
        // hogeが戻るようにする。
        PowerMockito.when(mock, "print").thenReturn("hoge");

        // callPrivatePrint_meTooメソッドをリフレクションで呼び出す。
        // privateメソッドで、printの戻り値をそのまま返す。
        Method method = Taisyou.class.getDeclaredMethod("callPrivatePrint_meToo");
        method.setAccessible(true);

        // callPrivatePrint_meTooメソッドのテストを行う。
        // mock化した結果が戻ってくることを確認する。
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
