import java.util.List;

public class FoodShop {

    public static <P extends Plants> void printCargo(List<P> cargo){

            cargo.forEach(plant -> System.out.println(plant.getName()));
    }
}
