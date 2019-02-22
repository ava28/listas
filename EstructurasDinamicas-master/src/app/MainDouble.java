package app;

import List.DoubleLinkedList;
import List.Listas;

public class MainDouble {

    public static Listas<Integer> list1;
    public static Listas<Integer> list2;

    public static void main(String[] args) {
        
        System.out.println("Ejercicio con listas doblemente enlazadas");
        
        
        list1 = new DoubleLinkedList<>();
        list2 = new DoubleLinkedList<>();

        for (int i = 0; i < 20; i++) {
            list1.Add(i);
            list2.Add(i);
        }

        // Métodos de la clase
        list1.Add(10);  //Añade al final
        list1.AddAt(10, 10); //Añade en posición X
        list1.AddAtStart(10); //Añade en el inicio
        list1.AddAfter(10, 10); //Añade después del valor
        list1.AddBefore(10, 10); //Añade antes del valor
        list1.Remove(10); //Retira la primera ocurrencua
        list1.RemoveBefore(10); //Retira la primera ocurrencia antes de
        list1.RemoveAfter(10); //Retira la primera ocurrrencia después de
        //Los métodos arriba invocados pueden utilizarse en un ciclo para repetición.
        list1.getElementAt(10); //Obtiene el nodo en la posición X
        list1.RemoveAll(10); //Retira todos los elementos concurrentes
        
    }
}
