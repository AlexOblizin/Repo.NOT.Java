package HomeWorks.Nasledovanie.Test;

public class Point {
    int id = count;
    static int count;
    int x,y;
    final String type = "Точка";

    Point(int x, int y){
        count++;
        this.x = x;
        this.y = y;
        printInfo();
    }

//    public int getIdAndCount(){
//        count++;
//        System.out.println("Создан объект #" + count);
//        System.out.println("Геометрическая фигура: " + type);
//        GeometryLoader.nameFigure(id);
//        return id;
//
//    }

    public void printInfo() {
        System.out.println("Я " + getType() + " и мой номер " + id);
    }

    public String getType() {
        return type;
    }
}