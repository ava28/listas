package stackDoubleLinkedList;

import Excepciones.IsEmptyException;
import Excepciones.IsFullException;
import List.DoubleLinkedList;
import java.util.Iterator;
import java.util.Scanner;
import stack.Stack;

public class StackDoubleLinkedList<T extends Comparable<T>> implements Stack<T>, Iterable<T> {

    private DoubleLinkedList list = new DoubleLinkedList();
    private long capacity;

    public StackDoubleLinkedList(long capacidad) {
        this.capacity = capacidad;
    }

    @Override
    public long size() {
        return list.Length();
    }

    @Override
    public void push(T value) throws IsFullException {
        boolean flag = true;
        try {
            isFull();
        } catch (IsFullException e) {
            System.err.println(e.getMessage());
            flag = resize();
        } finally {
            if (flag) {
                list.Add(value);
            }
        }
    }

    private boolean resize() {
        Scanner leer = new Scanner(System.in);
        String resp;
        System.out.println("¿Desea incrementar la capacidad del Stack?");
        resp = leer.next();
        if (resp.toLowerCase().equals("s") || resp.toLowerCase().equals("si")) {
            capacity++;
            return true;
        }
        return false;
    }

    @Override
    public T pop() throws IsEmptyException {
        try {
            isEmpty();
        } catch (IsEmptyException e) {
            throw new IsEmptyException(e.getMessage());
        }
        T tmp = (T) list.GetLastElement();
        if (list.Remove(list.GetLastElement())) {
            return tmp;
        } else {
            return null;
        }
    }

    @Override
    public T peek() throws IsEmptyException {
        try {
            isEmpty();
        } catch (IsEmptyException e) {
            throw new IsEmptyException(e.getMessage());
        }
        return (T) list.GetLastElement();
    }

    @Override
    public void isEmpty() throws IsEmptyException {
        if (list.Length() < 0) {
            throw new IsEmptyException("Stack vacio");
        }
    }

    @Override
    public void isFull() throws IsFullException {
        if (list.Length() == capacity - 1) {
            throw new IsFullException("Stack lleno.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        
        return list.iterator();

    }
}
