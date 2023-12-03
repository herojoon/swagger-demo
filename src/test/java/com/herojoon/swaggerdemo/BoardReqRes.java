package com.herojoon.swaggerdemo;

import com.herojoon.swaggerdemo.dto.BoardDto;
import com.herojoon.swaggerdemo.type.BoardType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class BoardReqRes {

    // TODO Custom Header 추가하여 사용 가능.

    /**
     * 게시판 리스트 요청 Params
     */
    static MultiValueMap<String, String> listReq() {
        MultiValueMap<String, String> listReq = new LinkedMultiValueMap<>();
        listReq.add("boardType", BoardType.NOTICE.name());
        listReq.add("userNo", "1004");
        return listReq;
    }

    /**
     * 게시판 리스트 응답
     */
    static List<BoardDto> boards = Collections.singletonList(
                                        BoardDto.builder()
                                        .boardNo(1L)
                                        .boardType(BoardType.NOTICE)
                                        .title("보드게임 회원 보집중")
                                        .content("보드게임을 좋아하는 누구나 환영")
                                        .userNo(1004L)
                                        .nickname("angel")
                                        .creatAt(LocalDateTime.now())
                                        .updateAt(LocalDateTime.now())
                                        .build()
                                    );
}
