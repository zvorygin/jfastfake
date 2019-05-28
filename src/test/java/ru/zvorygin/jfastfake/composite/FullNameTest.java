package ru.zvorygin.jfastfake.composite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FullNameTest {

    @Test
    void apply() {
        Assertions.assertEquals(FullName.INSTANCE.apply((origin, bound) -> 1), "Aarav Acevedo");
        Assertions.assertEquals(FullName.INSTANCE.apply((origin, bound) -> 2), "Aaron Acosta");
    }

}
