package sample;

import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import org.junit.Rule;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest({Taisyou.class, Util.class})
public class TaisyouTest {
    
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    /** テスト対象 */
    private Taisyou taisyou;
    
    private Util util;

    /**
     * 初期処理
     */
    @Before
    public void setup() {
        this.taisyou = new Taisyou();
        this.util = new Util();
    }

    /**
     * テスト
     */
    @Test
    public void searchTest() throws Exception {
        // テスト対象メソッド内で呼び出されるコンストラクタで返すモックオブジェクト生成
        Util mock = Mockito.mock(Util.class);
        Mockito.doReturn("test").when(mock).get();

        // Utilクラスのコンストラクタで返されるインスタンスをモックに変更
        PowerMockito.whenNew(Util.class).withNoArguments().thenReturn(mock);

        // テスト対象の実行
        String result = this.taisyou.search();

        // 評価
        Assert.assertSame(result, "test");
    }
    
    @Test
    public void searchTest2() {
        assertThat(taisyou.search(), is("Util get"));
        System.out.println("searchTest2 : " + taisyou.search());
    }

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