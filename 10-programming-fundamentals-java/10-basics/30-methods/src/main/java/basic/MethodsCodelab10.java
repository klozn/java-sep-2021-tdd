package basic;

public class MethodsCodelab10 {

    public static void main(String[] args) {

        //--------
        // Try to remove the duplication of this code
/*
        System.out.println("Earth revolves around the sun");
        System.out.println("Mars revolves around the sun");
        System.out.println("Mercury revolves around the sun");
        System.out.println("Venus revolves around the sun");*/

        printHelioCentrism("Earth");
        printHelioCentrism("Mars");
        printHelioCentrism("Mercury");
        printHelioCentrism("Venus");
    }

    public static void printHelioCentrism(String planet) {
        System.out.println(planet + " revolves around the sun");
    }
}
