/*
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> nameEmailMap = new HashMap<String, List<String>>();
        //Iterate through all the account names
        for(int nameIndex = 0; nameIndex < accounts.size(); nameIndex++) {
            //Separate the name from the emails
            String name = accounts.get(nameIndex).get(0);
            List<String> emails = new ArrayList<String>(new HashSet<String>(accounts.get(nameIndex).subList(1, accounts.get(nameIndex).size())));
            //If the name already exists in the map, see if theres a matching email
            for (int j = 0; j < accounts.get(nameIndex).size(); j++) {
                if (nameEmailMap.containsKey(name)) {
                    List<String> originalEmails = nameEmailMap.get(name);
                    //Combine the emails if there is a match
                    if (hasMatch(originalEmails, emails)) {
                        //Merge the emails since there is a match
                        for (int oei = 0; oei < originalEmails.size(); oei++) {
                            String email = originalEmails.get(oei);
                            if (!emails.contains(email)) {
                                emails.add(email);
                            }
                        }
                    } else {
                        //These are different people so keep them separate
                        name += nameIndex;
                    }
                }
            }
            Collections.sort(emails);
            if (!emails.contains(accounts.get(nameIndex).get(0))) {
                emails.add(0, accounts.get(nameIndex).get(0));
            }
            nameEmailMap.put(name, emails);
        }
        
        List<List<String>> solution = new ArrayList<List<String>>();
        for (var entry : nameEmailMap.entrySet()) {
            List<String> itemsToInsert = new ArrayList<String>();
            itemsToInsert.addAll(entry.getValue());
            solution.add(itemsToInsert);
        }
        return solution;
    }
    
    private boolean hasMatch(List<String> arr1, List<String> arr2) {
        boolean hasMatch = false;
        for (int i = 0; i < arr1.size(); i++) {
            if (arr2.contains(arr1.get(i))) {
                hasMatch = true;
            }
        }
        return hasMatch;
    }
}
*/
class Solution {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();
    
    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);
        
        if (!adjacent.containsKey(email)) {
            return;
        }
        
        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();
        
        for (List<String> account : accountList) {
            int accountSize = account.size();
            
            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);
                
                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);
                
                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }
        
        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            
            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);
                
                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size())); 
                mergedAccounts.add(mergedAccount);
            }
        }
        
        return mergedAccounts;
    }
}