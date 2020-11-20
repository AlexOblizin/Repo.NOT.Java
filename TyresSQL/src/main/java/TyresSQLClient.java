import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class TyresSQLClient {


    public static void main(String args[]) {
    try {
        Input.createTables();

        Input.fulfillCustomers(1, "Alexey", "+79877897887", "aaa",15);
        Input.fulfillCustomers(2, "Irina", "+79502581779", "aaa",5);
        Input.fulfillCustomers(3, "Sergey", "+79264561937", "aaa",7);

        Input.fulfillTyres(1, 75, 275, 21, "NOKIAN", "all seasons", 75000);
        Input.fulfillTyres(2, 55, 230, 16, "BRIDGESTONE", "winter", 50000);
        Input.fulfillTyres(3, 60, 255, 17, "MICHELIN", "summer", 60000);

        Input.transactions(1,1,2,4,"yes");
        Input.transactions(2,2,1,4,"no");
        Input.transactions(3,3,3,4,"yes");

        Input.transactions(4,1,2,2,"no");
        Input.transactions(5,2,1,6,"yes");
        Input.transactions(6,3,3,8,"no");


        while (true) {
            String input = Input.userInput();
            if (Output.listCustomers(input)) {
                Output.outputCustomers();
            }else if (Output.listTyres(input)) {
                Output.outputTyres();
            }else if (Output.listTransactions(input)) {
                Output.outputTransactions();
            }else if (Output.exit(input)) {
                break;
            }
        }
    } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
   }
}

