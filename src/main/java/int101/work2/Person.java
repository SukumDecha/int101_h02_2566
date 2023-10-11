package int101.work2;

import int101.work1.Utilitor;

public class Person {

    private static int nextId = 1;
    private int id;
    private String firstName, lastName;

    public Person(String firstName, String lastName) {
        this.firstName = Utilitor.testString(firstName);
        this.lastName = Utilitor.testString(lastName);
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return new StringBuilder("Person(")
                .append(id + ", ")
                .append(firstName + ", ")
                .append(lastName + ")").toString();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Utilitor.testString(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Utilitor.testString(lastName);
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }
}
