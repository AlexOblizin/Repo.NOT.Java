package HomeWorks.Nasledovanie.Test.Sold;

public abstract class PowerTool extends AbstractItem {
    int powerConsumption;


    public PowerTool(String name, int powerConsumption, int quantity, int price) {

        super(name, quantity, price);
        this.powerConsumption = powerConsumption;


    }

    public String getName() {

        return name;

    }

    public int getQuantity() {

        return quantity;

    }

    public int getPrice(){

        return price;

    }

}
