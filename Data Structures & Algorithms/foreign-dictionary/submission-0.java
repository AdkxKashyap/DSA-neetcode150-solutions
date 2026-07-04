class Solution {
    List<Character>[] graph;
    int[] state;
    StringBuilder sb;
    boolean[] exists = new boolean[26];
    public String foreignDictionary(String[] words) {
        if(words == null || words.length <= 0) return "";
        graph = new ArrayList[26];
        state = new int[26];
        sb = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        if(!buildGraph(words)) return "";
        for(int i = 0; i < 26; i++) {
            if(exists[i] && state[i] == 0 && !dfs((char)('a' + i))) return "";
        }

        return sb.reverse().toString();
    }

    private boolean buildGraph(String[] words) {

        for (String word : words) {
        for (char c : word.toCharArray()) {
            exists[c - 'a'] = true;
        }
}

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return false;
            
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2) {
                    graph[c1 - 'a'].add(c2);
                    break;
                }
            } 
        }
        return true;
    }

    private boolean dfs(char node) {
        int idx = node - 'a';
        if(state[idx] == 2) return true; //visited
        if(state[idx] == 1) return false; // visiting. i.e in path
        state[node - 'a'] = 1;

        for(char nbr : graph[node - 'a']) {
            if(!dfs(nbr)) return false;
        }
        sb.append(node);
        state[idx] = 2;
        return true;
    }
}
