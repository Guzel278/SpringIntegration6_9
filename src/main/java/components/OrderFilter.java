package components;

import model.Drink;
import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Filter;

public class OrderFilter {
    private static Logger logger = LoggerFactory.getLogger(OrderFilter.class);
    @Filter
    public boolean onlyHotFilter(Order order){
        boolean r = order.getType() != Drink.DrinkType.ICED_LATTE;
        if(!r){
            logger.info(order + " canceled");
        }
        return r;
    }
}
