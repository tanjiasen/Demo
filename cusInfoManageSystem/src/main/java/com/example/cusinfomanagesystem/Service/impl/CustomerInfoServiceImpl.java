package com.example.cusinfomanagesystem.Service.impl;


import com.example.cusinfomanagesystem.Mapper.CustomerInfoMapper;
import com.example.cusinfomanagesystem.Pojo.CustomerInfo;
import com.example.cusinfomanagesystem.Service.CustomerInfoService;
import com.example.cusinfomanagesystem.result.ResponseResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author CaoZiLiang
 * @date 2022/9/27 16:35
 */
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;


    @Override
    public ResponseResult selectAll(Integer pageNum,Integer pageSize,String search) {

        PageHelper.startPage(pageNum, pageSize);
        List<CustomerInfo> customerInfos = customerInfoMapper.selectAll(search);


        return new ResponseResult(200,"ture",customerInfos);
    }

    @Override
    public ResponseResult deleteOne(Integer id) {
        customerInfoMapper.deleteOne(id);
        return new ResponseResult(200,"yes",null);
    }

    @Override
    public ResponseResult selectOne(Integer id) {

        return new ResponseResult(200,"yes",customerInfoMapper.selectOne(id));
    }

    @Override
    public ResponseResult addCus(CustomerInfo customerInfo) {
        customerInfoMapper.insertCustomerInfo(customerInfo);
        return new ResponseResult(200,"msg","true");
    }

    @Override
    public ResponseResult updateCus(CustomerInfo customerInfo) {
         customerInfoMapper.updateCustomerInfo(customerInfo);
         return new ResponseResult(200,"msg","true");
    }

    @Override
    public ResponseResult uploadImg(MultipartFile img) throws IOException {
        if (img.isEmpty()) {
            return new ResponseResult(500,"false","上传文件不能为空");
        }
        // 获取文件名
        String filename = img.getOriginalFilename();
        System.out.println("文件名 = " + filename);
        // 获取文件后缀
        if (filename != null) {
            // 获取文件后缀
            String suffixName = filename.substring(filename.lastIndexOf("."));
            System.out.println("上传文件的后缀： " + suffixName);
            String checkStr = ".png,.jpg,.jpeg";
            boolean contains = checkStr.contains(suffixName);
            // 判断格式
            if (!contains) {
                return new ResponseResult(500,"错误",null);
            }

        // 文件上传之后的名字
        filename = UUID.randomUUID().toString().replace("-", "") + suffixName;
        // 文件上传后的路径（加上上传后的文件名字就是上传后的路径）
        // 将文件需要上传的路径加上日期，按照每个月创建一个文件夹

        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String filePath1 = null;
        try {
            filePath1 = ResourceUtils.getURL("classpath:").getPath()+"/static/upload_file/"+ datePath;
            // 文件夹，不存在就创建
            File file = new File(filePath1);
            if(!file.exists()){
                file.mkdirs();
            }
            System.out.println(filePath1);
            // 文件上传到指定路径
            img.transferTo(new File(filePath1+"/"+filename));
            System.out.println(ResourceUtils.getURL("classpath"));
            System.out.println(filePath1+"/"+filename);
            System.out.println("/upload_file/"+datePath+"/"+filename);
            String newURL = "/upload_file/"+datePath+"/"+filename;
            // 返回结果  回显

            return  new ResponseResult(200,"true","/upload_file/"+datePath+"/"+filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        return new ResponseResult();

        }





    }


