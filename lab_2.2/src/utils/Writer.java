package utils;
import sweets.*;
public class Writer {
    public static void writeGift(Gift gift) {
        for (AbstractSweet sweet : gift.getSweetsList()){
            writeSweet(sweet);
            System.out.println();
        }
    }
    public static void writeSweet(AbstractSweet sweet){
        System.out.println("Name: " + sweet.getName());
        System.out.println("Calories: " + sweet.getCalories());
        System.out.println("Weight: " + sweet.getWeight());
        System.out.println("Type: " + sweet.type);
    }


}
