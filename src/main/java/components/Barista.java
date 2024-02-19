package components;

import model.Drink;
import model.Drink.DrinkType;
import model.Order;
import org.springframework.integration.annotation.Transformer;

public class Barista {
    @Transformer
    public Drink orderToDrink(Order o){
        Drink drink = new Drink(o.getType());
        drink.addCoffee();
        if(o.getType() == DrinkType.ICED_LATTE || o.getType() == DrinkType.LATTE){
            drink.addMilk();
        }
        if(o.getType() == DrinkType.ICED_LATTE){
            drink.addIce();
        }
        return  drink;
    }
}
