class TimeMap {
    private class Pair {
        int time;
        String val;
        Pair(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) return "";
        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            Pair p = list.get(mid);
            int curtime = p.time;
            if(curtime == timestamp) return p.val;
            if(timestamp > curtime) left = left + 1;
            else right = right - 1;
        }

        return right < 0 ? "" : list.get(right).val;
    }
}
