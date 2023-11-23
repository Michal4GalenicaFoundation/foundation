package fizzbuzz;

import java.util.function.Function;

public class PatternMatchingMapper implements Function<Integer, String> {

    @Override
    public String apply(Integer i) {
        return switch (i) {
            case Integer in when in % 15 == 0 -> "fizzbuzz";
            case Integer in when in % 5 == 0 -> "buzz";
            case Integer in when in % 3 == 0 -> "fizz";
            default -> String.valueOf(i);
        };
    }
}
