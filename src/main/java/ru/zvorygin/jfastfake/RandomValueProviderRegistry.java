package ru.zvorygin.jfastfake;

import java.util.function.Function;

public interface RandomValueProviderRegistry extends Function<String, RandomValueProvider> {
}
