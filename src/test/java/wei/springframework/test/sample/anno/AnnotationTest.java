package wei.springframework.test.sample.anno;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AnnotationTest.
 * TODO
 * 2019-06-20 06:21
 *
 * @author wei
 * @version 1.0.0
 **/
public class AnnotationTest {

    @DisplayName("重複測試")
    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition} of {totalRepetitions}")
    void repeat() {
        assertTrue(true);
    }

    @DisplayName("忽略測試")
    @Test
    @Disabled
    void ignore() {
        assertTrue(true);
    }

    @DisplayName("測試超時 assertTimeout")
    @Test
    void timeOut() {
        // assertTimeout 會等Thread.sleep完才結束
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Print here");
        });
    }

    @DisplayName("測試超時 Preempt")
    @Test
    void timeOutPreempt() {
        // assertTimePreemptively 當目標時間到就立即結束
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Print here");
        });
    }
}
