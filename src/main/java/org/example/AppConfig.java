package org.example;

import components.Barista;
import components.NumberGenerator;
import components.OrderFilter;
import model.Drink;
import model.Order;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DirectChannel requestChannel(){
        return new DirectChannel();
    }
    @Bean
    public Barista barista() {
        return new Barista();
    }
    @Bean
    public OrderFilter ordersFilter(){
        return new OrderFilter();
    }
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGenerator();
    }
    @MessagingGateway
    public interface  Cafe {
        @Gateway(requestChannel = "requestChannel")
        Drink placeOrder(Order order);
    }
    @Bean
    public  IntegrationFlow placeOrder(){
        return IntegrationFlows.from(requestChannel()).handle(numberGenerator()).filter(ordersFilter()).transform(barista()).get();
    }

}