import java.util.List;

public class VegStoreHouse {

    public void loadCargo(List<Plants> cargo) {
        if (cargo.size() < 10) {

            cargo.add(new Carrot());
            cargo.add(new Potato());
            cargo.add(new Tomat());

        }
        else {
            System.out.println("Нельзя добавлять груз. Грузовик полон.");
        }

    }

}
