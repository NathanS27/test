package testFiles;

import java.util.*;

public class PriorityQueueWithDeletions <T extends Comparable<T>> {

	PriorityQueue<T> jobs=new PriorityQueue<>();
	Map<Integer,T> tickets=new TreeMap<>();
	
	public PriorityQueueWithDeletions() {
		
	}
	
	public Ticket add(T item) {
		Ticket tick = new Ticket();
		jobs.add(item);
		tickets.put(tick.getValue(), item);
		return tick;
	}
	
	public T removeHighestPriority() {
		return jobs.poll();
	}
	public T removeByTicket(Ticket t) {
		T temp=tickets.get(t.getValue());
		jobs.remove(tickets.get(t.getValue()));
		tickets.remove(t.getValue());
		return temp;
	}
	public int size() {
		return jobs.size();
	}
	public boolean isEmpty() {
		return jobs.isEmpty();
	}
}
