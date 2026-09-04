public class Main {
    public static void main(String[] args) {
        MiListaDoble lista = new MiListaDoble();

        DoubleNode n1 = new DoubleNode("Elemento 1");
        DoubleNode n2 = new DoubleNode("Elemento 2");
        DoubleNode n3 = new DoubleNode("Elemento 3");
        DoubleNode n4 = new DoubleNode("Elemento 4");

        n1.siguiente = n2;

        n2.anterior = n1;
        n2.siguiente = n3;

        n3.anterior = n2;
        n3.siguiente = n4;

        n4.anterior = n3;

        lista.cabeza = n1;
        lista.cola = n4;

        //Lista con nodos
        System.out.println("¿Está vacía?: " + lista.isEmpty());
        System.out.println("Tamaño: " + lista.getSize());
        System.out.println("Obtener la cabeza: " + lista.getHead());
        System.out.println("Obtener la cola: " + lista.getTail());
        System.out.println("Dato del nodo 2: " +lista.get(n2));
        lista.add("Elemento 5");
        System.out.println("Nodo encontrado: " + lista.get(lista.search("Elemento 3")));

        System.out.println("¿Insertado por nodo?: " + lista.insert(n2, "Elemento Insertado Nodo"));
        System.out.println("¿Insertado por objeto?: " + lista.insert("Elemento 5", "Elemento Insertado Objeto"));

        // Insertar al inicio y al final
        lista.insertHead("Elemento Inicio");
        lista.insertTail("Elemento Final");
        System.out.println("Nueva Cabeza: " + lista.getHead());
        System.out.println("Nueva Cola: " + lista.getTail());

        // Modificar y eliminar un nodo
        System.out.println("Dato original n2: " + lista.get(n2));
        System.out.println("¿Se modificó n2?: " + lista.set(n2, "Modificado"));
        System.out.println("Nuevo dato de n2: " + lista.get(n2));
        System.out.println("¿Se eliminó n2?: " + lista.remove(n2));


        //Después de vaciar la lista
        lista.clear();
        System.out.println("DESPUES DE VACIAR LA LISTA ");
        System.out.println("¿Está vacía?: " + lista.isEmpty());
    }
}
