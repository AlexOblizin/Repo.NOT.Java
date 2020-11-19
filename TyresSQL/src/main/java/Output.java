import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Output {

    static boolean listCustomers(String list) {

        Pattern pattern = Pattern.compile("^(customers)$");
        Matcher matcher = pattern.matcher(list);

        return matcher.matches();
    }

    static boolean listTyres(String list) {

        Pattern pattern = Pattern.compile("^(tyres)$");
        Matcher matcher = pattern.matcher(list);

        return matcher.matches();
    }
    static boolean listTransactions(String list) {

        Pattern pattern = Pattern.compile("^(tranz)$");
        Matcher matcher = pattern.matcher(list);

        return matcher.matches();
    }

    static boolean exit(String exit) {

        Pattern pattern = Pattern.compile("^(exit)$");
        Matcher matcher = pattern.matcher(exit);

        return matcher.matches();
    }

    static void outputCustomers() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Customers\" ORDER BY ID ASC;");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            float discount = resultSet.getInt("discount");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("PHONE = " + phone);
            System.out.println("DISCOUNT = " + discount);
            System.out.println();
        }
    }

    static void outputTyres() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Tyres\" ORDER BY ID ASC;");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int heigth = resultSet.getInt("heigth");
            int width = resultSet.getInt("width");
            int radius = resultSet.getInt("radius");
            String model = resultSet.getString("model");
            String type = resultSet.getString("type");
            int price = resultSet.getInt("price");

            System.out.println("ID = " + id);
            System.out.println("HEIGHT = " + heigth);
            System.out.println("WIDTH = " + width);
            System.out.println("RADIUS = " + radius);
            System.out.println("MODEL = " + model);
            System.out.println("TYPE = " + type);
            System.out.println("PRICE = " + price);
            System.out.println();
        }
    }
    
    static void outputTransactions() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Transactions\" ORDER BY ID ASC;");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int customerId = resultSet.getInt("customerId");
            int tyresId = resultSet.getInt("tyresId");
            int quantity = resultSet.getInt("quantity");
            boolean installation = resultSet.getBoolean("installation");
            int sum = resultSet.getInt("sum");

            System.out.println("ID = " + id);
            System.out.println("CUSTOMERID = " + customerId);
            System.out.println("TYRESID = " + tyresId);
            System.out.println("QUANTITY = " + quantity);
            System.out.println("INSTALLATION = " + installation);
            System.out.println("SUM = " + sum);
            System.out.println();
        }
    }
}
