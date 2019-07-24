package com.codingapi.txlcn.tm.config;

import antlr.StringUtils;
import com.codingapi.txlcn.common.util.id.ModIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Heruixing
 * @version 1.0.0
 * @description：
 * @ClassName：${class}
 * @Date 12:34 2019/7/24
 */
@Component
public class MyModIdProvider implements ModIdProvider {

    private final static String id = UUID.randomUUID().toString();

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public String modId() {
        String applicationName = environment.getProperty("spring.application.name");
        applicationName = org.springframework.util.StringUtils.hasText(applicationName) ? applicationName : "application";
        return applicationName + ":" + serverProperties.getPort()+ "_"+ id;
    }
}