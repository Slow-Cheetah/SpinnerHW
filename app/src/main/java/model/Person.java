package model;

public class Person {
    private String name;
    private String lastName;
    private String role;

    public Person(String name, String lastName, String role) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return
                "Имя: " + name + ". Фамилия: " + lastName + '\n' +
                "Должность: " + role + ".";
    }
}
