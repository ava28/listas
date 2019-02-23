package Trabajos1_5;
import List.Metodo;
import Node.Node;

public class T1<T extends Comparable<T>> {
   public boolean Iguales(Metodo<T> v1, Metodo<T> v2) {
        if (v1.Length() != v2.Length()) {
            return false;
        } else {
            if (v1.GetElementAt(0) != null) {
                if (Comparar(v1.GetElementAt(0), v2.GetElementAt(0))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;}
        }
    }
    private boolean Comparar(Node<T> v1, Node<T> v2) {
        if (v1.getNext() == null && v2.getNext() == null) {
            return true;
        } else {
            if (v1.getValue().equals(v2.getValue())) {
                return Comparar(v1.getNext(), v2.getNext());
            } else {
                return false;}
        }
    }
}
