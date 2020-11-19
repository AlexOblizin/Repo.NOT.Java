package HomeWorks.Nasledovanie.Test.Sold;

public class Drill extends PowerTool implements Returnable {
    double maxD;
    boolean order;

    public Drill(String name, int powerConsumption, double maxD, int quantity, int price,
                 boolean order) {
        super(name, powerConsumption, quantity, price);
        this.maxD = maxD;
        this.order = order;

    }

    public String forReturn() {
        if (order) {

            return " Документы на возврат есть. Нужен чек.";

        } else {

            return " Документов на возврат на данный момент нет.";

        }
    }

    public int getDay2Return() {

        return days2Return;

    }
}
