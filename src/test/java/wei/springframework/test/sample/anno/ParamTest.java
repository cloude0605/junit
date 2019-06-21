package wei.springframework.test.sample.anno;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

/**
 * ParamTest.
 * TODO
 * 2019-06-20 06:38
 *
 * @author wei
 * @version 1.0.0
 **/
public class ParamTest {

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "BBB"})
    void valueSource(String value) {
        System.out.println(value);
    }

    @ParameterizedTest
    @EnumSource(TestEnum.class)
    void enumSource(TestEnum testEnum) {
        System.out.println(testEnum);
    }

    @ParameterizedTest
    @CsvSource({
            "A,1,1-1",
            "B,2,2-1"
    })
    void csvSource(String column1, int column2, String column3) {
        System.out.println(column1 + " > " + column2 + " > " + column3);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csvFileSource.csv", numLinesToSkip = 1)
    void csvFileSource(String column1, int column2, String column3) {
        System.out.println(column1 + " > " + column2 + " > " + column3);
    }

    @ParameterizedTest
    @MethodSource("getSource")
    void method(String column1, int column2, String column3) {
        System.out.println(column1 + " > " + column2 + " > " + column3);
    }

    static Stream<Arguments> getSource() {
        return Stream.of(
                Arguments.of("A", 1, "1-1"),
                Arguments.of("B", 2, "2-1"),
                Arguments.of("C", 3, "3-1")
        );
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgsProvider.class)
    void argumentsSource(String column1, int column2, String column3) {
        System.out.println(column1 + " > " + column2 + " > " + column3);
    }

}
