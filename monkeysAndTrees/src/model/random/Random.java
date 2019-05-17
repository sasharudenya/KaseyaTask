package model.random;

public class Random {
    public static int randomCountFruit(int begin, int end) {
        int range = end - begin + 1;
        return (int)(Math.random() * (range) + begin); }
}
