package com.herojoon.swaggerdemo.service;

import com.herojoon.swaggerdemo.command.ListCommand;
import com.herojoon.swaggerdemo.dto.BoardDto;
import com.herojoon.swaggerdemo.type.BoardType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    public List<BoardDto> getList(ListCommand listCommand) {

        return Collections.singletonList(
                BoardDto.builder()
                        .boardNo(1L)
                        .boardType(listCommand.boardType())
                        .title("북클럽 회원 모집중")
                        .content("책을 좋아하는 누구나 환영")
                        .userNo(1004L)
                        .nickname("angel")
                        .creatAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build()
        );
    }
}
