package HomeWorks.Nasledovanie.Test;


public class Geometry {
    public static void main(String[] args) {
//        System.out.println("\tИдентификаторы объектов: ");
//        System.out.println("1 - точка");
//        System.out.println("2 - круг");
//        System.out.println("3 - прямоугольник");
//        System.out.println("4 - квадрат\n");

        Point p1 = new Point(12,12);
        Point p2 = new Point(11,10);
//        System.out.println(p1.getIdAndCount());
//        System.out.println(p2.getIdAndCount());
//        System.out.println();

        Square s1 = new Square(11,12,35);
        Square s2 = new Square(10,1,15);
//        System.out.println(s1.getIdAndCount());
//        System.out.println(s2.getIdAndCount());
//        System.out.println();

        Circle c1 = new Circle(12,12,125.0);
        Circle c2 = new Circle(11,10,12.0);
//        System.out.println(c1.getIdAndCount());
//        System.out.println(c2.getIdAndCount());
//        System.out.println();

        Rectangle r1 = new Rectangle(12,12,32,121);
        Rectangle r2 = new Rectangle(11,10,132,111);
//        System.out.println(r1.getIdAndCount());
//        System.out.println(r2.getIdAndCount());
//        System.out.println();

    }
//    static void nameFigure(int id){
//             if (id == 1) System.out.print(" точка - индентификатор: ");
//        else if (id == 2) System.out.print(" круг - индентификатор: ");
//        else if (id == 3) System.out.print(" прямоугольник - индентификатор: ");
//        else if (id == 4) System.out.print(" квадрат - индентификатор: ");
//    }
}