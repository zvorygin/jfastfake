package ru.zvorygin.jfastfake.raw;

import ru.zvorygin.jfastfake.RandomValueProvider;
import ru.zvorygin.jfastfake.RandomValueProviderRegistry;

import java.util.HashMap;
import java.util.Map;

public class StdRawValueProviderRegistry implements RandomValueProviderRegistry {
    private static final StdRawValueProviderRegistry INSTANCE = new StdRawValueProviderRegistry();

    private final Map<String, RandomValueProvider> registry;

    public static StdRawValueProviderRegistry getInstance() {
        return INSTANCE;
    }

    public StdRawValueProviderRegistry() {
        registry = new HashMap<>();
        registry.put("name.first", Name.FIRST);
        registry.put("name.last", Name.LAST);
        registry.put("name.prefix", Name.PREFIX);
    }

    @Override
    public RandomValueProvider apply(String key) {
        return registry.get(key);
    }
}
