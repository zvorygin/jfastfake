package ru.zvorygin.jfastfake.composite;

import ru.zvorygin.jfastfake.ConstantValueProvider;
import ru.zvorygin.jfastfake.FastRandom;
import ru.zvorygin.jfastfake.RandomValueProvider;
import ru.zvorygin.jfastfake.RandomValueProviderRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractCompositeRandomValueProvider implements RandomValueProvider {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\$\\{([a-zA-Z0-9.]*)}");

    private final List<RandomValueProvider> delegates;

    private final int maxLength;

    public AbstractCompositeRandomValueProvider(String template, RandomValueProviderRegistry registry) {
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(template);
        int currentPosition = 0;
        int currentMaxLength = 0;
        delegates = new ArrayList<>();
        while (matcher.find()) {
            if (currentPosition < matcher.start()) {
                delegates.add(new ConstantValueProvider(template.substring(currentPosition, matcher.start())));
                currentMaxLength += matcher.start() - currentPosition;
            }
            RandomValueProvider delegate = registry.apply(matcher.group(1));
            delegates.add(delegate);
            currentMaxLength += delegate.getMaxLength();
            currentPosition = matcher.end();
        }

        if (currentPosition < template.length()) {
            delegates.add(new ConstantValueProvider(template.substring(currentPosition)));
            currentMaxLength += template.length() - currentPosition;
        }
        maxLength = currentMaxLength;
    }

    @Override
    public String apply(FastRandom fastRandom) {
        StringBuilder sb = new StringBuilder(maxLength);
        for (RandomValueProvider delegate : delegates) {
            sb.append(delegate.apply(fastRandom));
        }
        return sb.toString();
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }
}
