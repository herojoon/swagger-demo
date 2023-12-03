package com.herojoon.swaggerdemo.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.herojoon.swaggerdemo.type.BoardType;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record ListCommand (

        BoardType boardType,
        Long userNo
) { }
