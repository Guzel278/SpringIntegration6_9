package model;

public class Drink {
    DrinkType type;
    protected  int coffee, milk, ice;
    public enum DrinkType {
        ESPRESSO,
        LATTE,
        ICED_LATTE
    }
    public  Drink(DrinkType type){
        this.type = type;
    }
    public void addCoffee(){
        coffee++;
    }
    public void addIce(){
        ice++;
    }
    public void addMilk(){
        milk++;
    }
    @Override
    public String toString(){
        return "Drink{" +
                "type=" + type +
                ", coffee=" + coffee +
                ", milk=" + milk +
                ", ice=" + ice +
                '}';
    }

}
