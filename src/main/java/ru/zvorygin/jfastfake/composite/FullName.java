package ru.zvorygin.jfastfake.composite;

import ru.zvorygin.jfastfake.RandomValueProviderRegistry;
import ru.zvorygin.jfastfake.raw.StdRawValueProviderRegistry;

public class FullName extends AbstractCompositeRandomValueProvider {
    public static FullName INSTANCE = new FullName(StdRawValueProviderRegistry.getInstance());

    public FullName(RandomValueProviderRegistry registry) {
        super("${name.first} ${name.last}", registry);
    }
}
