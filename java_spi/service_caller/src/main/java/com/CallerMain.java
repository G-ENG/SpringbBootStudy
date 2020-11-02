package com;

import com.service.PayService;

import java.util.ServiceLoader;

/**
 * spi可插拔的模式
 * 在 pom中依赖 aliPay或 WxPay，实现插拔式的 pay_service实现
 *
 * @Author GenG
 * @Date 2020/10/26
 **/
public class CallerMain {
    public static void main(String[] args) {
        ServiceLoader<PayService> load = ServiceLoader.load(PayService.class);
        load.forEach(PayService::pay);
    }
}
