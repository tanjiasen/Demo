package com.example.cusinfomanagesystem.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
*
*  @author author
*/

public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1664267942160L;


    /**
    * 主键
    * 客户编号
    * isNullAble:0
    */
    private Integer customerId;

    /**
    * 照片
    * isNullAble:1
    */
    private String photo;

    /**
    * 姓名
    * isNullAble:1
    */
    private String name;

    /**
    * 性别
    * isNullAble:1
    */
    private String sex;

    /**
    * 出生日期
    * isNullAble:1
    */
    private Date birthdate;

    /**
    * 联系电话
    * isNullAble:1
    */
    private String telephone;

    /**
    * 邮箱地址
    * isNullAble:1
    */
    private String email;

    /**
    * 学历
    * isNullAble:1
    */
    private String education;

    /**
    * 身份证号码
    * isNullAble:1
    */
    private String id_number;

    /**
    * 客户单位
    * isNullAble:1
    */
    private String unit;

    /**
    * 客户经理
    * isNullAble:1
    */
    private String customer_manager;

    /**
    * 备注
    * isNullAble:1
    */
    private String remarks;



    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCustomer_manager() {
        return customer_manager;
    }

    public void setCustomer_manager(String customer_manager) {
        this.customer_manager = customer_manager;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
