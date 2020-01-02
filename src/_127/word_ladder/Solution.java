package _127.word_ladder;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int length = new Solution().ladderLength(beginWord, endWord, wordList);
        long end = System.currentTimeMillis();
        System.out.println(String.format("length=%d, time took=%d", length, end - start));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> metaStrsMap = new HashMap<>(wordList.size() * beginWord.length());
        for (String word : wordList) {
            for (String metaStr : getMetaStrs(word)) {
                List<String> neighbors = metaStrsMap.getOrDefault(metaStr, new ArrayList<>());
                neighbors.add(word);
                metaStrsMap.put(metaStr, neighbors);
            }
        }

        Set<String> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (endWord.equals(node.val)) return node.rank;

            for (String metaStr : getMetaStrs(node.val)) {
                if (!metaStrsMap.containsKey(metaStr)) continue;
                for (String neighbor : metaStrsMap.get(metaStr)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(new Node(neighbor, node.rank + 1));
                        visited.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    List<String> getMetaStrs(String from) {
        List<String> strs = new ArrayList<>(from.length());
        for (int i = 0; i < from.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(from.substring(0, i));
            sb.append("*");
            sb.append(from.substring(i + 1, from.length()));
            strs.add(sb.toString());
        }
        return strs;
    }

    static class Node {
        final String val;
        final int rank;

        Node(String val, int rank) {
            this.val = val;
            this.rank = rank;
        }
    }
}