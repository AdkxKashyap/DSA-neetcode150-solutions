class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> set = new HashSet<>();
       Deque<String> que = new ArrayDeque<>();

       for(String word : wordList) {
        set.add(word);
       }
       if(!set.contains(endWord)) return 0;

       int steps = 1;
       que.offer(beginWord);
       set.remove(beginWord);
       while(!que.isEmpty()) {
        int sz = que.size();
        while(sz-- > 0) {
            String word = que.poll();
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                char curr = arr[i];
                for(int j = 0; j < 26; j++) {
                    char ch = (char)('a' + j);
                    if(ch == curr) continue;
                    arr[i] = ch;

                    String str = new String(arr);
                    if(str.equals(endWord)) return steps + 1;
                    if(set.contains(str)) {
                        que.offer(str);
                        set.remove(str);
                    }
                }
                arr[i] = curr;
            }
        }
        steps++;
       }
       return 0; 
    }
}
