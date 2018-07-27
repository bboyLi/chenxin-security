package com.chenxin.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.async.DeferredResult;

import javax.naming.Context;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 18:55
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DifferentResultHolder differentResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(()->{
            while(true){
                if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())){

                    String orderNum = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果方法："+orderNum);
                    differentResultHolder.getMap().get(orderNum).setResult("place order success");

                    mockQueue.setCompleteOrder(null);

                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
