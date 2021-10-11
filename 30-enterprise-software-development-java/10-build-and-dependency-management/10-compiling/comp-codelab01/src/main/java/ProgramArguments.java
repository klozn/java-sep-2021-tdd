public class ProgramArguments {
    public static void main(String[] args) {
        printArray(args);
    }

    static void printArray(String[] strings) {
        System.out.println("Program arguments:");
        if (strings != null && strings.length > 0) {
            int index = 0;
            for (String string : strings) {
                System.out.println(index++ + ":" + string);
            }
        } else {
            System.out.println("None");
        }
    }
}
