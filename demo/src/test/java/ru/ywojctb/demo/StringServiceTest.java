package ru.ywojctb.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ywojctb.demo.api.services.StringService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringServiceTest {


    private StringService stringService;

    @BeforeEach
    public void constructor() {
        stringService = new StringService();
    }

    @Test
    public void testEmptyCount() {
        char[] characters = {};
        Map<Character, Integer> res = stringService.countCharacters(characters);
        assertTrue(res.isEmpty());
    }

    @Test
    public void testCount() {
        char[] characters = {'a', 'b', 'a', 'a', 'b', 'b', 'a'};
        Map<Character, Integer> expect = new HashMap<>();
        expect.put('a', 4);
        expect.put('b', 3);
        Map<Character, Integer> res = stringService.countCharacters(characters);
        assertTrue(res.equals(expect));
    }
}
