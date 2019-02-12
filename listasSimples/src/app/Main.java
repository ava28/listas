package app;

import List.LinkedList;
import List.Listas;

public class Main {

    public static Listas<Integer> lista1;
    public static Listas<Integer> lista2;


    public static void main(String[] args) {
        Ejercicios ej = new Ejercicios();
        lista1 = new LinkedList<>();
        lista2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            lista1.Add(i);
            lista2.Add(i);
            
        }

        // Métodos extas
        System.out.print("Máximo elemento de la lista: ");
        System.out.println(ej.Maximo((LinkedList) lista1));
        System.out.print("Verifica si las listas son iguales: ");
        System.out.println(ej.Iguales((LinkedList) lista1, (LinkedList) lista2));
        System.out.print("Verifica si existe elemento en la lista y regresa la posición de la primera ocurrencia: ");
        System.out.println(ej.ExistElement(10, (LinkedList) lista1));
        System.out.print("Verifica el numero de ocurrencias de un elemento en una lista ");
        System.out.println(ej.Ocurrencia(10, (LinkedList) lista1));
        System.out.print("Hace la suma de elementos enteros en una lista");
        System.out.println(ej.Suma((LinkedList<Integer>) lista1));

        // Métodos de la clase

        lista1.Add(6);  //Añade al final
        lista1.AddAt(2, 16); //Añade en posición X
        lista1.AddAtStart(6); //Añade en el inicio
        lista1.AddAfter(8, 40); //Añade después del valor
        lista1.AddBefore(7, 23); //Añade antes del valor
        lista1.Remove(2); //Retira la primera ocurrencua
        lista1.RemoveBefore(4); //Retira la primera ocurrencia antes de
        lista1.RemoveAfter(10); //Retira la primera ocurrrencia después de

        //Los métodos arriba invocados pueden utilizarse en un ciclo para repetición.

        lista1.getElementAt(8); //Obtiene el nodo en la posición X
        lista1.RemoveAll(10); //Retira todos los elementos concurrentes
        
    }
}
