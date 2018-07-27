package com.chenxin.web.async;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 12:28
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DifferentResultHolder differentResultHolder;

    @GetMapping(value = "/order")
    @ApiOperation(value = "同步")
    public String order() throws Exception {
        logger.info("主线程开始！");
        Thread.sleep(1000);

        logger.info("主线程返回！");
        return "success";
    }

    @GetMapping(value = "/order1")
    public Callable<String> order1() throws Exception{
        logger.info("主线程开始！");
        //单开一个县城
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始！");
                Thread.sleep(4000);
                logger.info("副线程返回！");
                return "success";
            }
        };

        logger.info("主线程返回！");
        return result;
    }

    @GetMapping(value = "/order2")
    public DeferredResult<String> order2() throws InterruptedException {
        logger.info("主线程开始！");
        String orderNum = RandomStringUtils.randomNumeric(8);
        //放到消息队列中去
        mockQueue.setPlaceOrder(orderNum);

        DeferredResult<String> result = new DeferredResult<>();
        differentResultHolder.getMap().put(orderNum,result);
        Thread.sleep(1000);

        logger.info("主线程返回！");
        return result;
    }



}
