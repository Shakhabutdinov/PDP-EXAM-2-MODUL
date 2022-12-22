package Model;

import java.math.BigDecimal;

public class Order {
    private int id;
    private User user;
    private Ticket ticket;
    private BigDecimal sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Order(int id, User user, Ticket ticket, BigDecimal sum) {
        this.id = id;
        this.user = user;
        this.ticket = ticket;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user='" + user + '\'' + ", ticket='" + ticket + '\'' + ", sum=" + sum + '}';
    }
}
