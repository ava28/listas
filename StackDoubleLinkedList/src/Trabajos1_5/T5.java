package Trabajos1_5;
import List.Metodo;
import Node.Node;

public class T5<T extends Comparable<T>> {
    private T max = null;

    public T ValorMaximo(Metodo<T> list) {
        max = list.GetElementAt(0).getValue();
        ValorMaximo(list.GetElementAt(0));
        return max;}

    private T ValorMaximo(Node<T> node) {
        if (node.getNext() == null) {
            if (node.getValue().compareTo(max) > 0) {
                max = node.getValue();}
            return max;
        } else {
            if (node.getValue().compareTo(max) > 0) {
                max = node.getValue();
                return ValorMaximo(node.getNext());
            } else {
                return ValorMaximo(node.getNext()); }
        }
    }
}
