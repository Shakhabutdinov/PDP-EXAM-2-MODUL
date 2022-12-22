package Service;

import Model.Travel;
import Model.User;

import java.util.Scanner;

import static Storage.Storage.travels;

public class OpenDriverConsole {
    public static void openDriverConsole(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.See travels \n 0.Exit");
            int command = scanner.nextInt();
            if (command == 1) {
                seeMyTravels(user);
            } else if (command == 0) {
                break;
            }
        }
    }

    private static void seeMyTravels(User user) {
        for (Travel travel : travels) {
            if (travel.getDriver().equals(user)) {
                System.out.println("ID: " + travel.getId() + "\n Name: " + travel.getName() + "\n Date: " + travel.getDate() + "\n From: " + travel.getFrom() + "\n To: " + travel.getTo()+"\n===================================================");
            }
        }
    }
}
