package HomeWorks.Nasledovanie.Test.Sold;

abstract class AbstractItem implements Item {
    String name;
    static int count;
    int quantity;
    int price;

    public AbstractItem(){

    }

    public AbstractItem(String name, int quantity, int price) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
        count++;

    }

    public String getName(){

        return name;

    }

    public static int getCount(){

        return count;

    }
    public int getQuantity(){

        return quantity;

    }

    public int getPrice(){

        return price;

    }


}
