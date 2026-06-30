class Twitter {

    private class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private class Node {
        int userId;
        int idx;
        Tweet tweet;

        Node(int userId, int idx, Tweet tweet) {
            this.userId = userId;
            this.idx = idx;
            this.tweet = tweet;
        }
    }

    private int timestamp;
    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> followMap;
    private int MAX = 10;

    public Twitter() {
        timestamp = 0;
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
            /*Add self as follower. My newsFeed should also contain my own feeds*/
            followMap.get(userId).add(userId);
        }

        if(!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());
        Tweet tweet = new Tweet(tweetId, timestamp++);
        tweets.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followers = followMap.get(userId);
        if(followers == null || followers.size() <= 0) return feed;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.time, a.tweet.time));

        for(int follower : followers) {
            List<Tweet> tweetslst = tweets.get(follower);
            if(tweetslst != null && tweetslst.size() > 0) {
                int idx = tweetslst.size() - 1;
                Tweet tweet = tweetslst.get(idx);

                Node nn = new Node(follower, idx, tweet);
                pq.offer(nn);
            }  
        }

        int count = 0;
        while(!pq.isEmpty() && count++ < MAX) {
            Node node = pq.poll();
            int idx = node.idx;
            int uid = node.userId;
            feed.add(node.tweet.id);
            if(idx - 1 >= 0) {
                Tweet tweet = tweets.get(uid).get(idx - 1);
                Node nn = new Node(uid, idx - 1, tweet);
                pq.offer(nn);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
            /*Add self as follower. My newsFeed should also contain my own feeds*/
            followMap.get(followerId).add(followerId);
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if(!followMap.containsKey(followerId)) return;
        followMap.get(followerId).remove(followeeId);
    }
}
