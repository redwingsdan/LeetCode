class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) {
            return 1;
        }
        int possibleJudge = -1;
        List<Integer> impossibleJudges = new ArrayList<>();
        HashMap<Integer, Integer> trustMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < trust.length; i++) {
            //This person is trusting someone, so they can't be the judge
            int truster = trust[i][0];
            impossibleJudges.add(truster);
            //This person is being trusted, so they could be the judge
            int trusted = trust[i][1];
            if (trustMap.get(trusted) == null) {
                trustMap.put(trusted, 0);
            }
            //Add 1 person to the trusted count
            trustMap.put(trusted, trustMap.get(trusted) + 1);
            //But they are only the judge if the total number of people in the town -1 trust them
            //And they have not trusted anyone themselves
            if (trustMap.get(trusted) == (n-1) && !impossibleJudges.contains(trusted)) {
                possibleJudge = trusted;
            } else if (truster == possibleJudge && impossibleJudges.contains(truster)) {
                possibleJudge = -1;
            }
        }
        return possibleJudge;
    }
}