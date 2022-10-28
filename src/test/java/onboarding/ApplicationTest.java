package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case4() {
            List<Integer> pobi = List.of(2, 3);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case5() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(399, 400);
            int result = 2;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case6() {
            List<Integer> pobi = List.of(-1, 0);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case7() {
            List<Integer> pobi = List.of(401, 402);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void empty_param_exception() {
            String cryptogram = "";
            String result = null;
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void null_param_exception() {
            String cryptogram = "";
            String result = null;
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void param_length_exception() {
            String cryptogram = "a".repeat(1001);
            String result = null;
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void parameter_duplication_more_than_2() {
            String cryptogram = "aaabbbbccbbbb";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case3() {
            int number = 10000;
            int result = 12000;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void parameter_under1_return_minus_one() {
            int number = 0;
            int result = -1;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void parameter_over10000_return_minus_one() {
            int number = 10001;
            int result = -1;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void parameter_1_return_0() {
            int number = 1;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_mixed_upper_and_lower() {
            String word = "I   lOve  YoU";
            String result = "R   oLev  BlF";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_length_under1_exception() {
            String word = "";
            String result = "";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_length_over1000_exception() {
            String word = "A".repeat(1001);
            String result = word;
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_nonalphabetic_exception() {
            String word = "I& love you";
            String result = word;
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_big_amount() {
            int money = 999_999;
            List<Integer> result = List.of(19, 4, 1, 4, 1, 4, 1, 4, 9);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_small_amount() {
            int money = 1;
            List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_amount_under1_exception() {
            int money = 0;
            List<Integer> result = null;
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_amount_over1000000_exception() {
            int money = 1000001;
            List<Integer> result = null;
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
