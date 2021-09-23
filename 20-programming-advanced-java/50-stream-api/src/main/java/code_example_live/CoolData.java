package code_example_live;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CoolData {
    public static final List<String> ISO_COUNTRIES = List.of(Locale.getISOCountries());
    public static final List<String> COUNTRIES = ISO_COUNTRIES.stream()
            .map(isoCountry -> new Locale(Locale.ENGLISH.getLanguage(), isoCountry))
            .map(locale -> locale.getDisplayCountry())
            .collect(Collectors.toList());

    public static final List<String> ISO_LANGUAGES = List.of(Locale.getISOLanguages());
    public static final List<String> LANGUAGES = ISO_LANGUAGES.stream()
            .map(language -> new Locale(language))
            .map(locale -> locale.getDisplayLanguage())
            .collect(Collectors.toList());

    public static final List<String> MONTHS = Arrays.asList(new DateFormatSymbols().getMonths());
    public static final List<String> DAYS_OF_THE_WEEK = Arrays.asList(new DateFormatSymbols().getWeekdays());

    public static final List<Integer> JUST_SEVENS = IntStream.generate(() -> 7)
            .boxed()
            .limit(25)
            .collect(Collectors.toList());
    public static final List<Integer> SOME_NUMBERS = IntStream.range(0, 15000)
            .skip(1)
            .boxed()
            .limit(25)
            .collect(Collectors.toList());


    public static final List<Double> RANDOM_NUMBERS_0_100 = Stream.generate(() -> Math.random() * 100)
            .limit(25)
            .collect(Collectors.toList());

    public static final List<Country> EUROPEAN_COUNTRIES = Arrays.asList(
            new Country("Germany", 82_850_000),
            new Country("France", 66_992_000),
            new Country("United Kingdom", 66_238_007),
            new Country("Italy", 60_483_973),
            new Country("Spain", 46_934_632),
            new Country("Poland", 37_976_687),
            new Country("Romania", 19_523_621),
            new Country("Netherlands", 17_118_084),
            new Country("Belgium", 11_413_058),
            new Country("Greece", 10_738_868),
            new Country("Czech Republic", 10_610_055),
            new Country("Portugal", 10_291_027),
            new Country("Sweden", 10_120_242),
            new Country("Hungary", 9_778_371),
            new Country("Austria", 8_822_267),
            new Country("Bulgaria", 7_050_034),
            new Country("Denmark", 5_781_190),
            new Country("Finland", 5_513_130),
            new Country("Slovakia", 5_443_120),
            new Country("Ireland", 4_838_259),
            new Country("Croatia", 4_105_493),
            new Country("Lithuania", 2_808_901),
            new Country("Slovenia", 2_066_880),
            new Country("Latvia", 1_934_379),
            new Country("Estonia", 1_319_133),
            new Country("Cyprus", 864_236),
            new Country("Luxembourg", 602_005),
            new Country("Malta", 475_701))
            .stream()
            .sorted(Comparator.comparing(country -> country.getCountryName()))
            .collect(Collectors.toList());

    static class Country {
        private final String countryName;
        private final int numberOfCitizen;

        public Country(String countryName, int numberOfCitizen) {
            this.countryName = countryName;
            this.numberOfCitizen = numberOfCitizen;
        }

        public String getCountryName() {
            return countryName;
        }

        public int getNumberOfCitizen() {
            return numberOfCitizen;
        }

        @Override
        public String toString() {
            return getCountryName() + " | " + getNumberOfCitizen();
        }
    }
}
