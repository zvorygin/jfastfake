package ru.zvorygin.jfastfake;

public class ConstantValueProvider implements RandomValueProvider {
    private final String value;

    public ConstantValueProvider(String value) {
        this.value = value;
    }

    @Override
    public String apply(FastRandom fastRandom) {
        return value;
    }

    @Override
    public int getMaxLength() {
        return value.length();
    }
}
