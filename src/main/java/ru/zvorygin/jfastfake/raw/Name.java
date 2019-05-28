package ru.zvorygin.jfastfake.raw;

import ru.zvorygin.jfastfake.FastRandom;
import ru.zvorygin.jfastfake.RandomValueProvider;
import ru.zvorygin.jfastfake.impl.RandomResourceLine;

public enum Name implements RandomValueProvider {
    FIRST("ru/zvorygin/jfastfake/name/first.txt"),
    LAST("ru/zvorygin/jfastfake/name/last.txt"),
    PREFIX("ru/zvorygin/jfastfake/name/prefix.txt");

    private final RandomResourceLine delegate;

    Name(String resourceName) {
        this.delegate = new RandomResourceLine(resourceName);
    }

    @Override
    public String apply(FastRandom fastRandom) {
        return delegate.getRandomLine(fastRandom);
    }
}
