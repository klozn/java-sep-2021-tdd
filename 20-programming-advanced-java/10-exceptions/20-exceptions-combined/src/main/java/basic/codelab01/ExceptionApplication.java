package basic.codelab01;

/**
 * Read the README.md file
 */
public class ExceptionApplication {

    public static void main(String[] args) {

        MyExceptionService myExceptionService = new MyExceptionService();
        try {
            myExceptionService.doSomethingExceptional();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            System.out.println("I can show you the world!");
        }
    }

}
