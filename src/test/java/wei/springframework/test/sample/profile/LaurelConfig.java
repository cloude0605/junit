package wei.springframework.test.sample.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * LaurelConfig.
 * TODO
 * 2019-06-21 07:04
 *
 * @author wei
 * @version 1.0.0
 **/
@Profile("base-test")
@Configuration
public class LaurelConfig {

    @Bean
    WordProducer wordProducer(){
        return new LaurelWordProducer();
    }
}
