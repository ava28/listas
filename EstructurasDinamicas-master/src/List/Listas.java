package List;

import Excepciones.isEmptyException;
import Nodes.Node;

import java.util.Iterator;

public interface Listas<T extends Comparable<T>> extends Iterable<T> {

    boolean Add(T value);

    boolean Add(Node<T> node);

    boolean AddAtStart(T value);

    boolean AddAtStart(Node<T> node);

    boolean AddAt(int position, T value);

    boolean AddAt(Node<T> value, int position);

    boolean AddAfter(T after, T value);

    boolean AddBefore(T before, T value);

    boolean RemoveAll(T value);

    boolean RemoveBefore(Node<T> node);

    boolean RemoveBefore(T value);

    boolean RemoveAfter(T value);

    boolean Remove(T value);

    boolean Remove(Node<T> node);

    boolean RemoveAtStart() throws isEmptyException;

    Node<T> getElementAt(int value);

    boolean isEmpty() throws isEmptyException;

    long getLength();

    Iterator<T> iterator();
}
