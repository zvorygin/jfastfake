package ru.zvorygin.jfastfake;

@FunctionalInterface
public interface FastRandom {
    int nextInt(int origin, int bound);
}
