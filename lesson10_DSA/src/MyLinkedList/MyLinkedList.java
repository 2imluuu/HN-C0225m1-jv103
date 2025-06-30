package MyLinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data){
        head = new Node(data);
        numNodes++;
    }

    private class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public void add(int index, E element){
        if( index < 0 || index > numNodes){
            throw new IndexOutOfBoundsException("<UNK>");
        }
        if ( index == 0 ){
            addFirst(element);
        } else {
            Node temp = head;
            for ( int i = 0; i < index - 1; i++ ){
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast( E element){
        if ( head == null ){
            addFirst(element);
        } else {
            Node temp = head;
            while ( temp.next != null ){
                temp = temp.next;
            }
            temp.next = new Node(element);
            numNodes++;
        }
    }

    public E remove(int index){
        if ( index < 0 || index > numNodes){
            throw new IndexOutOfBoundsException("<UNK>");
        }
        Node temp = head;
        if ( index == 0 ){
            E removed = (E) head.data;
            head = head.next;
            numNodes--;
            return removed;
        } else {
            for ( int i = 0; i < index - 1; i++ ){
                temp = temp.next;
            }
            E removed = (E) temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
            return removed;
        }
    }

}
