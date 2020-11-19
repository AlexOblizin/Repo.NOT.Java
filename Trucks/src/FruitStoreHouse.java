import java.util.List;

public class FruitStoreHouse {


        public void loadCargo(List<Plants> cargo){
            if (cargo.size() < 10){

                cargo.add(new Apple());
                cargo.add(new Orange());
                cargo.add(new Peach());

            }
            else {
                System.out.println("Нельзя добавлять груз. Грузовик полон.");
            }

        }
}
