package com.example.cusinfomanagesystem.result;

import com.example.cusinfomanagesystem.Pojo.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author CaoZiLiang
 * @date 2022/9/27 17:02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T>  implements Serializable  {
    private int code;
    private String msg;
    private T data;


}
