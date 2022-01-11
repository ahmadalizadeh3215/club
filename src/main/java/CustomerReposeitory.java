import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerReposeitory {
    public static Integer customerSave(Connection connection,Customer customer) throws SQLException {
        String insert="insert into customer(last_name,first_name,created_date) values(?,?,?)";
        PreparedStatement preparedStatement =
        connection.prepareStatement(insert);
        preparedStatement.setString(1, customer.getLastName());
        preparedStatement.setString(2, customer.getFirstName());
        preparedStatement.setDate(3, customer.getCreatedDate());
        preparedStatement.executeUpdate();
        String select="select id from customer where last_name =? and first_name=? and created_date =?";
        PreparedStatement preparedStatement1 =
                connection.prepareStatement(select);
        preparedStatement1.setString(1, customer.getLastName());
        preparedStatement1.setString(2, customer.getFirstName());
        preparedStatement1.setDate(3, customer.getCreatedDate());
        ResultSet resultSet = preparedStatement1.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);


    }
}
