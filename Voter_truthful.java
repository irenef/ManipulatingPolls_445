// Voter_truthful.java: sample implementation for Voter
// COS 445 HW1, Spring 2018

import java.util.List;

public class Voter_truthful implements Voter {
    private Candidate F;
    public void setup(int N, int P, int v, Candidate F) {
        this.F = F;
    }
    public Candidate getPoll() {
        return F;
    }
    public void addResults(List<Candidate> results) {
        return;
    }
    public Candidate getVote() {
        return F;
    }
}
