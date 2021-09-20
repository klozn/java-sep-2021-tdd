package codelab04;

import codelab04.domain.Customer;
import codelab04.domain.Movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RentalApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalStoreService service = new RentalStoreService();

        boolean quit = false;

        do {
            System.out.println("Hi! What do you want to do?");
            System.out.println("1: Register as a customer");
            System.out.println("2: Give us a movie");
            System.out.println("3: Rent a movie");
            int input = scanner.nextInt();

            switch (input) {
                default -> System.out.println("Not an option.");
                case 1 -> customerRegistrationMenu(service, scanner);
                case 2 -> movieRegistrationMenu(service, scanner);
                case 3 -> rentMovieMenu(service, scanner);
                case 4 -> quit = true;
            }
        } while (!quit);
    }

    public static void customerRegistrationMenu(RentalStoreService service, Scanner scanner) {
        System.out.println("\n***** Customer Registration *****\n");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter date of Birth yyyymmdd");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
        System.out.println("Would you like to receive interesting emails? y/n");
        String input = scanner.next();
        boolean mailingList = !input.equals("n"); // it's a feature :)

        if (service.getCustomerByEmail(email) == null) {
            service.addNewCustomer(new Customer(name, birthday, email, mailingList));
            System.out.println("You have been registered. Go ahead and rent some movies!");
        } else {
            System.out.println("This email address is already registered.");
        }
    }

    public static void movieRegistrationMenu(RentalStoreService service, Scanner scanner) {
        System.out.println("\n***** Movie Registration *****\n");
        System.out.println("Enter Title");
        String title = scanner.nextLine();
        System.out.println("Enter Director");
        String director = scanner.nextLine();
        service.addNewMovie(new Movie(title, director));
        System.out.println("Thank you! You will now be able to rent it back from us!");
    }

    public static void rentMovieMenu(RentalStoreService service, Scanner scanner) {
        System.out.println("\n***** Movie Rental *****\n");
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        Customer customer = service.getCustomerByEmail(email);
        if (customer != null) {
            System.out.println("Which movie do you want?");
            service.printMovies();
            int input = scanner.nextInt();
            Movie movie = service.getMovieByIndex(input - 1);
            service.rent(movie, customer);
            System.out.println("That will be €" + movie.getRentPrice());
            System.out.printf("Rental history of %s:", customer.getName());
            customer.printRentalHistory();
        } else {
            System.out.println("No customer found with that email address. Please register first.");
        }
    }
}
