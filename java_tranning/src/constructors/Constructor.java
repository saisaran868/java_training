package constructors;

//Parent class
class Person {

 String name;
 int age;


 Person() {
     this("Unknown", 0);
     System.out.println("Person no-argument constructor");
 }

 
 Person(String name, int age) {
     this.name = name;
     this.age = age;

     System.out.println("Person parameterized constructor");
 }
}


//Child class
class Student extends Person {

 int rollNo;
 String course;


 Student() {
     this(0, "Not Assigned", "Unknown", 0);
     System.out.println("Student no-argument constructor");
 }


 Student(int rollNo, String course, String name, int age) {

     super(name, age);

     this.rollNo = rollNo;
     this.course = course;

     System.out.println("Student parameterized constructor");
 }


 Student(Student other) {

     super(other.name, other.age);

     this.rollNo = other.rollNo;
     this.course = other.course;

     System.out.println("Student copy constructor");
 }

 
 void display() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
     System.out.println("Roll No: " + rollNo);
     System.out.println("Course: " + course);
     System.out.println();
 }
}





//Main class
public class Constructor {

 public static void main(String[] args) {

     


     
     System.out.println("---- No-argument constructor ----");
     Student s1 = new Student();
     s1.display();


    
     System.out.println("---- Parameterized constructor ----");
     Student s2 = new Student(
         101, "Java", "Rahul", 21
     );
     s2.display();


    
     System.out.println("---- Copy constructor ----");
     Student s3 = new Student(s2);
     s3.display();


     System.out.println("---- Constructor overloading ----");
     Student s4 = new Student(
         102, "Python", "Priya", 22
     );
     s4.display();


 }
}