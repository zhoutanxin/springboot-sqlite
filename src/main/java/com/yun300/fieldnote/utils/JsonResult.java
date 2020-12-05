package com.yun300.fieldnote.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {

    /**
     * 请求结果，0为失败，1为成功
     */
    @ApiModelProperty(value = "请求结果编码")
    private Integer code;

    /**
     * 请求结果提示信息
     */
    @ApiModelProperty(value = "请求结果提示信息")
    private String message;

    /**
     * 请求返回的数据对象，也将被转为json格式
     */
    @ApiModelProperty(value = "请求返回的数据")
    private T data;

}
