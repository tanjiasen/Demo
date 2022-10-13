package com.example.cusinfomanagesystem.Configeration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.HashMap;
@Configuration
public class DruidConf {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDatasource()
    {
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        HashMap<String,String> initParameters=new HashMap<>();
        initParameters.put("loginUsername","root");
        initParameters.put("loginPassword","root");
        initParameters.put("allow","");
        bean.setInitParameters(initParameters);
        return bean;

    }
}
