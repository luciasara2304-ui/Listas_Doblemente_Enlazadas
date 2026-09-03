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
        return this.cabeza;
    }

    @Override
    public Object getTail() { return null; }

    @Override
    public Object get(DoubleNode node) { return null; }

    @Override
    public DoubleNode search(Object object) { return null; }

    @Override
    public boolean add(Object object) { return false; }

    @Override
    public boolean insert(DoubleNode node, Object object) { return false; }

    @Override
    public boolean insert(Object objectRef, Object object) { return false; }

    @Override
    public boolean insertHead(Object object) { return false; }

    @Override
    public boolean insertTail(Object object) { return false; }

    @Override
    public boolean set(DoubleNode node, Object object) { return false; }

    @Override
    public boolean remove(DoubleNode node) { return false; }

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