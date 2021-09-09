package codelab03;

public class AllowanceApp {
    public static void main(String[] args) {
        Person p1 = new Person(10);
        Person p2 = new Person(12);
        Person p3 = new Person(13);
        Person p4 = new Person(17);
        Person p5 = new Person(18);

        Person[] people = new Person[] {p1, p2, p3, p4, p5};

        for (Person p: people) {
            System.out.println(p.calculateAllowance());
        }
    }
}
