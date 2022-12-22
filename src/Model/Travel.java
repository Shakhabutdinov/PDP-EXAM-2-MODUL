package Model;

import java.math.BigDecimal;

public class Travel {
    private int id;
    private String name;
    private String from;
    private String to;
    private String date;
    private Bus bus;
    private User driver;
    private BigDecimal priceForPerSeat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public BigDecimal getPriceForPerSeat() {
        return priceForPerSeat;
    }

    public void setPriceForPerSeat(BigDecimal priceForPerSeat) {
        this.priceForPerSeat = priceForPerSeat;
    }

    public Travel(int id, String name, String from, String to, String date, Bus bus, User driver, BigDecimal priceForPerSeat) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.date = date;
        this.bus = bus;
        this.driver = driver;
        this.priceForPerSeat = priceForPerSeat;
    }

    @Override
    public String toString() {
        return "Travel{" + "id=" + id + ", name='" + name + '\'' + ", from='" + from + '\'' + ", to='" + to + '\'' + ", date='" + date + '\'' + ", bus=" + bus + ", driver='" + driver + '\'' + ", priceForPerSeat=" + priceForPerSeat + '}';
    }
}
