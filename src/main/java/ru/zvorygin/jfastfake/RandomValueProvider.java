package ru.zvorygin.jfastfake;

import java.util.function.Function;

@FunctionalInterface
public interface RandomValueProvider extends Function<FastRandom, String> {
    default int getMaxLength() {
        return 0;
    }
}
