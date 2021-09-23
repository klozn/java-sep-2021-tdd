package code_example_live;

public class CoolDataApp {
    public static void main(String[] args) {
        playWithCountries();
        playWithLanguages();
        playWithEuropeanCountries();
        playWithMonths();
        playWithDays();
        playWithSevens();
        playWithSomeNumbers();
        playWithZeroToHunderd();
    }

    private static void playWithZeroToHunderd() {
        System.out.println("----------");
        for (double number : CoolData.RANDOM_NUMBERS_0_100) {
            //System.out.println(number);
        }
    }

    private static void playWithSomeNumbers() {
        System.out.println("----------");
        for (int someNumber : CoolData.SOME_NUMBERS) {
            //System.out.println(someNumber);
        }
    }

    private static void playWithSevens() {
        System.out.println("----------");
        for (int seven : CoolData.JUST_SEVENS) {
            //System.out.println(seven);
        }
    }

    private static void playWithDays() {
        System.out.println("----------");
        for (String weekday : CoolData.DAYS_OF_THE_WEEK) {
            //System.out.println(weekday);
        }
    }

    private static void playWithMonths() {
        System.out.println("----------");
        for (String month : CoolData.MONTHS) {
            //System.out.println(month);
        }
    }

    private static void playWithEuropeanCountries() {
        System.out.println("----------");
        for (CoolData.Country country : CoolData.EUROPEAN_COUNTRIES) {
            //System.out.println(country);
        }
    }

    private static void playWithLanguages() {
        System.out.println("----------");
        for (String language : CoolData.LANGUAGES) {
            //System.out.println(language);
        }
    }

    private static void playWithCountries() {
        for (String COUNTRY : CoolData.COUNTRIES) {
            System.out.println(COUNTRY);
        }
    }
}
