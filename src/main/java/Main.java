import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3611557145");
        Customer customer =new Customer(connection);
        Category category = new Category(connection);
        Video video =new Video(connection);
        Reserve reserve= new Reserve(connection);
        Scanner scanner =new Scanner(System.in);
        System.out.println("please enter your first name; ");
        String fisrtName=scanner.nextLine();
        System.out.println("please enter your last name; ");
        String lastName=scanner.nextLine();
        customer.setFirstName(fisrtName);
        customer.setLastName(lastName);
        customer.setCreatedDate(Date.valueOf(LocalDate.now()));
        Integer customerId=
        CustomerReposeitory.customerSave(connection,customer);
        System.out.println("saved successfuly");
        System.out.println("______________");
        VideoReposeitory.show(connection);
        System.out.println("_____________");
        System.out.println("please enter videoId : ");
        int videoId=scanner.nextInt();
        reserve.setReserveDate(Date.valueOf(LocalDate.now()));
        reserve.setVideoId(videoId);
        reserve.setCustomerId(customerId);
        ReserveRepseitory.save(connection,reserve);
ReserveRepseitory.showReserve(connection,customerId);
        System.out.println("please enter id Reserve : ");
        int reserve_id = scanner.nextInt();
        ReserveRepseitory.reject(connection,reserve_id,Date.valueOf(LocalDate.now()));


    }
}
