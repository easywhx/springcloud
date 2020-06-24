package cn.how2j.springcloud.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: SendMessageController <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/24 10:59 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@RestController
@EnableBinding(value = {DemoServiceMessageClient.class, DemoClientMessageClient.class})
public class SendMessageController {
    @Autowired
    private DemoServiceMessageClient demoServiceMessageClient;

    @GetMapping("/sendMessage")
    public void sendMessage(){
        demoServiceMessageClient.output().send(
                MessageBuilder.withPayload("This is a message from democlient").build()
        );
    }
}
