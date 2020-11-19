package HomeWorks.Nasledovanie.Test.Sold;

public class JigSaw extends PowerTool {
    double maxW;

    public JigSaw(String name, int powerConsumption, double maxW, int quantity, int price) {

        super(name, powerConsumption, quantity, price);
        this.maxW = maxW;

    }

}
