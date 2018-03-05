// Testing code for PS2 problem 4

// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;
// import java.util.TreeSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elections {
    //L private static final int N = {};//
    private static final String[] netids = new String[N];
    private static final int P = 100;
    private static final List<Voter.Candidate> VALUES =
        Collections.unmodifiableList(Arrays.asList(Voter.Candidate.values()));
    private static final int N_CANDIDATES = VALUES.size();
    private static final Random rand = new Random();

    public static int[] Trial () {
        // Initialize voters
        Voter[] voters = new Voter[N];
        //R voters[{0}] = new Voter_{netID}();//

        // Set up voters
        Voter.Candidate[] prefs = new Voter.Candidate[N];
        for (int v = 0; v != N; ++v) {
            prefs[v] = VALUES.get(rand.nextInt(N_CANDIDATES));
            voters[v].setup(N, P, v, prefs[v]);
        }

        // Polling
        for (int p = 0; p != P; ++p) {
            // Take poll
            List<Voter.Candidate> results =
                Collections.unmodifiableList(IntStream.range(0, N).boxed()
                                             .map(v -> voters[v].getPoll())
                                             .collect(Collectors.toList()));
            // Share poll results with voters
            for (int v = 0; v != N; ++v) {
                voters[v].addResults(results);
            }
        }

        // Final vote
        int[] votes = new int[N_CANDIDATES];
        for (int v = 0; v != N; ++v) {
            ++votes[voters[v].getVote().ordinal()];
        }
        Voter.Candidate winnerTopPref =
            (votes[Voter.Candidate.A.ordinal()] > votes[Voter.Candidate.B.ordinal()]
             && votes[Voter.Candidate.A.ordinal()] > votes[Voter.Candidate.C.ordinal()])
            ? Voter.Candidate.A
            : (votes[Voter.Candidate.C.ordinal()] > votes[Voter.Candidate.B.ordinal()])
            ? Voter.Candidate.C : Voter.Candidate.B;
        Voter.Candidate winnerMidPref =
            (winnerTopPref == Voter.Candidate.A) ? Voter.Candidate.C :
            (winnerTopPref == Voter.Candidate.B) ? Voter.Candidate.A : Voter.Candidate.B;
        int[] ret = new int[N];
        for (int v = 0; v != N; ++v) {
            ret[v] =
                (prefs[v] == winnerTopPref) ? 2 :
                (prefs[v] == winnerMidPref) ? 1 : 0;
        }
        return ret;
    }
    public static void main (String[] args) {
        //R netids[{0}] = "{netID}";//

        double[] res = new double[N];
        // TESTing
        double sum1 = 0, sum2 = 0, sum3 = 0; 
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        final int numTrials = 100;
        for (int i = 0; i != N; ++i) {
            res[i] = 0;
        }
        for (int ign = 0; ign != numTrials; ++ign) {
            int[] ret = Trial();
            for (int i = 0; i != N; ++i) {
                res[i] += ret[i];
            }
        }
        for (int i = 0; i != N; ++i) {
            res[i] /= numTrials;
            if (netids[i] == "hop") {
                sum1 += res[i]; 
                cnt1++; 
            } else if (netids[i] == "yiranf_lkermode") {
                sum2 += res[i];
                cnt2++; 
            } else {
                sum3 += res[i]; 
                cnt3++; 
            }
        }
        System.out.println("netID,score");
        for (int i = 0; i != N; ++i) {
            System.out.println(netids[i] + "," + Double.toString(res[i]));
        }
        System.out.println("avg (hop): " + sum1 / (double) cnt1); 
        System.out.println("avg (yiranf_lkermode): " + sum2 / (double) cnt2); 
        System.out.println("avg (second): " + sum3 / (double) cnt3); 
    }
}
