
package onlineVotingSystem.model;

public class Candidate {

    private String candidateName;
    private int totalVotes;

    public Candidate(String candidateName) {
        setCandidateName(candidateName);
        this.totalVotes = 0;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {

        if (candidateName == null ||
            candidateName.trim().length() < 3) {

            throw new IllegalArgumentException(
                "Candidate name must contain at least 3 characters");
        }

        this.candidateName = candidateName.trim();
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void addVote() {
        totalVotes++;
    }
}
