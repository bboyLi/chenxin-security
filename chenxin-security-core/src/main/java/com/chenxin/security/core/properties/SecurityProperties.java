package com.chenxin.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin
 * @version 1.0
 * @since 2018/7/28 1:05
 */
@ConfigurationProperties(prefix = "chenxin.security")
@Data
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
}
