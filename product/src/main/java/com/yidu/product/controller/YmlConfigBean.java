package com.yidu.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 获取配置信息的类
 */
@Component
@RefreshScope //实现热加载
public class YmlConfigBean {

    @Value("${spring.datasource.url}") //Value注解表示读取yml配置文件中的内容
    private String url ; //数据库url

    @Value("${spring.datasource.username}")
    private String userName ; //数据库用户名

    @Value("${spring.datasource.password}")
    private String password ; //数据库密码

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "YmlConfigBean{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
