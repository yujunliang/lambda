package functions.atomic;

import composite.Country;
import functions.primitives.WithCountry;

import java.util.function.Function;

public class GetCountry<T extends WithCountry> implements Function<T, Country> {

    @Override
    public Country apply(T t) {
        return t.getCountry();
    }
}