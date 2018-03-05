// // Voter_truthful.java: sample implementation for Voter
// COS 445 HW1, Spring 2018

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Voter_hop implements Voter {
    // Constants
    private double MEASURE_OF_BALANCE = 0.1; 
    private double SWITCH_THRESH = 0.3;

    // IV
    private int P; 
    private int N;  
    private Candidate F;
    private List<Poll> polls; 
    private int currPoll; 
    private int no_of_honest_rounds;
    private Candidate lastRes;

    private class Poll {
        double fstRatio; 
        double sndRatio;
        double thrRatio;

        private Poll(double fst, double snd, double thr) {
            fstRatio = fst; 
            sndRatio = snd;
            thrRatio = thr;
        }

        public String toString() {
            return fstRatio + " - " + 
                    sndRatio + " - " + 
                    thrRatio + "\n";
        }
    }

    public void setup(int N, int P, int v, Candidate F) { 
        this.P = P; 
        this.N = N; 
        this.F = F;
        this.lastRes = F;
        polls = new ArrayList<Poll>();  
        currPoll = 0;
        int cap = P / 2;
        no_of_honest_rounds = (cap >= 3) ? cap : 3;

    }

    private Candidate getSndCand() {
        return (this.F == Candidate.A) ? Candidate.B : 
                (this.F == Candidate.B ? Candidate.C : Candidate.A);
    }

    public Candidate getPoll() {
        Candidate res = null; 
        if (P == 0)
            return F; 
        else if (currPoll != P-1) {
            if (currPoll % 5 != 0) 
                res = F;
            else 
                res = this.getSndCand(); 
        } else {
            Poll poll = polls.get(currPoll-1); 
            double fst = poll.fstRatio; 
            double snd = poll.sndRatio; 
            double thr = poll.thrRatio; 
            double max = Math.max(fst, Math.max(snd, thr)); 

            if (fst == max) 
                res = F; 
            else 
                res = this.getSndCand();
        }

        
        currPoll++; 
        lastRes = res;

        return res;
    }


    public void addResults(List<Candidate> results) {
        int countA = 0; 
        int countB = 0; 
        int countC = 0; 

        for (Candidate c : results) {
            switch (c) {
                case A: 
                    countA++;
                    break; 
                case B: 
                    countB++;
                    break;
                default: 
                    countC++;  
            }
        }

        double total = results.size(); 
        int topCount = (F == Candidate.A) ? countA : ((F == Candidate.B) ? countB : countC);
        int secCount = (F == Candidate.A) ? countB : ((F == Candidate.B) ? countC : countA);
        int thrCount = (F == Candidate.A) ? countC : ((F == Candidate.B) ? countA : countB);
        Poll p = new Poll(
            topCount / total,
            secCount / total,
            thrCount / total
        );

        polls.add(p);     
    }

    public Candidate getVote() {
        return lastRes;
    }
}
