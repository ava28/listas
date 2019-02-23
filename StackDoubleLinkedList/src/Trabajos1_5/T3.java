package Trabajos1_5;
import List.Metodo;
import Node.Node;

public class T3<T extends Comparable<T>> {
    static private int count = 0;

    public int Ocurrencias(T value, Metodo<T> lista) {
        if (lista.GetElementAt(0) != null) {
            Ocurrencias(value, lista.GetElementAt(0));}
        return count;}

    private boolean Ocurrencias(T value, Node<T> node) {
        if (node.getNext() == null) {
            if (node.getValue().equals(value)) {
                count++;}
            return true;} 
        else {
            if (value.equals(node.getValue())) {
                count++;
                return Ocurrencias(value, node.getNext());}
            else {
                return Ocurrencias(value, node.getNext());}
        }
    }

}
