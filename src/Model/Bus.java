package Model;

public class Bus {
    private int id;
    private String name;
    private String number;
    private int numberOfSeats;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Bus(int id, String name, String number, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Bus" + " name: " + name + ", number: " + number ;
    }
}

