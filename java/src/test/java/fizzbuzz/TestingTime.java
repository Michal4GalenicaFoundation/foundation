package fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingTime {

    @Test
    void testOptionalChainMapper() {
        FizzBuzz fb = new FizzBuzzImpl(new OptionalChainMapper());
        assertFizzBuzz20(fb);
    }

    @Test
    void testPatternMatchingMapper() {
        FizzBuzz fb = new FizzBuzzImpl(new PatternMatchingMapper());
        assertFizzBuzz20(fb);
    }

    @Test
    void testPredicateMapMapper() {
        FizzBuzz fb = new FizzBuzzImpl(new PredicateMapMapper());
        assertFizzBuzz20(fb);
    }

    @Test
    void testPredicateRecordMapper() {
        FizzBuzz fb = new FizzBuzzImpl(new PredicateRecordMapper());
        assertFizzBuzz20(fb);
    }

    private static void assertFizzBuzz20(FizzBuzz fb) {
        String actual = fb.fizzBuzz(20);
        String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";

        Assertions.assertEquals(expected, actual);
    }
}
