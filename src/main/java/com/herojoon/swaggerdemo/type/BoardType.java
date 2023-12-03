package com.herojoon.swaggerdemo.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardType {

    NOTICE("공지");

    private final String typeStr;
}
