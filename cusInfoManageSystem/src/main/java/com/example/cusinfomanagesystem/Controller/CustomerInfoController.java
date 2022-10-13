package com.example.cusinfomanagesystem.Controller;

import com.example.cusinfomanagesystem.Pojo.CustomerInfo;
import com.example.cusinfomanagesystem.Service.CustomerInfoService;
import com.example.cusinfomanagesystem.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author CaoZiLiang
 * @date 2022/9/27 16:33
 */
@RestController
@RequestMapping("/customerInfo")
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @GetMapping("/selectAll")
    public ResponseResult selectAll(Integer pageNum, Integer pageSize,String search){
     return   customerInfoService.selectAll(pageNum,pageSize,search);
    }

    @GetMapping("/selectOne/{id}")
    public ResponseResult selectOne(@PathVariable Integer id){
        return   customerInfoService.selectOne(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseResult deleteOne(@PathVariable Integer id){
        return customerInfoService.deleteOne(id);
    }


    @PostMapping("/addCus")
    public ResponseResult addCus(@RequestBody CustomerInfo customerInfo){

        return   customerInfoService.addCus(customerInfo);
    }

    @PostMapping("/updateCus")
    public ResponseResult updateCus(@RequestBody CustomerInfo customerInfo){
        return   customerInfoService.updateCus(customerInfo);
    }

    @PostMapping("/upload")
    public ResponseResult uploadImg(@RequestParam("img") MultipartFile img) throws IOException {

        return customerInfoService.uploadImg(img);
    }
}
