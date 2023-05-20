public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World");

        Student student = new Student(10, "Taewan", new Address("test", "test", "test"), false);

        System.out.println(student.id);
        System.out.println("Student's Name = " + student.name);

        // Student.hello();

        System.out.println(student.breath);

        student.study();

        // student.walk();
    }
}

class Address {
    String city, country, state;

    public Address(String city, String country, String state) {
        this.city = city;
        this.country = country;
        this.state = state;
    }
}

interface Human_a {
    public void walk();
}

class Human implements Human_a {
    boolean breath = true;

    public void walk() {
        System.out.println("인간은 모두 걷는다.");
    }
}

class Student extends Human {
    int id;
    String name;
    Address address;

    public Student(int id, String name, Address address, boolean is_breath) {
        this.id = id;
        this.name = name;
        this.address = address;
        
        super.breath = is_breath;
    }

    // public static void hello() {
    //     System.out.println("Hello");
    // }

    public void study() {
        System.out.println("Very Studying Hard");

        System.out.println(address.city);
    }

}