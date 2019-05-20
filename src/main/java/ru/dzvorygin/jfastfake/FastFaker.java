package ru.dzvorygin.jfastfake;

import ru.dzvorygin.jfastfake.impl.name.NameFaker;

public final class FastFaker implements NameFaker {

    private final FastRandom fastRandom;

    public FastFaker(FastRandom fastRandom) {
        this.fastRandom = fastRandom;
    }

    @Override
    public FastRandom get() {
        return fastRandom;
    }
}
