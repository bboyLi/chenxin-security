package com.chenxin.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 18:47
 */
@Component
public class DifferentResultHolder {

    private Map<String,DeferredResult<String>> map = new HashMap<>();

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }
}
