import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private Integer id;
    private String lastName;
    private String firstName;
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Customer(Connection connection) throws SQLException {
        String createTable="create table if not exists customer(id serial primary key,last_name varchar(255),first_name varchar(255),created_date date)";
        PreparedStatement preparedStatement=
        connection.prepareStatement(createTable);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
}
