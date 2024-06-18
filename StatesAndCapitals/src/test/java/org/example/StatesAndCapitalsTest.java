package org.example;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class StatesAndCapitalsTest {

    /**
     * Test to check if valid state names return correct capitals.
     */
    @Test
    public void testValidState() {
        assertEquals("The capital of Alabama is Montgomery.", StatesAndCapitals.getCapital("Alabama"));
        assertEquals("The capital of Alaska is Juneau.", StatesAndCapitals.getCapital("Alaska"));
    }

    /**
     * Test to check if invalid state names return the correct error message.
     */
    @Test
    public void testInvalidState() {
        assertEquals("No such State.", StatesAndCapitals.getCapital("InvalidState"));
    }

    /**
     * Test to check if the map contains all 50 states.
     */
    @Test
    public void testAllStates() {
        Map<String, String> map = StatesAndCapitals.getStatesAndCapitals();
        assertEquals(50, map.size());
        assertEquals("Cheyenne", map.get("Wyoming"));
    }

    /**
     * Test to check if input with leading and trailing whitespace is handled correctly.
     */
    @Test
    public void testWhitespaceInput() {
        assertEquals("The capital of Alabama is Montgomery.", StatesAndCapitals.getCapital("  Alabama  "));
    }

    /**
     * Test to check if input is case-insensitive.
     */
    @Test
    public void testCaseInsensitiveInput() {
        assertEquals("The capital of Alabama is Montgomery.", StatesAndCapitals.getCapital("alabama"));
        assertEquals("The capital of Alaska is Juneau.", StatesAndCapitals.getCapital("aLaSkA"));
    }

    /**
     * Test to check if empty input is handled correctly.
     */
    @Test
    public void testEmptyInput() {
        assertEquals("Invalid input. Please enter a valid state name.", StatesAndCapitals.getCapital(""));
    }

    /**
     * Test to check if null input is handled correctly.
     */
    @Test
    public void testNullInput() {
        assertEquals("Invalid input. Please enter a valid state name.", StatesAndCapitals.getCapital(null));
    }
}
