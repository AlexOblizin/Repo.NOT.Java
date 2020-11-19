package HomeWorks.Nasledovanie.Test.Sold;

public abstract class Computer extends AbstractItem {
    int memory;
    int hardSpace;
    int numberCores;


    public Computer(String name, int quantity, int memory, int hardSpace, int numberCores, int price) {
        this.name = name;
        this.quantity = quantity;
        this.memory = memory;
        this.hardSpace = hardSpace;
        this.numberCores = numberCores;
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
