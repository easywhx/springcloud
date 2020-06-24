package cn.how2j.springcloud.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by wanhongxu on 2020/6/24.
 */
public interface DemoClientMessageClient {
    @Input("demoClientMQ")
    SubscribableChannel input();
}
