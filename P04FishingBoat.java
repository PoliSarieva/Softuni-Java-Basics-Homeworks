import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Бюджет на групата – цяло число в интервала [1…8000]
        int budget = Integer.parseInt(scanner.nextLine());
        //•	Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"
        String sezon = scanner.nextLine();
        //•	Брой рибари – цяло число в интервала [4…18]
        int fisherCount = Integer.parseInt(scanner.nextLine());
        double rentBoat = 0;
        //Цената зависи от сезона:
        //•	Цената за наем на кораба през пролетта е  3000 лв.
        //•	Цената за наем на кораба през лятото и есента е  4200 лв.
        //•	Цената за наем на кораба през зимата е  2600 лв.
        switch (sezon) {
            case "Spring":
                rentBoat = 3000;
                break;
            case "Summer":
            case "Autumn":
                rentBoat = 4200;
                break;
            case "Winter":
                rentBoat = 2600;
                break;
            default:
                break;
        }

        double price = 0;
        //В зависимост от броя си групата ползва отстъпка:
        //•	Ако групата е до 6 човека включително  –  отстъпка от 10%.
        //•	Ако групата е от 7 до 11 човека включително  –  отстъпка от 15%.
        //•	Ако групата е от 12 нагоре  –  отстъпка от 25%.
        //Рибарите ползват допълнително 5% отстъпка ако са четен брой освен ако не е есен - тогава нямат допълнителна отстъпка.
        if (fisherCount <= 6) {
            price = rentBoat - (rentBoat * 10 / 100);
        } else if (fisherCount <= 11) {
            price = rentBoat - (rentBoat * 15 / 100);
        } else {
            price = rentBoat - (rentBoat * 25 / 100);
        }

        if (!sezon.equals("Autumn")) {
            if (fisherCount % 2 == 0) {
                price = price - (price * 5 / 10);
            }
        }

        double realMoney = Math.abs(budget - price);

        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", realMoney);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", realMoney);
        }
    }
}
