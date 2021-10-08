package basic.codelab02;

import java.io.IOException;

/**
 * Read the README.md file
 */
public class ExceptionV2Application {

    public static void main(String[] args) {

        var myExceptionService = new MyExceptionV2Service();
        try {
            myExceptionService.doSomethingExceptional();
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("I can show you the world!");
    }

}
