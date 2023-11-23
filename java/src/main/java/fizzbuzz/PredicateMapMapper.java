package fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMapMapper implements Function<Integer, String> {
    private static final Map<Predicate<Integer>, String> matcher2Value =
            new LinkedHashMap<>() {{
                put(isMultiple(5 * 3), "fizzbuzz");
                put(isMultiple(5), "buzz");
                put(isMultiple(3), "fizz");
            }};

    static private Predicate<Integer> isMultiple(Integer divisor) {
        class Matcher implements Predicate<Integer> {
            private final Integer divisor;

            Matcher(Integer divisor) {
                this.divisor = Objects.requireNonNull(divisor);
            }

            @Override
            public boolean test(Integer integer) {
                return integer % divisor == 0;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Matcher m) {
                    return Objects.equals(m.divisor, this.divisor);
                }
                return false;
            }

            @Override
            public int hashCode() {
                return divisor;
            }
        }

        return new Matcher(divisor);
    }


    @Override
    public String apply(Integer i) {
        String defaultValue = String.valueOf(i);
        return matcher2Value.keySet().stream()
                .filter(predicate -> predicate.test(i))
                .findFirst()
                .map(matcher2Value::get)
                .orElse(defaultValue);
    }
}
