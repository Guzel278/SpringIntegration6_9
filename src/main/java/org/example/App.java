package org.example;
import  org.example.AppConfig;
import model.Drink;
import model.Drink.DrinkType;
import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class App {
    private static Logger logger =  LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        logger.info((ctx.getBean(AppConfig.Cafe.class).placeOrder(new Order(DrinkType.ESPRESSO)).toString()));
        logger.info((ctx.getBean(AppConfig.Cafe.class).placeOrder(new Order(DrinkType.LATTE)).toString()));
        logger.info((ctx.getBean(AppConfig.Cafe.class).placeOrder(new Order(DrinkType.ICED_LATTE)).toString()));
    }
}