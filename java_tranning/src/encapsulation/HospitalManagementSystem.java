package encapsulation;

class Patient {

    private String name;
    private int age;
    private String disease;
    private int roomNumber;

    // Constructor
    public Patient(String name, int age, String disease, int roomNumber) {

        setName(name);
        setAge(age);
        setDisease(disease);
        setRoomNumber(roomNumber);

        System.out.println("Patient object created successfully!");
    }

    // Setter for name
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid patient name!");
        }
        this.name = name;
    }

    // Setter for age
    public void setAge(int age) {
        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Invalid patient age!");
        }
        this.age = age;
    }

    // Setter for disease
    public void setDisease(String disease) {
        if (disease == null || disease.isBlank()) {
            throw new IllegalArgumentException("Invalid disease!");
        }
        this.disease = disease;
    }

    // Setter for room number
    public void setRoomNumber(int roomNumber) {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Invalid room number!");
        }
        this.roomNumber = roomNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}



	public class HospitalManagementSystem {

	    public static void main(String[] args) {

	        try {
	            Patient p = new Patient("Rahul", 5, "Fever", 101);

	            System.out.println("Patient: " + p.getName());
	        }
	        catch (IllegalArgumentException e) {
	            System.out.println("Patient creation failed: " + e.getMessage());
	        }

	        System.out.println("Hospital system continues running.");
	    }
	}