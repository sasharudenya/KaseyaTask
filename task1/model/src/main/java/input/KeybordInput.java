package input;

import java.util.Scanner;

public class KeybordInput {

    public static String inputString(String str) {
        Scanner in = new Scanner(System.in);
        System.out.println(str);
        String mess = in.nextLine();
        return mess;
    }

    public static int inputInt(String str) {
        Scanner in = new Scanner(System.in);
        System.out.println(str);
        int mess = in.nextInt();
        return mess;
    }
}
