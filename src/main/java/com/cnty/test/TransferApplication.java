package com.cnty.test;

import com.cnty.test.server.Server;
import com.cnty.test.util.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/8 11:33
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@SpringBootApplication
public class TransferApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TransferApplication.class, args);
        // 获取ApplicationContext
        ApplicationContextUtil.setApplicationContext(context);
        // 启动Server服务
        new Server().start();
    }
}
