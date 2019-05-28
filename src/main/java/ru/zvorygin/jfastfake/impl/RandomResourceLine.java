package ru.zvorygin.jfastfake.impl;

import ru.zvorygin.jfastfake.FastRandom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RandomResourceLine {
    private final String[] data;

    private final int maxLength;

    public RandomResourceLine(String resourceName) {
        try (InputStream is = Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName),
                () -> String.format("Failed to find resource [%s]", resourceName));
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            List<String> buffer = new ArrayList<>();
            String line;
            int currentMaxLength = 0;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    buffer.add(line);
                    currentMaxLength = Math.max(currentMaxLength, line.length());
                }
            }

            if (buffer.isEmpty()) {
                throw new IllegalStateException(String.format("No lines in resource [%s]", resourceName));
            }

            data = buffer.toArray(new String[0]);
            maxLength = currentMaxLength;
        } catch (IOException e) {
            throw new IllegalStateException(String.format("Failed to initialize with resource [%s]", resourceName), e);
        }
    }

    public String getRandomLine(FastRandom random) {
        return data[random.nextInt(0, data.length)];
    }

    public int getMaxLength() {
        return maxLength;
    }
}
