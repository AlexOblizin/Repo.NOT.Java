public class Circle extends Point{
    static int id = 2;
    static int count;
    double rad;

    Circle(int x, int y, double rad){
        super(x,y);
        this.rad = rad;

    }
    public int getIdAndCount(){
        count++;
        System.out.println("Создан объект: " + count);
        System.out.print("Геометрическая фигура: ");
        GeometryLoader.nameFigure(id);
        return id;

    }
}
