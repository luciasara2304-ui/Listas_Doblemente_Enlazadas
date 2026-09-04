import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MiListaDoble lista = new MiListaDoble();

        DoubleNode n1 = new DoubleNode("Elemento 1");
        DoubleNode n2 = new DoubleNode("Elemento 2");
        DoubleNode n3 = new DoubleNode("Elemento 3");
        DoubleNode n4 = new DoubleNode("Elemento 4");
        lista.add(n1);
        lista.add(n2);
        lista.add(n3);
        lista.add(n4);


        System.out.println("¿Está vacía?: " + lista.isEmpty());
        System.out.println("Tamaño: " + lista.getSize());
        System.out.println("Obtener la cabeza: " + ((DoubleNode) lista.getHead()).dato);
        System.out.println("Obtener la cola: " + ((DoubleNode) lista.getTail()).dato);
        System.out.println("Dato del nodo 2: " + lista.get(n2));

        lista.add("Elemento 5");
        System.out.println("Nodo encontrado: " + lista.get(lista.search("Elemento 3")));


        System.out.println("¿Insertado por nodo?: " + lista.insert(n2, "Elemento Insertado Nodo"));
        System.out.println("¿Insertado por objeto?: " + lista.insert("Elemento 5", "Elemento Insertado Objeto"));


        lista.insertHead("Elemento Inicio");
        lista.insertTail("Elemento Final");
        System.out.println("Nueva Cabeza: " + lista.getHead());
        System.out.println("Nueva Cola: " + lista.getTail());


        System.out.println("Dato original n2: " + lista.get(n2));
        System.out.println("¿Se modificó n2?: " + lista.set(n2, "Modificado"));
        System.out.println("Nuevo dato de n2: " + lista.get(n2));
        System.out.println("¿Se eliminó n2?: " + lista.remove(n2));


        System.out.println("¿Contiene 'Elemento Inexistente'?: " + lista.contains("Elemento Inexistente"));
        System.out.println("Arreglo: " + Arrays.toString(lista.toArray()));

        DoubleNode desde = lista.search("Elemento Inicio");
        DoubleNode hasta = lista.search("Elemento 3");
        MiListaDoble sublista = lista.subList(desde, hasta);
        System.out.println("Sublista: " + Arrays.toString(sublista.toArray()));

        Object[] miArreglo = new Object[lista.getSize()];
        lista.toArray(miArreglo);
        System.out.println("Arreglo (con parámetro): " + Arrays.toString(miArreglo));

        MiListaDoble listaOrdenada = lista.sortList();
        System.out.println("Lista Ordenada: " + Arrays.toString(listaOrdenada.toArray()));

        lista.clear();
        System.out.println("DESPUES DE VACIAR LA LISTA ");
        System.out.println("¿Está vacía?: " + lista.isEmpty());
    }
}