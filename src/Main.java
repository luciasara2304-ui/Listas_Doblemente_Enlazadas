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
        System.out.println("Obtener la cabeza: " + ((DoubleNode) lista.getHead()).dato);

        //Después de vaciar la lista
        lista.clear();
        System.out.println("DESPUES DE VACIAR LA LISTA ");
        System.out.println("¿Está vacía?: " + lista.isEmpty());
    }
}
