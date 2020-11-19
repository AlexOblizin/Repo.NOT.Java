import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vegetables> truckVeg = new ArrayList<>(10);
        List<Fruits> truckFrt = new ArrayList<>(10);

        Orange orange = new Orange();
        Apple apple = new Apple();
        Peach peach = new Peach();
        Potato potato = new Potato();
        Carrot carrot = new Carrot();
        Tomat tomat = new Tomat();

        Warehouse<Fruits> fruitsHouse1 = new Warehouse<>(apple);
        Warehouse<Fruits> fruitsHouse2 = new Warehouse<>(peach);
        Warehouse<Fruits> fruitsHouse3 = new Warehouse<>(orange);
        Warehouse<Vegetables> vegHouse1 = new Warehouse<>(potato);
        Warehouse<Vegetables> vegHouse2 = new Warehouse<>(carrot);
        Warehouse<Vegetables> vegHouse3 = new Warehouse<>(tomat);

        fruitsHouse1.loadCargo(truckFrt);
        fruitsHouse2.loadCargo(truckFrt);
        fruitsHouse3.loadCargo(truckFrt);


        vegHouse1.loadCargo(truckVeg);
        vegHouse2.loadCargo(truckVeg);
        vegHouse3.loadCargo(truckVeg);

        FoodShop.printCargo(truckFrt);
        FoodShop.printCargo(truckVeg);




    }
}
