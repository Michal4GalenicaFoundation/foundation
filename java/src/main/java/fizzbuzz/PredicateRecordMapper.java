package fizzbuzz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateRecordMapper implements Function<Integer, String> {
    static record MatcherAndValue(Predicate<Integer> matcher, String value) implements Predicate<Integer> {
        @Override
        public boolean test(Integer i) {
            return matcher.test(i);
        }
    }

    List<MatcherAndValue> matcherAndValues =
            List.of(new MatcherAndValue(isMultiple(5 * 3), "fizzbuzz"),
                    new MatcherAndValue(isMultiple(5), "buzz"),
                    new MatcherAndValue(isMultiple(3), "fizz"));

    @Override
    public String apply(Integer i) {
        String defaultValue = String.valueOf(i);
        return matcherAndValues.stream()
                .filter(predicate -> predicate.test(i))
                .findFirst()
                .map(MatcherAndValue::value)
                .orElse(defaultValue);
    }

    private Predicate<Integer> isMultiple(Integer divisor) {
        return i -> i % divisor == 0;
    }

}
