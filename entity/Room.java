package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Room {

    private int id;
    private int numberRoom;
    private int quantityId;
    private int categoryId;
    private int floor;
    private BigDecimal dayPrice;

    public Room() {
    }

    public Room(int id, int number, int quantityId, int categoryId, int floor, BigDecimal dayPrice) {
        this.id = id;
        this.numberRoom = number;
        this.quantityId = quantityId;
        this.categoryId = categoryId;
        this.floor = floor;
        this.dayPrice = dayPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public int getQuantityId() {
        return quantityId;
    }

    public void setQuantityId(int quantityId) {
        this.quantityId = quantityId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public BigDecimal getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(BigDecimal dayPrice) {
        this.dayPrice = dayPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && numberRoom == room.numberRoom && quantityId == room.quantityId && categoryId == room.categoryId && floor == room.floor && Objects.equals(dayPrice, room.dayPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberRoom, quantityId, categoryId, floor, dayPrice);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberRoom=" + numberRoom +
                ", quantityId=" + quantityId +
                ", categoryId=" + categoryId +
                ", floor=" + floor +
                ", dayPrice=" + dayPrice +
                '}';
    }
}
