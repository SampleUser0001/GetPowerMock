package sample.controller;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SampleControllerTest {
    
    /**
     * setUpをMock化しない
     */
    @Test
    public void notMockedMethod() {
        SampleController controller = new SampleController();

        controller.setValue(10);
        assertThat(controller.execute(), is(equalTo(100)));
    }

    /**
     * setUpをMock化する。
     * @throws Exception
     */
    @Test
    public void setUpIsMocked() throws Exception {
        SampleController mock = PowerMockito.spy(new SampleController());

        // setUpメソッドをMock化する。
        PowerMockito.doNothing().when(mock,"setUp");
        // 引数がある場合は、whenに3つめの引数を指定する。

        // TODO setUpメソッドをprivateにしたいが、Mock化の方法が不明。

        // notMockedMethodと同じ値を与えても、結果が異なる。
        mock.setValue(10);
        assertThat(mock.execute(), is(equalTo(1)));
    }
}
