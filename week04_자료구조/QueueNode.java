package week04_자료구조;

/**
 * Created by soomin on 2022/04/13
 */

public class QueueNode<T> {
    T data;
    QueueNode<T> queueNode;

    public QueueNode(T data) {
        this.data = data;
        queueNode = null;
    }

    public T getData() {
        return this.data;
    }

    public QueueNode<T> getNextNode() {
        return queueNode;
    }

    public void setNextNode(QueueNode<T> queueNode) {
        this.queueNode = queueNode;
    }
}
