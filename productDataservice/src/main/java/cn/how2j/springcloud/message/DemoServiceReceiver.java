package cn.how2j.springcloud.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * ClassName: DemoServiceReceiver <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/24 10:54 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@Slf4j
@Component
@EnableBinding(value = {DemoServiceMessageClient.class, DemoClientMessageClient.class})
public class DemoServiceReceiver {


    @StreamListener("demoServiceMQ")
    @SendTo("demoClientMQ")
    public String process(Object message) {
        log.info("Messages received by the DemoService:{}", message);
        return "This is DemoServiceReceiver's reply";
    }
}
