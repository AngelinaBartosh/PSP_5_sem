package TestGift;
import utils.*;
import sweets.*;

import java.util.Scanner;

public class TestGift {
    public static void printMenu(){
        System.out.println("1 - Add sweet");
        System.out.println("2 - View gift");
        System.out.println("3 - Get weight");
        System.out.println("4 - quit");
    }

    public static void main(String[] args) {
        Gift gift = GiftSelect.getInstance();

        Scanner sc = new Scanner(System.in);
        while (true){
            printMenu();
            int input = sc.nextInt();
            if (input == 1){
                System.out.println("Brand: ");
                System.out.println("1 - Roshen\n2 - Snickers\n3 - Mars \n4 - Spartak");
                SweetType sweetType = null;

                int option = sc.nextInt();

                System.out.println("Count: ");
                int count = sc.nextInt();

                if (option == 1){
                    sweetType = SweetType.ROSHEN;
                    AbstractSweet roshen = SweetSelect.getInstance(sweetType, 250, "sweet1", 10, count);
                    gift.addSweet(roshen);
                }
                else if (option == 2){
                    sweetType = SweetType.SNICKERS;
                    AbstractSweet snickers = SweetSelect.getInstance(sweetType, 200, "sweet4", 11, count);
                    gift.addSweet(snickers);
                }
                else if (option == 3){
                    sweetType = SweetType.MARS;
                    AbstractSweet mars = SweetSelect.getInstance(sweetType, 150, "sweet3", 8, count);
                    gift.addSweet(mars);
                }
                else if (option == 4){
                    sweetType = SweetType.SPARTAK;
                    AbstractSweet spartak = SweetSelect.getInstance(sweetType, 100, "sweet2", 6, count);
                    gift.addSweet(spartak);
                }

            }
            else if (input == 2){
                Writer.writeGift(gift);
            }
            else if (input == 3){
                System.out.println("Weight: " + Integer.toString(gift.getWeight()));
            }
            else if (input == 4){
                break;
            }
        }
        System.out.println("Gift collected, total weight: " + gift.getWeight());
    }
}
