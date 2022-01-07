package com.coding.patterns.designs;

import java.util.*;

/**
 * LeetCode Problem: https://leetcode.com/problems/design-twitter/
 */
class UserTweetCount {
    public int count;
    public int tweetId;

    public UserTweetCount(int count, int tweetId) {
        this.count = count;
        this.tweetId = tweetId;
    }
}
class UserTweetTracker {
    public UserTweetCount user;
    public int followeeId;
    public int index;

    public UserTweetTracker(UserTweetCount user, int followeeId, int index) {
        this.user = user;
        this.followeeId = followeeId;
        this.index = index;
    }
}
class Twitter {
    Map<Integer, HashSet<Integer>> followMap;
    Map<Integer, List<UserTweetCount>> tweetMap;
    int count;
    public Twitter() {
        int count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<UserTweetCount>());
        }
        tweetMap.get(userId).add(new UserTweetCount(count, tweetId));
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<UserTweetTracker> maxHeap = new PriorityQueue<UserTweetTracker>((a, b) -> b.user.count - a.user.count);

        followMap.getOrDefault(userId, new HashSet<Integer>()).add(userId);
        for(Integer followeeId: followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                int index = tweetMap.get(followeeId).size() - 1;
                if (index < 0) continue;
                UserTweetCount current = tweetMap.get(followeeId).get(index);
                maxHeap.add(new UserTweetTracker(current, followeeId, index - 1));
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            UserTweetTracker ustt = maxHeap.poll();
            result.add(ustt.user.tweetId);
            if (ustt.index >= 0) {
                UserTweetCount temp = tweetMap.get(ustt.followeeId).get(ustt.index);
                maxHeap.add(new UserTweetTracker(temp, ustt.followeeId, ustt.index - 1));
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<Integer>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)
                && followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
