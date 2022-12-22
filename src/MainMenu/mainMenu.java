package MainMenu;

import Model.Role;
import Model.User;
import Service.OpenAdminConsole;
import Service.OpenDriverConsole;
import Service.OpenUserConsole;
import Service.SignInSignUp;

import java.math.BigDecimal;
import java.util.Scanner;

import static Storage.Storage.users;

public class mainMenu {
    public static void start() {
        User user1 = new User(0, "Abdulaziz", "admin", "BMW", Role.ADMIN, BigDecimal.ZERO);
        users.add(user1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("@@ Welcome @@");
        while (true) {
            System.out.println("1.Sign in , 2.Sign up , 0.Exit");
            int command = scanner.nextInt();
            if (command == 1) {
                User user = SignInSignUp.SignIn();
                if (user == null) {
                    System.err.println("Wrong login or password");
                } else {
                    if (user.getRole().equals(Role.ADMIN)) {
                        OpenAdminConsole.openAdminConsole();
                    } else if (user.getRole().equals(Role.DRIVER)) {
                        OpenDriverConsole.openDriverConsole(user);
                    } else if (user.getRole().equals(Role.USER)) {
                        OpenUserConsole.openUserConsole(user);
                    }
                }
            } else if (command == 2) {
                SignInSignUp.SignUp();
            } else if (command == 0) {
                break;
            }
        }
    }
}
