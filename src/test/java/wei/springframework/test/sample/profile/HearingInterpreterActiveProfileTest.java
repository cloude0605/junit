package wei.springframework.test.sample.profile;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HearingInterpreterActiveProfileTest.
 * TODO
 * 2019-06-21 07:04
 *
 * @author wei
 * @version 1.0.0
 **/
@ActiveProfiles("yanny-profile")
@SpringJUnitConfig(classes = HearingInterpreterActiveProfileTest.TestConfig.class)
class HearingInterpreterActiveProfileTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();

        assertThat("Yanny").isEqualTo(word);
    }

    @Configuration
    @ComponentScan("wei.springframework.test.sample.profile")
    static class TestConfig {

    }
}