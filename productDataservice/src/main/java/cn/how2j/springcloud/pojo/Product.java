package cn.how2j.springcloud.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Created by wanhongxu on 2020/3/31.
 */
@Getter
@Setter
@Slf4j
public class Product {

    private int id;
    private String name;
    private int price;

    public Product() {
    }
    public Product(int id, String name, int price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }



}
