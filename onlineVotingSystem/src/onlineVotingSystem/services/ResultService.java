package onlineVotingSystem.services;

import java.util.Map;

import onlineVotingSystem.model.Candidate;

public class ResultService {

	public void displayResults(Map<String, Candidate> candidates) {

		if (candidates.isEmpty()) {
			System.out.println("No candidates available!");
			return;
		}

		int totalVotes = 0;
		int highestVotes = -1;
		int secondHighestVotes = -1;

		// Calculate total, highest and second-highest votes
		for (Candidate candidate : candidates.values()) {

			int votes = candidate.getTotalVotes();

			totalVotes += votes;

			if (votes > highestVotes) {

				secondHighestVotes = highestVotes;
				highestVotes = votes;

			} else if (votes < highestVotes && votes > secondHighestVotes) {

				secondHighestVotes = votes;
			}
		}

		System.out.println("\n----- Voting Results -----");

		// Display all candidates
		for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {

			Candidate candidate = entry.getValue();

			System.out.println("ID: " + entry.getKey() + " | Candidate: " + candidate.getCandidateName() + " | Votes: "
					+ candidate.getTotalVotes());
		}

		System.out.println("\n----- Election Summary -----");

		System.out.println("Total Votes Cast: " + totalVotes);

		if (totalVotes == 0) {
			System.out.println("No votes have been cast yet.");
			return;
		}

		// Display winner
		System.out.println("\n----- Election Winner -----");

		int winnerCount = 0;

		for (Candidate candidate : candidates.values()) {

			if (candidate.getTotalVotes() == highestVotes) {

				System.out.println("Winner: " + candidate.getCandidateName() + " (" + highestVotes + " votes)");

				winnerCount++;
			}
		}

		if (winnerCount > 1) {
			System.out.println("Result: Election ended in a tie!");
		}

		// Display runner-up
		System.out.println("\n----- Runner-Up -----");

		if (secondHighestVotes == -1) {

			System.out.println("No runner-up available.");

		} else {

			for (Candidate candidate : candidates.values()) {

				if (candidate.getTotalVotes() == secondHighestVotes) {

					System.out.println(
							"Runner-Up: " + candidate.getCandidateName() + " (" + secondHighestVotes + " votes)");
				}
			}
		}
	}
}
