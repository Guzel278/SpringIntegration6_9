package model;
import model.Drink.DrinkType;

public class Order {
    private int number;
    private DrinkType type;

    public Order(DrinkType drinkType) {
    }

    public DrinkType getType() {
        return type;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
    @Override
    public String toString(){
        return "Order{" +
                "number=" + number +
                ", type=" + type +
                '}';
    }
}
