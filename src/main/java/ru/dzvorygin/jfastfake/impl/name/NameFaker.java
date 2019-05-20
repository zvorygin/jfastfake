package ru.dzvorygin.jfastfake.impl.name;

import ru.dzvorygin.jfastfake.FastRandom;

import java.util.function.Supplier;

public interface NameFaker extends Supplier<FastRandom> {
    default String firstName() {
        return NameFakerImpl.FIRST_NAME.apply(get());
    }

    default String lastName() {
        return NameFakerImpl.LAST_NAME.apply(get());
    }

    default String title() {
        return NameFakerImpl.TITLE.apply(get());
    }
}
