// // Voter.java: interface for Voter
// // COS 445 HW2, Spring 2018

// import java.util.List;

// public interface VoterTwo {
//     public static enum Candidate {
//         A, // A \prec B \prec C
//         B, // B \prec C \prec A
//         C, // C \prec A \prec B
//     }

//     // The methods will be called in the following order:
//     // * setup
//     // * Repeat P times:
//     //   * getPoll
//     //   * addresults
//     // * getVote

//     // Given the stats of this simulation, initialize your Voter when this method is called.
//     // N is the number of voters
//     // P is the number of polls before the election (not inclusive)
//     // v is your voter ID (your index in results)
//     // F is your favorite candidate (uniquely defines your preferences
//     public void setup(int N, int P, int v, Candidate F);

//     // Report your favorite candidate (or lie about it)
//     public Candidate getPoll() {

//     }

//     // Update your privates with knowledge of the outcome of previous polls
//     // Indices across multiple calls to addResults correspond to the same voter
//     // results.size() == N
//     public void addResults(List<Candidate> results);

//     // Return the candidate for whom you wish to vote in the real election
//     public Candidate getVote();
// }
