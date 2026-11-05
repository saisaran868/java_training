
package onlineVotingSystem.model;

public class User {

    private String studentName;
    private String password;
    private boolean isVoted;

    public User(String studentName, String password) {
        setStudentName(studentName);
        setPassword(password);
        this.isVoted = false;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {

        if (studentName == null || studentName.trim().length() < 4) {
            throw new IllegalArgumentException(
                "Student name must contain at least 4 characters");
        }

        this.studentName = studentName.trim();
    }

    public void setPassword(String password) {

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException(
                "Password cannot be empty");
        }

        if (password.length() < 8 ||
            !password.matches(".*[a-z].*") ||
            !password.matches(".*[A-Z].*") ||
            !password.matches(".*\\d.*") ||
            !password.matches(".*[@#$%^&+=!].*")) {

            throw new IllegalArgumentException(
                "Password must contain 8 characters, uppercase, lowercase, digit and special character");
        }

        this.password = password;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public boolean isVoted() {
        return isVoted;
    }

    public void castVote() {

        if (isVoted) {
            throw new IllegalStateException(
                "Student has already voted");
        }

        this.isVoted = true;
    }
}
