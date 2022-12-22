package Service;

import Model.Role;
import Model.User;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Predicate;

import static Storage.Storage.users;

public class SignInSignUp {

    public static void SignUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("@@@@ Sign up @@@@");
        System.out.println("name: ");
        String name = scanner.nextLine();
        while (true) {
            System.out.println("login: ");
            String login = scanner.nextLine();
            if (!isExist(login)) {
                System.out.println("password");
                String password = scanner.nextLine();
                User user = new User(users.size() + 1, name, login, password, Role.USER, BigDecimal.valueOf(500));
                users.add(user);
                break;
            } else {
                System.err.println("@@ Login already exist! @@");
            }
        }

    }

    public static User SignIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("@@@ Sign in @@@");
        System.out.println("Enter your login: ");
        String login = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        for (User user1 : users) {
            if (user1.getLogin().equals(login) && user1.getPassword().equals(password)) {
                return user1;
            }
        }
        return null;
    }

    private static boolean isExist(String login) {
        Predicate<User> userPredicate = (user -> user.getLogin().equals(login));
        User user = users.stream().filter(userPredicate).findFirst().orElse(null);
        return user != null;
    }
}
