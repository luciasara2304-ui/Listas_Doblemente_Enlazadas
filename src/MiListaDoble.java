import java.lang.classfile.attribute.StackMapFrameInfo;

public class MiListaDoble implements ListInterface {

    protected DoubleNode cabeza;
    protected DoubleNode cola;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        int contador = 0;
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
        this.cola = null;
    }

    @Override
    public Object getHead() {
        if (isEmpty()){
            return null;
        }
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (isEmpty()){
            return null;
        }
        return this.cola.dato; }

    @Override
    public Object get(DoubleNode node) {
        if (node == null){
            return null;
        }
        return node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode actual = this.cabeza;
        while(actual != null){
            if (actual.dato != null && actual.dato.equals(object)){
                return actual;
            }
            actual = actual.siguiente;
        }
        return null; }

    @Override
    public boolean add(Object object) {
        DoubleNode nuevoNodo = new DoubleNode(object);
        if (isEmpty()){
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            this.cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = this.cola;
            this.cola = nuevoNodo;
        }
        return true;
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) return false;

        if (node == this.cola) {
            return add(object);
        }

        DoubleNode nuevoNodo = new DoubleNode(object);
        nuevoNodo.siguiente = node.siguiente;
        nuevoNodo.anterior = node;

        if (node.siguiente != null) {
            node.siguiente.anterior = nuevoNodo;
        }
        node.siguiente = nuevoNodo;

        return true;}

    @Override
    public boolean insert(Object objectRef, Object object) {

        DoubleNode nodoEncontrado = search(objectRef);
        if (nodoEncontrado == null) return false;

        return insert(nodoEncontrado, object); }

    @Override
    public boolean insertHead(Object object) {
        if (object == null) return false;

        DoubleNode nuevoNodo = new DoubleNode(object);

        if (isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = this.cabeza;
            this.cabeza.anterior = nuevoNodo;
            this.cabeza = nuevoNodo;
        }
        return true;
        }

    @Override
    public boolean insertTail(Object object) {
        if (object == null) return false;

        DoubleNode nuevoNodo = new DoubleNode(object);

        if (isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            this.cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = this.cola;
            this.cola = nuevoNodo;
        }
        return true;}

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null || object == null) return false;

        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) {
            return false;
        }

        DoubleNode ant = (DoubleNode) node.anterior;
        DoubleNode sig = node.siguiente;

        if (node == this.cabeza && node == this.cola) {
            this.cabeza = null;
            this.cola = null;
        }
        else if (node == this.cabeza) {
            this.cabeza = sig;
            if (this.cabeza != null) {
                this.cabeza.anterior = null;
            }
        }

        else if (node == this.cola) {
            this.cola = ant;
            if (this.cola != null) {
                this.cola.siguiente = null;
            }
        }
        else {
            if (ant != null) {
                ant.siguiente = sig;
            }
            if (sig != null) {
                sig.anterior = ant;
            }
        }

        node.siguiente = null;
        node.anterior = null;

        return true;
    }

    // --- ESQUELETOS DE OPERACIONES DE EXPANSIÓN ---

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        return null;
    }

    @Override
    public MiListaDoble sortList() {
        return null;
    }
}