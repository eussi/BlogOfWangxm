package com.eussi.blog;

import com.eussi.blog.base.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SprintBootApplication
 */
@Slf4j
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.eussi.blog.modules.dao")
public class BootApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootApplication.class, args);
        String serverPort = context.getEnvironment().getProperty("server.port");
        if(log.isInfoEnabled()) {
            log.info("Wangxueming's site started at http://{}:{}", CommonUtils.ipToIPv4Str(CommonUtils.getIP()), serverPort);
        }
    }

}