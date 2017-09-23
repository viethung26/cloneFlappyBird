package game2dpackage;
import java.util.ArrayList;

public class QueueList<T> {
	public ArrayList<T> queueList;
	public QueueList() {
		queueList = new ArrayList<T>();
	}
	public void push(T item) {
		queueList.add(item);
	}
	public void pop() {
		queueList.remove(0);
	}
	public T get(int i) {
		return queueList.get(i);
	}
}
