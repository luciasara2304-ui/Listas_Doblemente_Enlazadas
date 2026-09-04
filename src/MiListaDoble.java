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
        if (node == null) return null;

        Object valor = node.dato;

        while (valor instanceof DoubleNode) {
            valor = ((DoubleNode) valor).dato;
        }

        return valor;
    }

    @Override
    public DoubleNode search(Object object) {
        if (object == null || isEmpty()) return null;

        DoubleNode actual = this.cabeza;
        while(actual != null){
            Object valorActual = actual.dato;

            if (valorActual instanceof DoubleNode) {
                valorActual = ((DoubleNode) valorActual).dato;
            }

            if (valorActual != null && valorActual.equals(object)) {
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
        if (node == null || isEmpty()) return false;

        DoubleNode actual = this.cabeza;
        while (actual != null && actual != node && actual.dato != node) {
            actual = actual.siguiente;
        }

        if (actual == null) return false;

        if (actual == this.cola) {
            return add(object);
        }

        DoubleNode nuevoNodo = new DoubleNode(object);
        nuevoNodo.siguiente = actual.siguiente;
        nuevoNodo.anterior = actual;

        if (actual.siguiente != null) {
            actual.siguiente.anterior = nuevoNodo;
        }
        actual.siguiente = nuevoNodo;

        return true;
    }

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

        DoubleNode actual = this.cabeza;

        while (actual != null) {
            if (actual == node || actual.dato == node) {

                if (actual == this.cabeza) {
                    this.cabeza = actual.siguiente;
                    if (this.cabeza != null) {
                        this.cabeza.anterior = null;
                    } else {
                        this.cola = null;
                    }
                }

                else if (actual == this.cola) {
                    this.cola = (DoubleNode) actual.anterior;
                    if (this.cola != null) {
                        this.cola.siguiente = null;
                    }
                }

                else {
                    DoubleNode ant = (DoubleNode) actual.anterior;
                    DoubleNode sig = actual.siguiente;

                    if (ant != null) {
                        ant.siguiente = sig;
                    }
                    if (sig != null) {
                        sig.anterior = ant;
                    }
                }

                actual.anterior = null;
                actual.siguiente = null;

                return true;
            }
            actual = actual.siguiente;
        }

        return false; //
    }

    // --- ESQUELETOS DE OPERACIONES DE EXPANSIÓN ---

    @Override
    public boolean contains(Object object) {
        if (object == null || isEmpty()) {
            return false;
        }

        DoubleNode actual = this.cabeza;
        while (actual != null) {
            if (object.equals(actual.dato)) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        if (isEmpty()) {
            return new Object[0];
        }

        Object[] arreglo = new Object[getSize()];
        DoubleNode actual = this.cabeza;
        int i = 0;

        while (actual != null) {
            if (actual.dato instanceof DoubleNode) {
                arreglo[i] = ((DoubleNode) actual.dato).dato;
            } else {
                arreglo[i] = actual.dato;
            }
            actual = actual.siguiente;
            i++;
        }

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int tamanio = getSize();

        if (object == null || object.length < tamanio) {
            object = new Object[tamanio];
        }

        DoubleNode actual = this.cabeza;
        int i = 0;

        while (actual != null && i < tamanio) {
            Object valor = actual.dato;

            while (valor instanceof DoubleNode) {
                valor = ((DoubleNode) valor).dato;
            }

            object[i] = valor;
            actual = actual.siguiente;
            i++;
        }

        if (object.length > tamanio) {
            object[tamanio] = null;
        }

        return object;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble sublista = new MiListaDoble();

        if (from == null || to == null || isEmpty()) {
            return sublista;
        }

        DoubleNode actual = this.cabeza;
        while (actual != null && actual != from && actual.dato != from) {
            actual = actual.siguiente;
        }

        if (actual == null) return sublista;

        boolean alcanzado = false;
        while (actual != null && !alcanzado) {

            Object valor = actual.dato;
            while (valor instanceof DoubleNode) {
                valor = ((DoubleNode) valor).dato;
            }

            sublista.add(valor);

            if (actual == to || actual.dato == to) {
                alcanzado = true;
            }

            actual = actual.siguiente;
        }

        return sublista;
    }

    @Override
    public MiListaDoble sortList() {
        return null;
    }
}