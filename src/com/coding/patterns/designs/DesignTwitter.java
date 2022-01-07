package com.coding.patterns.designs;

import java.util.*;

/**
 * LeetCode Problem: https://leetcode.com/problems/design-twitter/
 * Similar Problem: Merge-K-Sorted Arrays
 */
class UserTweetTimeStamp {
    public int time;
    public int tweetId;

    public UserTweetTimeStamp(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }
}
class UserTweetTracker {
    public UserTweetTimeStamp user;
    public int followeeId;
    public int index;

    public UserTweetTracker(UserTweetTimeStamp user, int followeeId, int index) {
        this.user = user;
        this.followeeId = followeeId;
        this.index = index;
    }
}
class Twitter {
    // Keep track of Follower -> Followees
    Map<Integer, HashSet<Integer>> followMap;
    // Keep track of User -> List of tweets
    Map<Integer, List<UserTweetTimeStamp>> tweetMap;
    // Will act as a timer for tweets
    int time;
    public Twitter() {
        int time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<UserTweetTimeStamp>());
        }
        tweetMap.get(userId).add(new UserTweetTimeStamp(time, tweetId));
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<UserTweetTracker> maxHeap =
                new PriorityQueue<UserTweetTracker>((a, b) -> b.user.time - a.user.time);

        followMap.getOrDefault(userId, new HashSet<Integer>()).add(userId);
        for(Integer followeeId: followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                int index = tweetMap.get(followeeId).size() - 1;
                if (index < 0) continue;
                UserTweetTimeStamp current = tweetMap.get(followeeId).get(index);
                maxHeap.add(new UserTweetTracker(current, followeeId, index - 1));
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            UserTweetTracker ustt = maxHeap.poll();
            result.add(ustt.user.tweetId);
            if (ustt.index >= 0) {
                UserTweetTimeStamp temp = tweetMap.get(ustt.followeeId).get(ustt.index);
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
