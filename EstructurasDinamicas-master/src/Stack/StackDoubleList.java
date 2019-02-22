package Stack;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.DoubleLinkedList;
import List.Listas;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class StackDoubleList<T extends Comparable<T>> implements Stacks<T>, Iterable<T>, Comparable<Stacks>, Comparator<Stacks> {

    private Listas<T> pila;
    private int length, top;

    public Listas<T> getPila() {
        return pila;
    }

    @Override
    public int getTop() {
        return this.top;
    }

    public StackDoubleList() {
        pila = new DoubleLinkedList<>();
    }

    public StackDoubleList(T value) {
        this();
        pila = new DoubleLinkedList<>(value);
        this.top = 0;
    }

    public StackDoubleList(int length) {
        pila = new DoubleLinkedList<>();
        this.length = length;
        this.top = -1;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() throws isEmptyException {
        if (top < 0) {
            throw new isEmptyException("Stack is empty");
        } else return false;
    }

    @Override
    public boolean isFull() throws isFullException {
        if (top == (length - 1)) {
            throw new isFullException("Stack is full");
        } else return false;
    }

    @Override
    public boolean push(T value) {
        boolean d1 = true;
        try {
            isFull();
        } catch (isFullException e) {
            System.out.println(e.getMessage());
            d1 = Resize();
        } finally {
            if (d1) Add(value);
        }
        return d1;
    }

    private void Add(T value) {
        pila.AddAtStart(value);
        top++;
    }

    private boolean Resize() {
        System.out.println("Do you want to make it bigger? (s/n) ");
        Scanner in = new Scanner(System.in);
        String opc = in.next();
        if(opc.equals("s") || opc.equals("S")){
            length++;
            return true;
        } else return false;
    }

    @Override
    public T pop() {
        try {
            isEmpty();
            T pop = pila.getElementAt(0).getValue();
            pila.Remove(pila.getElementAt(0));
            top--;
            return pop;
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public T peak() {
        try{
            isEmpty();
            return pila.getElementAt(top).getValue();
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public Iterator<T> iterator() {
        return pila.iterator();
    }


    @Override
    public int compareTo(Stacks o) {
        if(o.getLength() == this.length){
            int i =0;
            for (Object o1 : o){
                if(!this.getPila().getElementAt(i).getValue().equals(o.getPila().getElementAt(i).getValue())){
                    if(this.getPila().getElementAt(i).getValue().compareTo((T) o.getPila().getElementAt(i).getValue()) > 0){
                        return 1;
                    } else {
                        return -1;
                    }
                }
                i++;
            }
            return 0;
        } else if (this.length > o.getLength()){
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int compare(Stacks o1, Stacks o2) {
        return o1.compareTo(o2);
    }
   
    
}