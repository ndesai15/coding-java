class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) {
            return 0;
        }
        var adjList = new HashMap<String, List<String>>();
        
        wordList.add(beginWord);
        
        //Word Lenght
        int l = beginWord.length();
        
        wordList.forEach(word -> {
            for(int i=0; i<l; i++) {
                adjList.computeIfAbsent(findPatten(word, i, l), k -> new ArrayList<>()).add(word);
            }
        });
        
        var visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        var level = 1;
        while(!queue.isEmpty()) {
            var qSize = queue.size();
            for(int i=0; i<qSize; i++) {
                var wordFromQ = queue.poll();
                
                if(wordFromQ.equals(endWord)) {
                    return level;
                }
                
                for(int j=0; j<l; j++) {
                    var pattern = findPatten(wordFromQ, j, l);
                
                    adjList.get(pattern).forEach(adjWrd -> {
                            if(!visited.contains(adjWrd)) {
                                queue.offer(adjWrd);
                                visited.add(adjWrd);
                            }
                        });
                    }
                }
            level++;
        }
        return 0;
    }
    
    private static String findPatten(String originalWord, int index, int maxLength) {
        return originalWord.substring(0, index) + "*" + originalWord.substring(index+1, maxLength);
    }
}
