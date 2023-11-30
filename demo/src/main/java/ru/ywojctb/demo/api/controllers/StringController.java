package ru.ywojctb.demo.api.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ywojctb.demo.api.exceptions.BadRequestException;
import ru.ywojctb.demo.api.services.StringService;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StringController {

    private final StringService stringService;

    public static final String GET_STRING = "/";


    @GetMapping(GET_STRING)
    public ResponseEntity<Map<Character, Integer>> getCharacterFrequency(@RequestParam("string") String input) {

        if(input.isEmpty()) throw new BadRequestException("string can't be null");
        if(input.length() > 100) throw new BadRequestException("string size can't be higher than 100");

        return ResponseEntity.ok(stringService.countCharacters(input.toCharArray()));

    }

}
