import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoReposeitory {
public static void show(Connection connection) throws SQLException {

    String showVidoes="select v.id,v.video_name,v.count,category.title from video v inner join category on v.category_id = category.id ";
    PreparedStatement preparedStatement =
    connection.prepareStatement(showVidoes);
    ResultSet resultSet =
    preparedStatement.executeQuery();
    while (resultSet.next()){
        System.out.println("id : "+resultSet.getInt(1) + " video_name : "+ resultSet.getString(2)+" count : " + resultSet.getInt(3)+ " title : "+resultSet.getString(4));


    }
}
}
