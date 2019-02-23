package app;

import Excepciones.IsEmptyException;
import Excepciones.IsFullException;
import stackDoubleLinkedList.StackDoubleLinkedList;

public class Main {

    public static void main(String[] args) {
        StackDoubleLinkedList<Double> pila = new StackDoubleLinkedList<>(5);
        try {
            pila.push(30d);
            pila.push(40d);
            pila.push(10d);
            pila.push(60d);
            pila.push(45d);
            pila.push(50d);

            for (Double double1 : pila) {
                System.out.println(double1);
            }

            System.out.println("El proximo Valor en salir es el : " + pila.peek());
            System.out.println("Sacando el valor " + pila.pop());

            for (Double double1 : pila) {
                System.out.println(double1);
            }
            
        } catch (IsFullException | IsEmptyException e) {
            System.err.println(e.getMessage());
        }
    }
}