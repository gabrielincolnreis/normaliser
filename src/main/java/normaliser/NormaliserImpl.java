package normaliser;

import java.util.Collections;
import java.util.List;

public class NormaliserImpl implements Normaliser {

    private List<String> jobList = Collections.emptyList();

    public void setJobList(List<String> jobList){
        this.jobList = jobList;
    }

    public List<String> getJobList(){
        return jobList;
    }

    @Override
    public String normalise(String jobName){

        String normalizedName = jobList.get(0);
        int minDistance = minDistance(jobName, jobList.get(0));

        for(String job: jobList){
            int distance = minDistance(jobName, job);

            if(distance<minDistance){
                normalizedName = job;
                minDistance = distance;
            }
        }

        return normalizedName;
    }

    private int Minimum (int a, int b, int c) {
        int minimum;

        minimum =a;
        if(b < minimum){
            minimum = b;
        }
        if(c < minimum){
            minimum = c;
        }

        return minimum;
    }

    //Using the Levenshtein's algorithm to find the word with the smallest distance
    private int minDistance(String word1, String word2) {
        int[][] d; //matrix
        int n; // length of word1
        int m; //length of word2
        int i; //iterates through word1
        int j; //iterates through word2
        char word1_i; // ith character of word1
        char word2_j; // ith character of word2
        int cost;

        n = word1.length();
        m = word2.length();

        if(n==0){
            return m;
        }
        if(m==0){
            return n;
        }
        d = new int[n+1][m+1];

        //Initialize the first row to 0..n
        //Initialize the first column to 0..m

        for(i=0; i<=n; i++){
            d[i][0] = i;
        }

        for(j=0; j<=m; j++){
            d[0][j] = j;
        }

        //Examine each character of word1(i from 1 to n)

        for(i=1; i<=n; i++){

            word1_i = word1.charAt(i-1);

            //Examine each character of word2(j from 1 to m)

            for(j = 1; j <= m; j++ ){
                word2_j = word2.charAt(j-1);

                if(word1_i == word2_j){
                    cost = 0;
                } else{
                    cost = 1;
                }

                //Set cell d[i,j] of the matrix equal to the minimum of:
                //a - The cell immediately above plus 1
                //b - The cell immediately to the left plus 1
                //c - The cell diagonally above and to the left plus the cost

                d[i][j] = Minimum(d[i-1][j] + 1, d[i][j-1] + 1, d[i-1][j-1] + cost);
            }
        }

        //return the distance found in cell d[n,m]

        return d[n][m];

    }
}
