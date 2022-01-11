import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Category {
    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category(Connection connection) throws SQLException {
        String createTable="create table if not exists category(id serial primary key,title varchar(255))";
        PreparedStatement preparedStatement=
                connection.prepareStatement(createTable);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
