package Stack;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.DoubleLinkedList;
import List.Listas;

import java.util.Comparator;

public interface Stacks<T extends Comparable <T>> extends Iterable<T>, Comparator<Stacks>, Comparable<Stacks> {

    int getTop();

    int getLength();

    boolean isEmpty() throws isEmptyException;

    boolean isFull() throws isFullException;

    boolean push(T value);

    T pop() throws isEmptyException;

    T peak();

    Listas<T> getPila();
}
