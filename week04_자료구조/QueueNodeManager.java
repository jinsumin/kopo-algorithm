package week04_자료구조;

/**
 * Created by soomin on 2022/04/13
 */

public class QueueNodeManager<T> {
    QueueNode<T> first, last;

    public QueueNodeManager() {
        first = last = null;
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    public void push(T data) {
        QueueNode<T> queueNode = new QueueNode<T>(data);
        if (isEmpty()) {
            this.first = this.last = queueNode;
        } else {
            this.first.setNextNode(queueNode);
            this.first = queueNode;
        }
    }

    public QueueNode<T> pop() {
        if (isEmpty()) {
            return null;
        } else {
            QueueNode<T> popNode = this.last;
            this.last = this.last.getNextNode();
            return popNode;
        }
    }

    public QueueNode<T> peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            return this.last;
        }
    }

    public int size() {
        QueueNode<T> first = this.first;
        QueueNode<T> last = this.last;
        int count = 0;
        while (first != last && last != null) {
            count++;
            last = last.getNextNode();
        }
        return count;
    }
}
