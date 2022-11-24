package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order {

    private int id;
    private int userInfoId;
    private int roomId;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String status;
    private String text;

    public Order() {
    }

    public Order(int id, int userInfoId, int roomId, LocalDateTime beginTime, LocalDateTime endTime, String status, String text) {
        this.id = id;
        this.userInfoId = userInfoId;
        this.roomId = roomId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && userInfoId == order.userInfoId && roomId == order.roomId && Objects.equals(beginTime, order.beginTime) && Objects.equals(endTime, order.endTime) && Objects.equals(status, order.status) && Objects.equals(text, order.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userInfoId, roomId, beginTime, endTime, status, text);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userInfoId=" + userInfoId +
                ", roomId=" + roomId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
