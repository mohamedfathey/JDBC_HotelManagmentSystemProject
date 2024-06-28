import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = 0;
        
        while (n!=4){
            System.out.println("1. Add New Room");
            System.out.println("2. Show All Room");
            System.out.println("3. Update Any Room");

         n = scanner.nextInt();
            switch (n){
                case 1 :
                    roomController.AddRoom(scanner);
                    break;
                case 2 :
                    roomController.showRoom();
                    break;
                case 3 :
                    roomController.EditDAta(scanner);
                    break;
            }
        }
    }
}
