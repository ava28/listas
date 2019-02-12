package List;

import Node.Node;

import java.util.Iterator;

import Excepciones.isEmptyException;


public class LinkedList<T extends Comparable<T>> implements Listas<T> {
    private Node<T> head;

    private long lenght;

    public LinkedList(Node<T> _new) {
        this();
        this.head.setNext(_new);
    }

    public LinkedList() {
        this.head = new Node<>();
    }

    /**
     * @param value LinkedList values to add
     * @return if value has been successfully added, return true, else false
     * @author Abraham Vega Aviles
     **/

    @Override
    public boolean Add(T value) {
        Node<T> _new = new Node<>(value);
        try {
            Node<T> tmp = null;
            isEmpty();
            tmp = getLastElement(this.head);
            tmp.setNext(_new);
            lenght++;
        } catch (isEmptyException e) {
            head.setNext(_new);
            lenght++;
        }
        return true;
    }

    private Node<T> getLastElement(Node<T> tmp) {
        if (tmp.getNext() == null) {
            return tmp;
        } else {
            return getLastElement(tmp.getNext());
        }
    }

    @Override
    public boolean Add(Node<T> node) {
        return Add(node.getValue());
    }

    @Override
    public boolean AddAtStart(T value) {
        Node<T> _new = new Node<>(value);
        try {
            Node<T> tmp;
            isEmpty();
            tmp = head.getNext();
            head.setNext(_new);
            _new.setNext(tmp);
            lenght++;
        } catch (isEmptyException e) {
            head.setNext(_new);
            lenght++;
        }
        return true;
    }

    @Override
    public boolean AddAtStart(Node<T> node) {
        return AddAtStart(node.getValue());
    }

    @Override
    public boolean AddAt(int position, T value) {
        try {
            isEmpty();
            if (position >= lenght) {
                return false;
            } else {
                Node<T> _new = new Node<>(value);
                Node<T> next = getElementAt(position);
                Node<T> prev = getElementAt((position - 1));
                prev.setNext(_new);
                _new.setNext(next);
                lenght++;
                return true;
            }
        } catch (isEmptyException e) {
            return false;
        }
    }

    @Override
    public boolean AddAt(Node<T> value, int position) {
        return AddAt(position, value.getValue());
    }

    @Override
    public boolean AddAfter(T after, T value) {
        try {
            isEmpty();
            Node<T> _new, tmp;
            if ((tmp = getPrevElement(head, after)) != null) {
                _new = new Node<>(value);
                _new.setNext(tmp.getNext().getNext());
                tmp.getNext().setNext(_new);
                System.gc();
                lenght++;
                return true;
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }

    }

    @Override
    public boolean AddBefore(T before, T value) {
        try {
            if (isThere(head, value)) {
                isEmpty();
                Node<T> _new = new Node<>(value);
                Node<T> prev = getPrevElement(head, before);
                Node<T> next = prev.getNext();
                prev.setNext(_new);
                _new.setNext(next);
                lenght++;
                return true;
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }
    }

    @Override
    public boolean RemoveAll(T value) {
        try {
            isEmpty();
            while (isThere(head, value)) {
                Node<T> tmp = getPrevElement(head, value);
                Node<T> tmp2 = tmp.getNext();
                tmp2.setValue(null);
                tmp.setNext(tmp.getNext().getNext());
                lenght--;
                System.gc();
            }
            return true;
        } catch (isEmptyException e) {
            return false;
        }
    }

    @Override
    public boolean RemoveBefore(Node<T> node) {
        return RemoveBefore(node.getValue());
    }

    @Override
    public boolean RemoveBefore(T value) {
        try {
            isEmpty();
            if (isThere(head, value))
                return Remove(getPrevElement(head, value));
            return false;
        } catch (isEmptyException e) {
            return false;
        }
    }

    @Override
    public boolean RemoveAfter(T value) {
        try {
            isEmpty();
            if (isThere(head, value)) {
                return Remove(getPrevElement(head, value).getNext());
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }
    }


    private boolean isThere(Node<T> node, T value) {
        if (node.getNext() == null) {
            return false;
        } else if (node.getNext().getValue().equals(value)) {
            return true;
        } else {
            return isThere(node.getNext(), value);
        }
    }

    private Node<T> getPrevElement(Node<T> node, T value) {
        if (node.getNext().getValue().equals(value)) {
            return node;
        } else {
            if (node.getNext() == null) {
                return null;
            } else {
                return getPrevElement(node.getNext(), value);
            }
        }
    }

    @Override
    public boolean Remove(T value) {
        try {
            if(value == null) return false;
            isEmpty();
            Node<T> tmp = getPrevElement(head, value);
            if(tmp.getValue() == null) return false;
            if (tmp != null) {
                tmp.setNext(tmp.getNext().getNext());
                lenght--;
                System.gc();
            }
            return true;
        } catch (isEmptyException e) {
            return false;
        }
    }

    @Override
    public boolean Remove(Node<T> node) {
        return Remove(node.getValue());

    }

    @Override
    public Node<T> getElementAt(int value) {
        return getElementAt(head, 0, value);
    }


    private Node<T> getElementAt(Node<T> node, int index, int value) {
        if (node.getNext() == null) {
            return null;
        } else {
            if (value == index) {
                return node.getNext();
            } else {
                if (index >= value) {
                    return null;
                } else {
                    return getElementAt(node.getNext(), ++index, value);
                }
            }
        }
    }

    @Override
    public boolean isEmpty() throws isEmptyException {
        if (head.getNext() == null) {
            throw new isEmptyException("La lista está vacía");
        } else {
            return false;
        }
    }

    @Override
    public long getLength() {
        return this.lenght;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> cpy = head.getNext(), sub_head;

            @Override
            public boolean hasNext() {
                if (cpy == null) {
                    return false;
                } else {
                    sub_head = cpy;
                    cpy = cpy.getNext();
                    return true;
                }
            }

            @Override
            public T next() {
                return sub_head.getValue();
            }
        };
    }
}