import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reserve {
    private Integer id;
    private Date reserveDate;
    private Boolean status;
    private Date endDate;
    private Integer customerId;
    private Integer videoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Reserve(Connection connection) throws SQLException {
        String createTable="create table if not exists reserve(id serial primary key,end_date date,reserve_date date ,status boolean,customer_id integer,video_id integer , " +
                "constraint fk_customer_id foreign key (customer_id) references customer(id) ," +
                "constraint fk_video_id foreign key (video_id) references video(id))";
        PreparedStatement preparedStatement=
                connection.prepareStatement(createTable);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
