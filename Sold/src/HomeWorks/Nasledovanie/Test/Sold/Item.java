package HomeWorks.Nasledovanie.Test.Sold;

public interface Item {

      int count = 0;

    static int getCount(){
        return count;
    }
    
    String getName();
    
    int getQuantity();

    int getPrice();

}
