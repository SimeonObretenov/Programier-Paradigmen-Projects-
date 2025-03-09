package Aufgabe5;

import java.util.Iterator;

public class ApSet<X extends Approvable<P, T>, P, T> implements ApprovableSet<X, P, T>{
    private final SinglyLinkedList<X>  listX;
    private final SinglyLinkedList<P> listP;

    public ApSet(){
        listX=new SinglyLinkedList<>();
        listP=new SinglyLinkedList<>();
    }

    @Override
    public void add(X x) {
        listX.addFirst(x);
    }

    @Override
    public void addCriterion(P p) {
        listP.addFirst(p);
    }

    @Override
    public Iterator<X> iteratorAll() {
        return listX.iterator();
    }

    @Override
    public Iterator<X> iterator(P p) {

        return new FilteredIterator1P<>(listX, p, true);
    }

    @Override
    public Iterator<X> iteratorNot(P p) {
        return new FilteredIterator1P<>(listX, p, false);
    }

    @Override
    public Iterator<X> iterator() {
        return new FilteredIterator<>(listX,listP);
    }

    @Override
    public Iterator<P> criterions() {
        return listP.iterator();
    }

    public String toString(){
        return "Elements: "+ listX + "\n" + "Criterions: "+listP;
    }
}
