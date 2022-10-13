package com.example.cusinfomanagesystem.Mapper;

import com.example.cusinfomanagesystem.Pojo.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface CustomerInfoMapper {
    int insertCustomerInfo(CustomerInfo object);

    int updateCustomerInfo(CustomerInfo object);

    int update(CustomerInfo object);

    List<CustomerInfo> queryCustomerInfo(CustomerInfo object);


    List<CustomerInfo> selectAll(String search);

    void deleteOne(Integer id);

    CustomerInfo selectOne(@Param("id") Integer id);

}
