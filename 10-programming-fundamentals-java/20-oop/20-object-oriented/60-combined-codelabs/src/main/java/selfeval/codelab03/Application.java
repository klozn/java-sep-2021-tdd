package selfeval.codelab03;

import java.util.Scanner;

/**
 * Read the README.md file
 */
public class Application {

    public static void main(String[] args) {
        Employee employeeAdam = new Employee("Adam", 30000);
        Employee employeeBert = new Employee("Bert", 34000);
        Employee employeeCharlotte = new Employee("Charlotte", 36000);
        Employee employeeDavidWhoIsExceptional = new Employee("David", 36000);

        Employee[] employees = {employeeAdam, employeeBert, employeeCharlotte, employeeDavidWhoIsExceptional};

        BonusService.setBonusCalculatorsBasedOnYear(employees, 2015);

        employeeDavidWhoIsExceptional.setBonusCalculator(BonusService.CALC_FOR_EXCEPTIONAL_EMPL);

        String bonusesAsText = BonusService.calculateBonuses(employees);

        System.out.println(bonusesAsText);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String firstname = askForFirstname(scanner);
            if (firstname.equals("QUIT")) {
                break;
            }
            String lastname = askForLastname(scanner);
            String fullName = firstname + " " + lastname;
            double yearlySalary = askForYearlySalary(scanner);

            Employee employee = new Employee(fullName, yearlySalary);

            BonusCalculator bonusCalculator = askForBonusCalculatorType(scanner);
            employee.setBonusCalculator(bonusCalculator);
            double bonus = employee.getBonus();
            System.out.printf("Dear %s,\n", employee);
            System.out.println("The results are in! Your bonus is €" + bonus + ".");
        }
    }

    private static String askForFirstname(Scanner scanner) {
        System.out.println("Please enter your firstname. Or enter 'QUIT' to quit the application.");
        String input = scanner.nextLine();
        if (isInValidName(input)) {
            return askForFirstname(scanner);
        }
        return input.strip();
    }

    private static String askForLastname(Scanner scanner) {
        System.out.println("Please enter your lastname.");
        String input = scanner.nextLine();
        if (isInValidName(input)) {
            return askForLastname(scanner.reset());
        }
        return input.strip();
    }

    private static boolean isInValidName(String input) {
        input = input.strip();
        if (input.isBlank()) {
            System.out.println("You pressed enter too early.");
            return true;
        }
        if (input.matches(".*\\d.*")) {
            System.out.println("A name can't have numbers in it.");
            return true;
        }
        return false;
    }

    private static double askForYearlySalary(Scanner scanner) {
        System.out.println("Please enter your yearly salary.");
        String input = scanner.nextLine();
        double salary = 0;
        try {
            salary = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            System.out.println("What you entered was not a number.");
            return askForYearlySalary(scanner);
        }
        if (salary <= 0) {
            System.out.println("We pay our employees around here.");
            return askForYearlySalary(scanner);
        }
        return salary;
    }

    private static BonusCalculator askForBonusCalculatorType(Scanner scanner) {
        System.out.println("Dear user, please choose a bonus calculator:");
        System.out.println("Option [1]: Good Year Bonus Calculator");
        System.out.println("Option [2]: Bad Year Bonus Calculator");
        System.out.println("Option [3]: Exceptional Employee Bonus Calculator");

        String input = scanner.nextLine();
        int optionIndex = 0;
        try {
            optionIndex = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("We could not interpret your input.");
            return askForBonusCalculatorType(scanner);
        }

        switch (optionIndex) {
            case 1: return BonusService.CALC_FOR_GOOD_YEAR;
            case 2: return BonusService.CALC_FOR_BAD_YEAR;
            case 3: return BonusService.CALC_FOR_EXCEPTIONAL_EMPL;
            default:
                System.out.println("That was never an option...");
                return askForBonusCalculatorType(scanner);
        }
    }
}
