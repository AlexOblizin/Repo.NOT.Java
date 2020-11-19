package HomeWorks.Nasledovanie.Test;

import HomeWorks.Nasledovanie.Test.Point;

public class Rectangle extends Point {
    //    static int id = 3;
//    static int count;
    int length, width;
    final String type = "Прямоугольник";

    Rectangle (int x, int y, int length, int width){
        super(x,y);
        this.length = length;
        this.width = width;
    }

    public String getType() {
        return type;
    }

//    public int getIdAndCount(){
//        count++;
//        System.out.println("Создан объект: " + count);
//        System.out.print("Геометрическая фигура: ");
//        GeometryLoader.nameFigure(id);
//        return id;
//
//    }
}