package components;

import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.Random;

public class NumberGenerator {
    private static Logger logger = LoggerFactory.getLogger(NumberGenerator.class);
    @ServiceActivator
    public Order numberGenerator(Order o){
        o.setNumber(new Random().nextInt());
        logger.info("Created "+ o);
        return o;
    }
}
