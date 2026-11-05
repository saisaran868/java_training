
package onlineVotingSystem.services;

import java.util.HashMap;
import java.util.Map;

import onlineVotingSystem.model.User;
import onlineVotingSystem.model.Candidate;
import onlineVotingSystem.exception.AlreadyVotedException;

public class VotingService {

	private Map<String, Candidate> candidates = new HashMap<>();

	// Add candidate
	public void addCandidate(String candidateId, String candidateName) {

		if (candidates.containsKey(candidateId)) {
			throw new IllegalArgumentException("Candidate ID already exists");
		}

		candidates.put(candidateId, new Candidate(candidateName));
	}

	// Display candidates
	public void displayCandidates() {

		System.out.println("\n----- Available Candidates -----");

		for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {

			System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue().getCandidateName());
		}
	}

	// Cast vote
	public void castVote(User user, String candidateId) {

		if (user.isVoted()) {
			throw new AlreadyVotedException("You have already voted!");
		}

		Candidate candidate = candidates.get(candidateId);

		if (candidate == null) {
			throw new IllegalArgumentException("Invalid Candidate ID");
		}

		// Record vote
		candidate.addVote();

		// Update student voting status
		user.castVote();
	}

	public Map<String, Candidate> getCandidates() {
		return candidates;
	}
}
