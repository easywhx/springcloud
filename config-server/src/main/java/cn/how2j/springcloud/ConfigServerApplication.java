package cn.how2j.springcloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wanhongxu on 2020/3/31.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableConfigServer
@EnableDiscoveryClient
@EnableEurekaClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        int port = 8030;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ConfigServerApplication.class).properties("server.port=" + port).run(args);

    }
}
