import java.sql.*;

public class ReserveRepseitory {
    public static  void save(Connection connection,Reserve reserve) throws SQLException {
        String insert ="insert into reserve(reserve_date, customer_id,video_id,status) values " +
                "(?,?,?,?)";
        PreparedStatement preparedStatement=
        connection.prepareStatement(insert);
        preparedStatement.setDate(1,reserve.getReserveDate());
        preparedStatement.setInt(2,reserve.getCustomerId());
        preparedStatement.setInt(3,reserve.getVideoId());
        preparedStatement.setBoolean(4,false);
        preparedStatement.executeUpdate();
        preparedStatement.close();


    }
    public static void reject(Connection connection, int reserveId, Date date) throws SQLException {
        String reject="update reserve set end_date=? , status=true where id=?";
        PreparedStatement preparedStatement =
        connection.prepareStatement(reject);
        preparedStatement.setDate(1,date);
        preparedStatement.setInt(2,reserveId);
        preparedStatement.executeUpdate();
        preparedStatement.close();


    }
    public  static void showReserve(Connection connection,int customerId) throws SQLException {
        String show="select * from reserve inner join video on video.id= reserve.video_id where customer_id=? and status=false ";
        PreparedStatement preparedStatement =
                connection.prepareStatement(show);
        preparedStatement.setInt(1,customerId);
        ResultSet resultSet =  preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Reserve id: "+ resultSet.getInt(1)+
                    " Date : "+ resultSet.getDate(2)+" Status :  "+ resultSet.getBoolean(4)+
                    " Video_name : " +resultSet.getString("video_name"));
        }
        preparedStatement.close();
    }
}
