package final_keyword;

//A final method is a method that cannot be overridden by a child class.
// Parent class


class Parent {

    // WITHOUT final
    // A child class can override this method.

    void display() {
        System.out.println("Parent display method");
    }

    // WITH final
    // A child class cannot override this method.

    final void show() {
        System.out.println("Parent final method");
    }
}


// Child class
class Child extends Parent {

    // Overriding a normal method is allowed.

    @Override
    void display() {
        System.out.println("Child display method");
    }
    
//    void show() {}

    // If we override show(), Java gives a
    // compilation error because show() is final.
}


public class FinalMethod {

    public static void main(String[] args) {

        Child obj = new Child();

        // Calls the overridden method.
        obj.display();

        // Calls the inherited final method.
        obj.show();
    }
}
