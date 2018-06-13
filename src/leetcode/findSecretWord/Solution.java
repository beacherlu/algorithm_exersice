package leetcode.findSecretWord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by luyan on 18/5/28.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] wordlist = new String[] { "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf",
                "yiejjw", "ldzccp", "nqsjoa", "qrjasy", "pcldos", "acrtag", "buyeia", "ubmtpj",
                "drtclz", "zqderp", "snywek", "caoztp", "ibpghw", "evtkhl", "bhpfla", "ymqhxk",
                "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb", "vdjgxx", "bugbyv",
                "zipjpc", "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop", "nkrfwn",
                "puvgve", "rqsqpq", "jwoswl", "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte",
                "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz", "arabol", "uywurk", "ppywdo",
                "resfls", "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy", "novblw",
                "mtxgwe", "rgrdbt", "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv",
                "ifwmwp", "jqmbib", "mypnvf", "lnrgnj", "clijwa", "kiioqr", "syzebr", "rqsmhg",
                "sczjmz", "hsdjfp", "mjcgvm", "ajotcx", "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj",
                "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel", "rupapy", "euwrrz", "apiqzu",
                "ydcroj", "ldvzgq", "zailgu", "xgqpsr", "wxdyho", "alrplq", "brklfk" };
        //        solution.findSecretWord(wordlist, new Master());
        wordlist = new String[] { "wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm",
                "dqefpt", "kmjmxr", "ihkovg", "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw",
                "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro", "nxcwmo", "awvqlr",
                "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg",
                "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm",
                "uinqur", "pikenp", "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow",
                "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud",
                "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv",
                "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm",
                "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry",
                "thaawc", "bssybb", "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda",
                "kaefne", "swcrkh", "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl",
                "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq" };
        //        solution.findSecretWord(wordlist, new Master());
        //        for (int i = 1; i < 1000; i++) {
        //            System.out.println(new Random().nextInt(10));
        //        }
        solution.findSecretWord1(wordlist, new Master());
    }

    /*"hbaczn"
        ["gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued",
        "rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed",
        "hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev",
        "oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg",
        "egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr",
        "rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn",
        "blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu",
        "xgqpsr","wxdyho","alrplq","brklfk"]
        10*/
    public void findSecretWord1(String[] wordlist, Master master) {
        Set<Integer> notCorrectSet = new HashSet<>();
        Set<Integer> correctSet = new HashSet<>();
        for (int i = 0; i < wordlist.length; i++) {
            correctSet.add(i);
        }
        for (int i = 0; i < 10; i = i + 1) {
            int index = new Random().nextInt(wordlist.length);
            if (notCorrectSet.contains(index)) {
                continue;
            }
            if (!correctSet.contains(index)) {
                continue;
            }
            int res = master.guess(wordlist[index]);
            if (res > 0) {
                addCorrectSet(wordlist[index], wordlist, correctSet);
            }
            if (res == 6) {
                System.out.println("bingo");
                break;
            }
            if (res == -1) {
                addNotCorrectSet(wordlist[index], wordlist, notCorrectSet, correctSet);
            }
            System.out.println(res);
        }
    }

    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i)) matches++;
        return matches;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist)
                if (match(guess, w) == x) wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }

    private void addCorrectSet(String s, String[] wordList, Set correctSet) {
        Set set = new HashSet();
        //        System.out.println("enter correct.size()" + correctSet.size());
        for (int i = 0; i < wordList.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == wordList[i].charAt(j)) {
                    set.add(i);
                }
            }
        }
        Set setTemp = (Set) correctSet.stream().filter(e -> set.contains(e))
                .collect(Collectors.toSet());
        correctSet.clear();
        correctSet.addAll(setTemp);
        //        System.out.println("enter correct.size()" + correctSet.size());
    }

    private void addNotCorrectSet(String s, String[] wordlist, Set notCorrect, Set correctSet) {
        //        System.out.println("enter " + s);
        for (int i = 0; i < wordlist.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (wordlist[i].charAt(j) == s.charAt(j)) {
                    notCorrect.add(i);
                    correctSet.remove(i);
                    //                    System.out.println("remove " + wordlist[i]);
                    break;
                }
            }
        }
        //        System.out.println("notCorrect.size()" + notCorrect.size());
    }

    private void delete() {

    }
    /*    "ccoyyo"
            ["wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb","xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro","nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg","tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp","szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd","vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc","kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm","jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb","ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf","chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq"]
            10*/

    static class Master {

        String key = "ccoyyo";

        public int guess(String word) {
            int hitCnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == key.charAt(i)) {
                    hitCnt++;
                }
            }
            return hitCnt == 0 ? -1 : hitCnt;
        }
    }
}
