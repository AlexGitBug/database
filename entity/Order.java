package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private int id;
    private int userInfoId;
    private int roomId;
    private LocalDateTime beginTimeOfTheOrder;
    private LocalDateTime endTimeOfTheOrder;
    private String status;
    private String message;

    public Order() {
    }

    public Order(int id, int userInfoId, int roomId, LocalDateTime beginTime, LocalDateTime endTime, String status, String message) {
        this.id = id;
        this.userInfoId = userInfoId;
        this.roomId = roomId;
        this.beginTimeOfTheOrder = beginTime;
        this.endTimeOfTheOrder = endTime;
        this.status = status;
        this.message = message;
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

    public LocalDateTime getBeginTimeOfTheOrder() {
        return beginTimeOfTheOrder;
    }

    public void setBeginTimeOfTheOrder(LocalDateTime beginTimeOfTheOrder) {
        this.beginTimeOfTheOrder = beginTimeOfTheOrder;
    }

    public LocalDateTime getEndTimeOfTheOrder() {
        return endTimeOfTheOrder;
    }

    public void setEndTimeOfTheOrder(LocalDateTime endTimeOfTheOrder) {
        this.endTimeOfTheOrder = endTimeOfTheOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && userInfoId == order.userInfoId && roomId == order.roomId && Objects.equals(beginTimeOfTheOrder, order.beginTimeOfTheOrder) && Objects.equals(endTimeOfTheOrder, order.endTimeOfTheOrder) && Objects.equals(status, order.status) && Objects.equals(message, order.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userInfoId, roomId, beginTimeOfTheOrder, endTimeOfTheOrder, status, message);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userInfoId=" + userInfoId +
                ", roomId=" + roomId +
                ", beginTime=" + beginTimeOfTheOrder +
                ", endTime=" + endTimeOfTheOrder +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
