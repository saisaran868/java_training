package final_keyword;

//A final class is a class that cannot be extended by another class.
// WITHOUT final
// Another class can inherit from this class.

class Parent1 {

    void display() {
        System.out.println("Parent class");
    }
}


// WITH final
// This class cannot be inherited.

final class Vehicle {

    void show() {
        System.out.println("This is a Vehicle");
    }
}


// Child inherits from Parent successfully.

class Child1 extends Parent1 {
}


// The following code causes a compilation error
// because Vehicle is final.
//
// class Car extends Vehicle {
// }


public class FinalClass {

    public static void main(String[] args) {

        // Inheritance without final.
        Child1 obj1 = new Child1();
        obj1.display();

        // We can create an object of a final class.
        Vehicle obj2 = new Vehicle();
        obj2.show();
    }
}
