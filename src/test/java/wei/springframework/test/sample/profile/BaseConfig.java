package wei.springframework.test.sample.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * BaseConfig.
 * TODO
 * 2019-06-21 09:41
 *
 * @author wei
 * @version 1.0.0
 **/
@Profile("base-test")
@Configuration
public class BaseConfig {

    @Bean
    HearingInterpreter hearingInterpreter() {
        return new HearingInterpreter();
    }
}
