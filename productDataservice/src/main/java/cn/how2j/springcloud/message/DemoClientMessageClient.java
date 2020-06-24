package cn.how2j.springcloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by wanhongxu on 2020/6/24.
 */
public interface DemoClientMessageClient {

    @Output(value = "demoClientMQ")
    MessageChannel output();
}
