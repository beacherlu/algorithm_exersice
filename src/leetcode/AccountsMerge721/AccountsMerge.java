package leetcode.AccountsMerge721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by luyan on 17/11/5.
 */
public class AccountsMerge {

    public static void main(String[] args) {
        //        [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToName = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToName.containsKey(email)) {
                    emailToName.get(email).add(i);
                } else {
                    emailToName.put(email, new ArrayList<>());
                    emailToName.get(email).add(i);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        Set<Integer> skipAccountIndex = new HashSet<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (skipAccountIndex.contains(i)) {
                continue;
            }
            List<String> account = accounts.get(i);
            List<String> resultAccount = new ArrayList<>();
            Set<String> emailSet = new HashSet<>();

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                emailSet.add(email);

                for (int k = 0; k < emailToName.get(email).size(); k++) {
                    int index = emailToName.get(email).get(k);
                    skipAccountIndex.add(index);
                    for (int l = 1; l < accounts.get(index).size(); l++) {
                        emailSet.add(accounts.get(index).get(l));
                    }
                }
            }
            String name = account.get(0);
            resultAccount.add(name);
            List<String> emailList = new ArrayList<>(emailSet);
            Collections.sort(emailList);
            resultAccount.addAll(emailList);
            res.add(resultAccount);
        }
        return res;
    }

    private void getEmails(Set<String> emails, Map<String, List<Integer>> emailToName, String email,
            List<List<String>> accounts, Set<Integer> skipAccountIndex) {

    }
}
