package cn.how2j.springcloud.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by wanhongxu on 2020/6/24.
 */
public interface DemoServiceMessageClient {

    @Input("demoServiceMQ")
    SubscribableChannel input();
}
