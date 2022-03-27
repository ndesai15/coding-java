package com.coding.patterns.queue;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int index;
    public char ch;

    public Pair(int index, char ch) {
        this.index = index;
        this.ch = ch;
    }
}
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < dom.length; i++) {
            if (dom[i] != '.') {
                queue.add(new Pair(i, dom[i]));
            }
        }


        while(!queue.isEmpty()) {
            Pair pair = queue.remove();

            if (pair.ch == 'L' && (pair.index > 0 && dom[pair.index - 1] == '.')){
                queue.add(new Pair(pair.index - 1, 'L'));
                dom[pair.index - 1] = 'L';
            }

            else if (pair.ch == 'R') {
                if (pair.index + 1 < dom.length && dom[pair.index + 1] == '.') {
                    if (pair.index + 2 < dom.length && dom[pair.index + 2] == 'L') {
                        queue.remove();
                    }
                    else {
                        queue.add(new Pair(pair.index + 1, 'R'));
                        dom[pair.index + 1] = 'R';
                    }
                }
            }
        }

        return new String(dom);
    }
}
