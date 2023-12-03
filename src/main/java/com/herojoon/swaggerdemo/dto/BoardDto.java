package com.herojoon.swaggerdemo.dto;

import com.herojoon.swaggerdemo.type.BoardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardDto {

    Long boardNo;
    BoardType boardType;
    String title;
    String content;
    Long userNo;
    String nickname;
    LocalDateTime creatAt;
    LocalDateTime updateAt;
}
