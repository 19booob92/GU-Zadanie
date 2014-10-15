package mainPackage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.UserService;

import com.google.gson.JsonSyntaxException;

import factory.UserFactory;


public class Runner {

    static String choice = null;

    static int menuItem = 0;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static UserService userService = new UserService();

    static UserFactory userFactory = new UserFactory();

    private static int getMinValue() {
        try {
            String minValue = "0";
            minValue = input.readLine();
            return Integer.parseInt(minValue);
        } catch (Exception e) {
            System.out.println("Poblem z odczytaniem wyboru");
        }
        return 0;

    }

    public static void main(String[] args) throws JsonSyntaxException, IOException {

        userService.saveUsers(userFactory.getDefaultUsers());

        while (1 == 1) {

            System.out.println("1. Wypisz wszystkich userow");
            System.out.println("2. Wypisz wszystkich userow z zakupami");
            System.out.println("3. Zakoncz");

            try {
                choice = input.readLine();
                menuItem = Integer.parseInt(choice);
            } catch (Exception e) {
                System.out.println("Poblem z odczytaniem wyboru");
                continue;
            }

            switch (menuItem) {
            case 1:
                System.out.print(userService.getAllUsers());
                break;
            case 2:
                System.out.println("Podaj minimalna wartosc zamowien: ");
                System.out.println(userService.getUsersWithGivenItemsCost(getMinValue()));
                break;
            case 3:
                System.exit(1);
            default:
                System.out.println("Nie ma takiej mozliwosci");
            }

        }

    }
}
