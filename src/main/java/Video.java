import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Video {
    private Integer id;
    private String videoName;
    private Integer count;
    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Video(Connection connection) throws SQLException {
        String createTable="create table if not exists video(id serial primary key,video_name varchar(255),count integer,category_id integer" +
                " ,constraint fk_category_id foreign key (category_id) references category(id))";
        PreparedStatement preparedStatement=
                connection.prepareStatement(createTable);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", count=" + count +
                ", categoryId=" + categoryId +
                '}';
    }

    public Video() {
    }
}
