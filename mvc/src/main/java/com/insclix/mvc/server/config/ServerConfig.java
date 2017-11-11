package com.insclix.mvc.server.config;

import com.expansel.errai.spring.server.ErraiRequestDispatcherFactoryBean;
import com.expansel.errai.spring.server.ErraiServerMessageBusFactoryBean;
import org.jboss.errai.bus.client.api.messaging.RequestDispatcher;
import org.jboss.errai.bus.server.api.ServerMessageBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;

public class ServerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ServerConfig.class);

    @Bean
    public FactoryBean<ServerMessageBus> erraiServerMessageBusFactoryBean() {
        logger.info("Creating Errai ServiceMessageBus FactoryBean");
        return new ErraiServerMessageBusFactoryBean();
    }

    @Bean
    public FactoryBean<RequestDispatcher> erraiRequestDispatcherFactoryBean() {
        logger.info("Creating Errai RequestDispatcher FactoryBean");
        return new ErraiRequestDispatcherFactoryBean();
    }
}
