package io.honeymon.boot.springboot;

import io.honeymon.boot.springboot.config.bean.RestClientExampleBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class MockBeanTest {

    @MockBean
    private RestClientExampleBean restClientExampleBean;

    @SpyBean
    private RestClientExampleBean restClientExampleBeanSpy;

    @Test
    void exampleTest() {
        String result = "a";
        given(this.restClientExampleBean.findOne(3)).willReturn(result);
        System.out.println(result);
    }

    @Test
    void exampleTest2() {
        String result = "a";
        given(this.restClientExampleBeanSpy.findOne(3)).willReturn(result);
        System.out.println(result);
    }
}
