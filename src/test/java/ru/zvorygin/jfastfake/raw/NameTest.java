package ru.zvorygin.jfastfake.raw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void apply() {
        Assertions.assertEquals(Name.FIRST.apply((origin, bound) -> 1), "Aarav");
        Assertions.assertEquals(Name.FIRST.apply((origin, bound) -> 2), "Aaron");

        Assertions.assertEquals(Name.LAST.apply((origin, bound) -> 1), "Acevedo");
        Assertions.assertEquals(Name.LAST.apply((origin, bound) -> 2), "Acosta");

        Assertions.assertEquals(Name.PREFIX.apply((origin, bound) -> 1), "Miss");
        Assertions.assertEquals(Name.PREFIX.apply((origin, bound) -> 2), "Mr.");
    }
}