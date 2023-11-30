package ru.ywojctb.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.ywojctb.demo.api.controllers.StringController;
import ru.ywojctb.demo.api.exceptions.BadRequestException;
import ru.ywojctb.demo.api.services.StringService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringControllerTest {
    private StringController stringController;

    @Mock
    private StringService stringService;

    @BeforeEach
    public void constructor() {
        MockitoAnnotations.openMocks(this);
        stringController = new StringController(stringService);
    }

    @Test
    public void testCount() {
        String string = "aabbbccc";

        Map<Character, Integer> expect = new HashMap<>();
        expect.put('a', 2);
        expect.put('b', 3);
        expect.put('c', 3);


        Mockito.when(stringService.countCharacters(Mockito.any())).thenReturn(expect);

        ResponseEntity<Map<Character, Integer>> res = stringController.getCharacterFrequency(string);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(res.getBody(), expect);
    }

    @Test
    public void testEmptyString() {

        String s = "";

        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
                    ResponseEntity<Map<Character, Integer>> res = stringController.getCharacterFrequency(s);
                }, "string can't be null");

        Assertions.assertEquals("string can't be null", exception.getMessage());
    }


}
