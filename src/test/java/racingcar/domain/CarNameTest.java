package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @DisplayName("정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "pobi", "woni", "jun", "zyxwu"})
    public void createTest(String name) throws Exception {
        assertThatCode(() -> CarName.createByName(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름에 알파벳 소문자 이외의 문자가 포함되어 있는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcd1", "12345", "안녕하세요", "ABCDE"})
    public void containsNonAlphabetTest(String name) throws Exception {
        assertThatCode(() -> CarName.createByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @DisplayName("이름 길이가 5글자를 초과하는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "sdfjiqoweutio", "pobipobi", "wonijunjunwoni"})
    public void nameLengthMoreThanFiveTest(String name) throws Exception {
        assertThatCode(() -> CarName.createByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }
}