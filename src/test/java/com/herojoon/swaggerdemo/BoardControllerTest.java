package com.herojoon.swaggerdemo;

import com.herojoon.swaggerdemo.command.ListCommand;
import com.herojoon.swaggerdemo.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * API Docs를 위한 테스트 코드 작성
 */
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    private final String API_PATH = "/board";
    private final String API_NAME = "게시판";

    @Test
    @DisplayName(API_NAME + " 리스트 조회")
    void getList() throws Exception {

        // given
        given(boardService.getList(any(ListCommand.class))).willReturn(BoardReqRes.boards);

        // when
        ResultActions resultActions = mockMvc.perform(RestDocumentationRequestBuilders
                .get(API_PATH + "/list")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .params(BoardReqRes.listReq()));

        // then
        resultActions.andExpect(status().isOk())
                .andDo(document(API_NAME + " 리스트 조회",
                        resourceDetails().tag(API_NAME),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                parameterWithName("boardType").description("게시판 타입(`NOTICE`)").optional()
                                , parameterWithName("userNo").description("사용자No").optional()
                        ),
                        responseFields(
                                fieldWithPath("[]").type(JsonFieldType.ARRAY).description("게시판 리스트")
                                , fieldWithPath("[].boardNo").type(JsonFieldType.NUMBER).description("게시판 No")
                                , fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시판 타입")
                                , fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목")
                                , fieldWithPath("[].content").type(JsonFieldType.STRING).description("내용")
                                , fieldWithPath("[].userNo").type(JsonFieldType.NUMBER).description("사용자 No")
                                , fieldWithPath("[].nickname").type(JsonFieldType.STRING).description("닉네임").optional()
                                , fieldWithPath("[].creatAt").type(JsonFieldType.STRING).description("작성일")
                                , fieldWithPath("[].updateAt").type(JsonFieldType.STRING).description("수정일").optional()
                        )
                ));
    }
}
