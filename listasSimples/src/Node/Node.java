
package Node;


public class Node <T extends Comparable <T>>{
    private T value;
    private Node <T> next;
    private Node <T> back; // para listas dobles

    public Node(T value,Node<T> next) {
        this.next = next;
        this.value= value;
    }
    
    public Node(T value,Node<T> next,Node<T> back) {
        this.next = next;
        this.value= value;
        this.back = back; //para listas dobles
    }
    
    public Node (){
        this.value = null;
        this.next= null;
        this.back = null; // para listas dobles
    }
    
    public Node (T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node <T> getNext() {
        return next;
    }

    public void setNext(Node <T> next) {
        this.next = next;
    }

    public Node <T> getBack() {
        return back;
    }

    public void setBack(Node <T> back) {
        this.back = back;
    }
    
    
    
    
}
