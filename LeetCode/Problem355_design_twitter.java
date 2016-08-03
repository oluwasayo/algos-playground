import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Twitter {
    
    private List<Pair> tweets = new ArrayList<>();
    private Map<Integer, Set<Integer>> followers = new HashMap<>();
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Pair(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(11);
        for (int a = tweets.size() - 1; a >= 0; a--) {
            Pair e = tweets.get(a);
            if (e.value == userId || (followers.containsKey(e.value) && followers.get(e.value).contains(userId))) {
                result.add(e.key);
                if (result.size() >= 10) break;
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.computeIfPresent(followeeId, (k, v) -> {v.remove(followerId); return v;});
    }
    
    private class Pair {
        int key, value;
        private Pair(int key, int value) {
            this.key = key; this.value = value;
        }
    }
}
