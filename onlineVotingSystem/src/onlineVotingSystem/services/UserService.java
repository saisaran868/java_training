
package onlineVotingSystem.services;

import java.util.HashMap;
import java.util.Map;

import onlineVotingSystem.model.User;
import onlineVotingSystem.exception.UserAlreadyExistsException;
import onlineVotingSystem.exception.InvalidLoginException;

public class UserService {

    private Map<String, User> users = new HashMap<>();

    // Register a new user
    public String registerUser(String firstName,
                               String lastName,
                               String password) {

        if (firstName == null || firstName.trim().isEmpty() ||
            lastName == null || lastName.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "First name and last name cannot be empty");
        }

        firstName = firstName.trim();
        lastName = lastName.trim();

        String studentName = firstName + " " + lastName;

        User user = new User(studentName, password);

        // Generate unique student ID
        String initials =
            firstName.substring(0, 1).toUpperCase() +
            lastName.substring(0, 1).toUpperCase();

        int number = users.size() + 1;
        String studentId = initials + number;

        while (users.containsKey(studentId)) {
            number++;
            studentId = initials + number;
        }

        if (users.containsKey(studentId)) {
            throw new UserAlreadyExistsException(
                "Student ID already exists");
        }

        users.put(studentId, user);

        return studentId;
    }

    // Login user
    public User loginUser(String studentId, String password) {

        User user = users.get(studentId);

        if (user == null || !user.isPasswordCorrect(password)) {

            throw new InvalidLoginException(
                "Invalid Student ID or Password");
        }

        return user;
    }

    // Check whether student exists
    public boolean studentExists(String studentId) {
        return users.containsKey(studentId);
    }

    // Add predefined users
    public void addPredefinedUser(String studentId,
                                  String studentName,
                                  String password) {

        if (users.containsKey(studentId)) {
            throw new UserAlreadyExistsException(
                "Student ID already exists");
        }

        users.put(studentId, new User(studentName, password));
    }
}
