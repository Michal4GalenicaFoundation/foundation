package fizzbuzz;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzImpl implements FizzBuzz {

    private final Function<Integer, String> mapper;

    static public FizzBuzz create(Function<Integer, String> mapper) {
        return new FizzBuzzImpl(mapper);
    }

    public FizzBuzzImpl(Function<Integer, String> mapper) {
        this.mapper = Objects.requireNonNull(mapper);
    }

    @Override
    public String fizzBuzz(int n) {
        return IntStream.range(1, n + 1).boxed().map(mapper).collect(Collectors.joining(" "));
    }
}
