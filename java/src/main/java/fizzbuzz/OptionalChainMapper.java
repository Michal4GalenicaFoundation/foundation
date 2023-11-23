package fizzbuzz;


import java.util.Optional;
import java.util.function.Function;

public class OptionalChainMapper implements Function<Integer, String> {
    private static final Function<Integer, Optional<String>> fizzer = i -> i % 3 == 0 ? Optional.of("fizz") : Optional.empty();
    private static final Function<Integer, Optional<String>> buzzer = i -> i % 5 == 0 ? Optional.of("buzz") : Optional.empty();
    private static final Function<Integer, Optional<String>> fizzbuzzer = i -> i % (5 * 3) == 0 ? Optional.of("fizzbuzz") : Optional.empty();

    @Override
    public String apply(Integer i) {
        return fizzbuzzer
                .apply(i)
                .or(() -> buzzer.apply(i))
                .or(() -> fizzer.apply(i))
                .orElseGet(() -> String.valueOf(i));
    }
}
