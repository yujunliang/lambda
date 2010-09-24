package functions.atomic;

import com.google.common.base.Function;
import composite.Country;
import functions.primitives.WithCountry;

public class GetCountry<T extends WithCountry> implements Function<T, Country> {

    @Override
    public Country apply(T t) {
        return t.getCountry();
    }
}