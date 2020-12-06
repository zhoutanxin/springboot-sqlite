package com.yun300.fieldnote.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

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


    /**
     * 获取对象json Map
     *
     * @param object 要生成json格式的对象
     * @return 符合javashop规范的json map: {"result":1,"data":""}
     */
    public static JsonResult getObjectJson(Object object) {

        JsonResult result = new JsonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setData(object);

        return result;

    }

    /**
     * 获取对象json Map
     *
     * @param object 要生成json格式的对象
     * @return 符合javashop规范的json map: {"result":1,"data":""}
     * @objectName object的key名称
     */
    public static JsonResult getObjectJson(Object object, String objectName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(objectName, object);
        JsonResult result = new JsonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setData(map);
        return result;

    }

    /**
     * 获取对象 json
     *
     * @param object  数据
     * @param message 消息
     * @return
     */
    public static JsonResult getObjectMessageJson(Object object, String message) {

        JsonResult result = new JsonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(object);

        return result;

    }

    /**
     * 获得对象json Integer
     *
     * @param name 数值key名
     * @param num  值
     * @return 符合javashop规范的json map: {"result":1,"data":num}
     */
    public static JsonResult getNumberJson(String name, int num) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(name, num);

        JsonResult result = new JsonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setData(map);

        return result;

    }

    /**
     * 获取成功状态的json Map
     *
     * @param message 要返回的信息
     * @return 符合javashop规范的json map: {"result":1,"message":""}
     */
    public static JsonResult success(String message) {

        JsonResult result = new JsonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(message);

        return result;
    }

    /**
     * 获取失败状态的json Map
     * 默认返回HTTP状态 500
     *
     * @param message 要返回的信息
     * @return
     */
    public static JsonResult error(String message) {

        JsonResult result = new JsonResult();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(message);

        return result;

    }


    /**
     * 获取失败状态与HTTP状态码的json Map
     *
     * @param message 要返回的信息
     * @return
     */
    public static JsonResult getErrorJson(String message, HttpStatus httpStatus) {

        JsonResult result = new JsonResult();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(message);

        return result;

    }
}
