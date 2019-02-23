package Trabajos1_5;
import List.Metodo;
import Node.Node;

public class T4<T extends Comparable<T>> {
    static private long sumatoria = 0;

    public long sumatoria(Metodo<Integer> list) {
        sumatoria = 0;
        if (list.GetElementAt(0) != null)
            sumatoria(list.GetElementAt(0));
        return sumatoria;}

    private boolean sumatoria(Node<Integer> node) {
        if (node.getNext() == null) {
            sumatoria = sumatoria + node.getValue();
            return true;
        } else {
            sumatoria = sumatoria + node.getValue();
            return sumatoria(node.getNext());
        }
    }
}
