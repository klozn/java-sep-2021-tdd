package basic.selfeval.codelab02;

public class MainApp {
    public static void main(String[] args) {
        Person bart = new Person("Bart Vermaelen", "vermaelens-projects@skynet.be");
        Agenda agenda = new Agenda("Project Agenda", bart);
        agenda.addEntry(new Entry("First Entry", "hello world"));
        agenda.addEntry(new Entry("This won't be added", "soooo..."));

        System.out.println(agenda);
    }
}
