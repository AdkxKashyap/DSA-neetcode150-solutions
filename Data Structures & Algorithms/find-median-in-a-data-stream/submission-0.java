class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    /* We maintain two heaps: a max heap for the smaller half and a min heap for the larger half */
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
