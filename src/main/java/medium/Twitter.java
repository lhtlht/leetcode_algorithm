package medium;

import java.util.*;


    /*
    355. 设计推特
    设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

    postTweet(userId, tweetId): 创建一条新的推文
    getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
    follow(followerId, followeeId): 关注一个用户
    unfollow(followerId, followeeId): 取消关注一个用户
    示例:
     */

class Twitter {
    private static int timestamp = 0;
    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private int id;
        public Set<Integer> followed; //关注列表
        public Tweet head; //发过的tweet链表
        public User(int userId) {
            this.id = userId;
            followed = new HashSet<Integer>();
            this.head = null;
            //关注自己
            followd(this.id);
        }

        public void followd(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            //不可取关自己
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;

            twt.next = head;  //新的tweet插入链表头
            head = twt;
        }
    }

    //将user 和 userId 对应起来
    private HashMap<Integer, User> userMap = new HashMap<Integer, User>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!userMap.containsKey(userId)) return res;

        //关注列表的用户id
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                //按照分数低到高，分数相等按名字
                return o2.time - o1.time;
            }
        };

        // 先将所有链表头节点插入优先级队列
        for (int id : users) {
            Tweet twt = userMap.get(id).head;
            if (twt == null) continue;
            pq.add(twt);
        }
        while (!pq.isEmpty()) {
            //最多返回10条
            if (res.size() == 10) break;
            Tweet twt = pq.poll();
            res.add(twt.id);
            //
            if (twt.next != null) pq.add(twt.next);

        }
        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        userMap.get(followerId).followd(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}



