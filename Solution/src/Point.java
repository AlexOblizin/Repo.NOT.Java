public class Point {
    static int id = 1;
    static int count;
    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getIdAndCount(){
        count++;
        System.out.println("Создан объект: " + count);
        System.out.print("Геометрическая фигура: ");
        GeometryLoader.nameFigure(id);
        return id;

    }
}
