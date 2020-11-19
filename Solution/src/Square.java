public class Square extends Point{
    static int id = 4;
    static int count;
    int lengthSq;

    Square(int x, int y, int lengthSq){
        super(x,y);
        this.lengthSq = lengthSq;
    }
    public int getIdAndCount(){
        count++;
        System.out.println("Создан объект: " + count);
        System.out.print("Геометрическая фигура: ");
        GeometryLoader.nameFigure(id);
        return id;

    }
}
