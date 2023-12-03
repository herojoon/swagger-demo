package com.herojoon.swaggerdemo.controller;

import com.herojoon.swaggerdemo.command.ListCommand;
import com.herojoon.swaggerdemo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("board")
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list")
    public ResponseEntity<?> getList(
            ListCommand listCommand
    ) {

        return new ResponseEntity<>(boardService.getList(listCommand), HttpStatus.OK);
    }
}
