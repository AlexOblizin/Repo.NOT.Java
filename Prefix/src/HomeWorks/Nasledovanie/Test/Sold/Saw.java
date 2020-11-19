package HomeWorks.Nasledovanie.Test.Sold;

public class Saw extends PowerTool implements Returnable {
    double rad;
    boolean order;
    boolean passport;

    public Saw(String name, int powerConsumption, double rad, int quantity, int price,
               boolean order, boolean passport) {

        super(name, powerConsumption, quantity, price);
        this.rad = rad;
        this.order = order;
        this.passport = passport;

    }


        public String forReturn() {

        if (order && passport) {

            return " Документы на возврат есть. Нужен чек и паспорт.";

        } else {

            return " Документов на возврат на данный момент нет.";

        }
    }

    public int getDay2Return() {

        return days2Return * 2;
    }

}
