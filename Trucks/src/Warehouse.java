import java.util.List;

public class Warehouse<T> {

    private final T type;

    public Warehouse(T type) {
        this.type = type;
    }

    public void loadCargo(List<T> cargo) {
        if (cargo.size() < 10) {
            cargo.add((T) generatePlant());
        }
    }

    private Plants generatePlant() {
        if(type instanceof Orange) {
            return new Orange();
        } else if (type instanceof Peach) {
            return new Peach();
        } else if (type instanceof Apple) {
            return new Apple();
        } else if (type instanceof Potato) {
            return new Potato();
        } else if (type instanceof Tomat) {
            return new Tomat();
        } else if (type instanceof Carrot) {
            return new Carrot();
        }
        return null;
    }
}
