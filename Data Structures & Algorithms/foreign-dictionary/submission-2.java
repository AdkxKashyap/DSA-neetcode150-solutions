class Solution {
    private List<Character>[] graph;
    private int[] state;
    int n = 0;
    StringBuilder sb;
    public String foreignDictionary(String[] words) {
        if(words == null || words.length <= 1) return words[0];
        n = words.length;
        sb = new StringBuilder();
        state = new int[26];
        graph = new ArrayList[26];

        if(!buildGraph(words)) return "";
        for(int i = 0; i < 26; i++) {
            if(graph[i] != null && state[i] == 0 && !dfs(i)) return "";
        }
        return sb.reverse().toString();
    }

    private boolean dfs(int idx) {
        if(state[idx] == 2) return true;
        state[idx] = 1;

        for(char nbr : graph[idx]) {
            int nbIdx = nbr - 'a'; 
            if((state[nbIdx] == 0 && !dfs(nbIdx)) || state[nbIdx] == 1) return false;
        }

        state[idx] = 2;
        sb.append((char)('a' + idx));
        return true;
    }

    private boolean buildGraph(String[] words) {
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                if(graph[ch - 'a'] == null) graph[ch - 'a'] = new ArrayList<>();
            }
        }

        for(int i = 1; i < n; i++) {
            String w1 = words[i-1];
            String w2 = words[i];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return false;

            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);

                if(ch1 != ch2) {
                    graph[ch1 - 'a'].add(ch2);
                    break;
                }
            }
        }

        return true;
    }
}
