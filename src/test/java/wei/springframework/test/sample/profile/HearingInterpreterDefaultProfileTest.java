package wei.springframework.test.sample.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HearingInterpreterDefaultProfileTest.
 * TODO
 * 2019-06-21 07:04
 *
 * @author wei
 * @version 1.0.0
 **/
@SpringJUnitConfig(classes = HearingInterpreterDefaultProfileTest.TestConfig.class)
class HearingInterpreterDefaultProfileTest {

    @Configuration
    @ComponentScan("wei.springframework.test.sample.profile")
    static class TestConfig {

    }

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();

        assertThat("Laurel").isEqualTo(word);
    }
}