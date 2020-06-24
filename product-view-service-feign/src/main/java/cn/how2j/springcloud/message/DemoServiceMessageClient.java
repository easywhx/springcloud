package cn.how2j.springcloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * ClassName: DemoServiceMessageClient <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/24 10:56 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
public interface DemoServiceMessageClient {
    @Output("demoServiceMQ")
    MessageChannel output();
}
