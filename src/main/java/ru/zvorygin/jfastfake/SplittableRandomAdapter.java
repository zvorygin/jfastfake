package ru.zvorygin.jfastfake;

import java.util.SplittableRandom;

public class SplittableRandomAdapter implements FastRandom {

    private final SplittableRandom impl;

    public SplittableRandomAdapter(SplittableRandom impl) {
        this.impl = impl;
    }

    @Override
    public int nextInt(int origin, int bound) {
        return impl.nextInt(origin, bound);
    }
}
