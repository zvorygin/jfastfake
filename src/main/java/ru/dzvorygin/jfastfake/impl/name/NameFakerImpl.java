package ru.dzvorygin.jfastfake.impl.name;

import ru.dzvorygin.jfastfake.FastRandom;

import java.util.function.Function;

public enum NameFakerImpl implements Function<FastRandom, String> {
    FIRST_NAME,
    LAST_NAME,
    TITLE;

    @Override
    public String apply(FastRandom fastRandom) {
        return null;
    }
}
