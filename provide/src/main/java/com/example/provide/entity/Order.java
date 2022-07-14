package com.example.provide.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    /**
     * 订单id
     */
    private String id;

    /**
     * 操作步骤
     */
    private String desc;

    /**
     * 步骤构建方法
     * @param id 订单唯一标识
     * @param desc 步骤描述
     */
    public Order(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    /**
     * 构建订单的所有操作步骤：创建、支付、回调
     * @param id 订单唯一标识
     * @return 订单操作步骤列表
     */
    public static List<Order> buildOrderSteps(String id) {
        List<Order> orderSteps = new ArrayList<>();
        Order createStep = new Order(id, "create order");
        orderSteps.add(createStep);
        Order payStep = new Order(id, "pay order");
        orderSteps.add(payStep);
        Order callbackStep = new Order(id, "call back order");
        orderSteps.add(callbackStep);
        return orderSteps;
    }
}
