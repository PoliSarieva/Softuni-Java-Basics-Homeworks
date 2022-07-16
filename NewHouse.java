import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int flowerCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double flowerType = 0;
        double finallyPrice = 0;

        //"Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        switch (flowers) {
            case "Roses":
                flowerType = 5;
                break;
            case "Dahlias":
                flowerType = 3.80;
                break;
            case "Tulips":
                flowerType = 2.80;
                break;
            case "Narcissus":
                flowerType = 3;
                break;
            case "Gladiolus":
                flowerType = 2.50;
                break;
        }

        double price = flowerType * flowerCount;

        if (flowers.equals("Roses") && flowerCount > 80) {
            finallyPrice =price - (price * 0.10);
        } else if (flowers.equals("Dahlias") && flowerCount > 90) {
            finallyPrice =price - (price * 0.15);
        } else if (flowers.equals("Tulips") && flowerCount > 80) {
            finallyPrice =price - (price * 0.15);
        } else if (flowers.equals("Narcissus") && flowerCount < 120) {
            finallyPrice = price + (price * 0.15);
        } else if (flowers.equals("Gladiolus") && flowerCount > 80) {
            finallyPrice = price + (price * 0.20);
        } else {
            finallyPrice = price;
        }

        if (finallyPrice<=budget) {
            double leftSum = budget - finallyPrice;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowerCount, flowers, leftSum);
        } else if (finallyPrice > budget) {
            double neededSum = finallyPrice - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", neededSum);
        }
    }
}
