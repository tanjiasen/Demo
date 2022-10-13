package com.example.cusinfomanagesystem.Service;

import com.example.cusinfomanagesystem.Pojo.CustomerInfo;
import com.example.cusinfomanagesystem.result.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author CaoZiLiang
 * @date 2022/9/27 16:35
 */
public interface CustomerInfoService {
    ResponseResult selectAll(Integer pageNum,Integer pageSize,String search);

    ResponseResult deleteOne(Integer id);

    ResponseResult selectOne(Integer id);

    ResponseResult addCus(CustomerInfo customerInfo);

    ResponseResult updateCus(CustomerInfo customerInfo);

    ResponseResult uploadImg(MultipartFile img) throws IOException;
}
