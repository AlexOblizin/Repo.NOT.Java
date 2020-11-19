package HomeWorks.Nasledovanie.Test;

import HomeWorks.Nasledovanie.Test.Point;

public class Square extends Point {
    //    static int id = 4;
//    static int count;
    int lengthSq;
    final String type = "Квадрат";

    Square(int x, int y, int lengthSq){
        super(x,y);
        this.lengthSq = lengthSq;
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