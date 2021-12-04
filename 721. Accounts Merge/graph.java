class Solution {
    private Map<String, List<String>> adjacent = new HashMap<>();
    private HashSet<String> visited = new HashSet<>();

    private void dfs(List<String> mergeAcc, String acc) {
        mergeAcc.add(acc);
        if (!adjacent.containsKey(acc)) {
            return;
        }
        for (String a : adjacent.get(acc)) {
            if (visited.add(a)) {
                dfs(mergeAcc, a);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String firstEmailAccount = account.get(1);

            if (!adjacent.containsKey(firstEmailAccount)) {
                adjacent.put(firstEmailAccount, new ArrayList<String>());
            }

            for (int i = 2; i < account.size(); i++) {
                String acc = account.get(i);

                adjacent.get(firstEmailAccount).add(acc);

                if (!adjacent.containsKey(acc)) {
                    adjacent.put(acc, new ArrayList<String>());
                }
                adjacent.get(acc).add(firstEmailAccount);
            }
        }

        List<List<String>> mergeAccounts = new ArrayList<>();

        for (List<String> account : accounts) {
            String firstAcc = account.get(1);

            if (visited.add(firstAcc)) {
                List<String> mergeAccount = new ArrayList<>();
                mergeAccount.add(account.get(0));

                dfs(mergeAccount, firstAcc);
                Collections.sort(mergeAccount.subList(1, mergeAccount.size()));
                mergeAccounts.add(mergeAccount);
            }

        }
        return mergeAccounts;
    }
}
