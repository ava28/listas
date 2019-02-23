package Trabajos1_5;
import List.Metodo;
import Node.Node;

public class T2<T extends Comparable<T>> {
    public boolean SiExElem(T value, Metodo<T> lista) {
        if (SiExElem(value, lista.GetElementAt(0))) {
            return true;}
        else {
            return false;}
    }
    private boolean SiExElem(T value, Node<T> node) {
        if (node.getNext() == null) {
            return false;
        } else {
            if (value.equals(node.getValue())) {
                return true;
            } else {
                return SiExElem(value, node.getNext());
            }
        }
    }
}
