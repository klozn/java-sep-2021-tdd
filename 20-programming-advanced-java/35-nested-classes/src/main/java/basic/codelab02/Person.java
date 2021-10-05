package basic.codelab02;

import java.time.LocalDate;

public class Person {
    private final String name;
    private final String firstName;
    private final LocalDate birthDay;
    private final int id;

    private Person(String name, String firstName, LocalDate birthDay, int id) {
        this.name = name;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private String name;
        private String firstName;
        private LocalDate birthDay;
        private int id;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withBirthday(LocalDate birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Person build() {
            return new Person(name, firstName, birthDay, id);
        }
    }
}
