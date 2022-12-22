package Service;

import Model.*;

import java.math.BigDecimal;
import java.util.Scanner;

import static Storage.Storage.*;

public class OpenUserConsole {
    public static void openUserConsole(User user) {
        System.out.println(" @@ User Console @@ ");
        while (true) {
            System.out.println("1.Buy ticket \n 2.My tickets \n 0.exit");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i == 1) {
                buyTickets(user);
            } else if (i == 2) {
                myTickets(user);
            } else if (i == 0) {
                break;
            } else {
                System.err.println("Wrong command!");
            }
        }
    }

    private static void myTickets(User user) {
        for (Model.Order order : orders) {
            if (order.getUser().equals(user)) {
                System.out.println("Id: " + order.getId() + "\n Ticket " + order.getTicket() + "\n User: " + order.getUser() + "\n Sum: " + order.getSum() + "\n =========================");
            }
        }
    }

    static int id = 0;

    private static void buyTickets(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Travel list: ");
        System.out.println("============================");
        for (Model.Travel travel : travels) {
            System.out.println("Id: " + travel.getId() + "\n Name: " + travel.getName() + "\n From: " + travel.getFrom() + "\n To: " + travel.getTo() + "\n Date: " + travel.getDate() + "\n Bus: " + travel.getBus() + "\n Price: " + travel.getPriceForPerSeat() + "\n ======================================");
        }
        System.out.print("Enter if of travel: ");
        int command = scanner.nextInt();
        Travel travel = travels.get(command);
        for (Model.Ticket ticket : tickets) {
            if (ticket.getTravel().equals(travel)&&ticket.getStatus().equals(Status.AVAILABLE)) {
                System.out.println("Id: " + ticket.getId() + "\n Seat number : " + ticket.getSeatNumber() + "\n Status: " + ticket.getStatus() + "\n Price" + ticket.getPrice() + "\n =============================");
            }
        }
        System.out.println("Enter ticket id: ");
        int idOfTheTicket = scanner.nextInt();
        Ticket ticket = tickets.get(idOfTheTicket);
        BigDecimal a = user.getBalance().subtract(travel.getPriceForPerSeat());
        user.setBalance(a);
        ticket.setStatus(Status.SOLD);
        Order order = new Order(id, user, ticket, ticket.getPrice());
        orders.add(order);
        id++;

    }
}
