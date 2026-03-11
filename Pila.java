public class Pila {

    Nodo tope;

    public Pila() {
        tope = null;
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return tope == null;
    }

    // Insertar pizza en la pila
    public void push(Pizza pizza) {

        Nodo nuevo = new Nodo(pizza);

        nuevo.siguiente = tope; 
        tope = nuevo; 
    }

    // Sacar pizza de la pila
    public Pizza pop() {

        if (isEmpty()) {
            return null;
        }

        Pizza pizza = tope.pizza;
        tope = tope.siguiente;

        return pizza;
    }

    // Ver pizza en el tope sin eliminar
    public Pizza peek() {

        if (isEmpty()) {
            return null;
        }

        return tope.pizza;
    }
}