package cn.how2j.springcloud.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
@Setter
@Getter
public class Role {
    private Integer id;

    private String enName;

    private String name;
}