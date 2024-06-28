import java.sql.*;
import java.util.Scanner;

public class roomController {
    public static void AddRoom(Scanner scanner){

    System.out.println("Enter floor");
    int floor = scanner.nextInt();
    System.out.println("Enter capacity");
    int cap = scanner.nextInt();
    System.out.println("Enter Type");
    String type = scanner.next();
    System.out.println("Enter Price");
    double price = scanner.nextDouble();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_test", "springstudent", "springstudent"
        );

        String sql = "INSERT INTO Room (floor, capacity, roomtype, price) VALUES (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, floor);
        preparedStatement.setInt(2, cap);
        preparedStatement.setString(3, type);
        preparedStatement.setDouble(4, price);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Insert successful!");
        }

    } catch (SQLException e) {
        System.out.println("Error: " + e.toString());
       }
    finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
    } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}

    public static void showRoom()  {
        System.out.println("this all Room");

        Connection connection = null;
        Statement statement = null ;
        ResultSet resultSet = null ;
        try {
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "springstudent", "springstudent");

        String sql = "select * from room";
         statement = connection.createStatement();

         resultSet = statement.executeQuery(sql);
         while (resultSet.next()){
             int id = resultSet.getInt("roomId");
             int floor = resultSet.getInt("floor");
             int cap = resultSet.getInt("capacity");
             String type = resultSet.getString("roomtype");
             double price = resultSet.getDouble("price");
             System.out.println(" Id  " + id +
                     " Floor " + floor +"  Capacity " + cap+
                     " Type " + type + " Price " + price);
         }

        } catch (SQLException e) {
            System.out.println("Error " + e.toString());
        }

    }
    public static void EditDAta(Scanner scanner) {
        System.out.println("Enter id that you need to update \nIf you need all data, enter -1");
        int n = scanner.nextInt();
        if (n == -1) {
            showRoom();
            n = scanner.nextInt();
        }

        System.out.println("Enter new floor");
        int floor = scanner.nextInt();
        System.out.println("Enter new capacity");
        int cap = scanner.nextInt();
        System.out.println("Enter new Type");
        String type = scanner.next();
        System.out.println("Enter new Price");
        double price = scanner.nextDouble();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_test", "springstudent", "springstudent"
            );

            String sql = "UPDATE Room SET floor = ?, capacity = ?, roomtype = ?, price = ? WHERE roomId = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, floor);
            preparedStatement.setInt(2, cap);
            preparedStatement.setString(3, type);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, n); // setting the roomId

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successful!");
            } else {
                System.out.println("No record found with the given id.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.toString());
            }
        }
    }
}
