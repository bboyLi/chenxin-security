package com.chenxin.security.browser.support;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin
 * @version 1.0
 * @since 2018/7/27 21:44
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
