package Model;

import java.math.BigDecimal;

public class Ticket {
    private int id;
    private Travel travel;
    private BigDecimal price;
    private int seatNumber;
    private Enum status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Ticket(int id, Travel travel, BigDecimal price, int seatNumber, Enum status) {
        this.id = id;
        this.travel = travel;
        this.price = price;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket: " +
                ", ticket id: " + id +
                ", travel: " + travel +
                ", seatNumber: " + seatNumber;
    }
}
