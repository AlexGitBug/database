package entity;

import java.util.Objects;

public class QuantityBed {

    private int id;

    private int quantity;

    public QuantityBed() {
    }

    public QuantityBed(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityBed that = (QuantityBed) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "QuantutyBed{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
