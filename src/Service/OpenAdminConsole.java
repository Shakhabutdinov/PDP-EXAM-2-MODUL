package Service;

import Model.*;

import java.math.BigDecimal;
import java.util.Scanner;

import static Storage.Storage.*;

public class OpenAdminConsole {
    static int id1 = 0;
    static int id = 0;

    public static void openAdminConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("@@ Admin console @@");
        while (true) {
            System.out.println("=======================");
            System.out.println("1.Add bus \n 2.Add Driver \n 3.Bus status \n 4.Add travel \n 0.Exit ");
            System.out.println("=======================");
            int command = scanner.nextInt();
            if (command == 1) {
                addBus();
            } else if (command == 2) {
                addDriver();
            } else if (command == 3) {
                busStatus();
            } else if (command == 4) {
                addTravel();
            } else if (command == 0) {
                break;
            }
        }
    }

    private static void addTravel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("From: ");
        String from = scanner.nextLine();
        System.out.print("To: ");
        String to = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();
        buses.forEach(bus -> System.out.println("ID: " + bus.getId() + "\n Name: " + bus.getName() + "\n Number : " + bus.getNumber() + "\n Number of Seats: " + bus.getNumberOfSeats() + "\n ==============================================="));
        System.out.print("Enter id of the bus: ");
        int busId = scanner.nextInt();
        Bus bus = buses.get(busId);
        for (User user : users) {
            if (user.getRole().equals(Role.DRIVER)) {
                System.out.println("ID: " + user.getId() + "\n Name: " + user.getName());
            }
        }
        int driverId = scanner.nextInt();
        User driver = users.get(driverId-1);
        System.out.println("Price per seat: ");
        double price = scanner.nextDouble();
        Travel travel = new Travel(id1, name, from, to, date, bus, driver, BigDecimal.valueOf(price));
        travels.add(travel);
        for (int i = 0; i < bus.getNumberOfSeats(); i++) {
            Ticket ticket = new Ticket(i, travel, BigDecimal.valueOf(price), i + 1, Status.AVAILABLE);
            tickets.add(ticket);
        }
        id1++;
    }

    private static void busStatus() {
        Scanner scanner = new Scanner(System.in);
        buses.forEach(bus -> System.out.println("ID: " + bus.getId() + "\n Name: " + bus.getName() + "\n Number : " + bus.getNumber() + "\n Number of Seats: " + bus.getNumberOfSeats() + "\n ==============================================="));
        System.out.print("Enter id of the bus: ");
        int idOfTheBus = scanner.nextInt();
        Bus bus = buses.get(idOfTheBus);
        int numberOfSeats = bus.getNumberOfSeats();
        System.out.println("Number of seats: " + numberOfSeats);
        int sold = 0;
        int available=0;
        for (Travel travel : travels) {
            if (travel.getBus().equals(bus)){
                for (Ticket ticket : tickets) {
                    if (ticket.getTravel().equals(travel)){
                        if (ticket.getStatus().equals(Status.SOLD)){
                            sold++;
                        } else {
                            available++;
                        }
                    }
                }
            }
        }
        System.out.println("Sold tickets: " + sold);
        System.out.println("Available tickets: " + available);
    }

    private static void addDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        User user = new User(users.size() + 1, name, login, password, Role.DRIVER, BigDecimal.ZERO);
        users.add(user);
    }

    private static void addBus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Number: ");
        String number = scanner.nextLine();
        System.out.print("Number of seats: ");
        int numberOfSeats = scanner.nextInt();
        Bus bus = new Bus(id, name, number, numberOfSeats);
        buses.add(bus);
        id++;
    }
}
