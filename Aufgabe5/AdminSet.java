package Aufgabe5;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class AdminSet<X extends Approvable<P, T>, P, T extends Admin<? super X, T>> implements ApprovableSet<X, P, T> {

    private final SinglyLinkedList<X> listX;
    private final SinglyLinkedList<P> listP;

    public AdminSet(){
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
        return new FilteredIterator1P<>(listX,p,true);
    }

    @Override
    public Iterator<X> iteratorNot(P p) {

        return new FilteredIterator1P<>(listX,p,false);
    }

    @Override
    public Iterator<X> iterator() {

        return new FilteredIterator<>(listX,listP);
    }

    @Override
    public Iterator<P> criterions() {
        return listP.iterator();
    }

    /**
     * Extends the approval set for all elements in the container.
     * For each entry `p` returned by the `criterions` iterator, and for each entry `x` returned
     * by the `iterator(p)`, the method executes the operation:
     * `x.approve(p, x.approved(p).add(x))`.
     *
     * Design by Contract (DbC):
     * - Precondition: No specific preconditions.
     * - Postcondition: For each combination of `p` from the `criterions` iterator and `x` from
     *   `iterator(p)`, the approval set `x.approved(p)` includes `x` as an approved element.
     *   No changes occur if the container is empty or there are no matching elements.
     */
    public void extend(){
        Iterator<P> criterions = criterions();
        while(criterions.hasNext()){
            P p = criterions.next();
            Iterator<X> iterator = iterator(p);
            while(iterator.hasNext()){
                X x = iterator.next();
                x.approve(p, x.approved(p).add(x));
            }
        }
    }

    /**
     * Shortens the approval set for all elements in the container.
     * For each entry `p` returned by the `criterions` iterator, and for each entry `x` returned
     * by the `iterator(p)`, the method executes the operation:
     * `x.approve(p, x.approved(p).remove(x))`.
     *
     * Design by Contract (DbC):
     * - Precondition: No specific preconditions.
     * - Postcondition: For each combination of `p` from the `criterions` iterator and `x` from
     *   `iterator(p)`, the approval set `x.approved(p)` no longer includes `x` as an approved element.
     *   No changes occur if the container is empty or there are no matching elements.
     */
    public void shorten(){
        Iterator<P> criterions = criterions();
        while(criterions.hasNext()){
            P p = criterions.next();
            Iterator<X> iterator = iterator(p);
            while(iterator.hasNext()){
                X x = iterator.next();
                x.approve(p, x.approved(p).remove(x));
            }
        }
    }

    public String toString(){
        return "Elements: "+ listX + "\n" + "Criterions: "+listP;
    }
}



class FilteredIterator<X extends Approvable<P, T>, P, T> implements Iterator<X> {
    private final SinglyLinkedList<X> list; // The original iterator over the entries
    private final SinglyLinkedList<P> criteria;        // The criteria to filter the entries
    private X nextElement;
    private int i;// The next valid element


    public FilteredIterator(SinglyLinkedList<X> entries, SinglyLinkedList<P> criteria) {
        this.list = entries;
        this.criteria = criteria;
    }

    @Override
    public boolean hasNext() {
        // Look for the next valid element
        while (i < list.size()) {
            if (isValid(list.get(i))) {
                return true; // Found a valid element
            }
            i++; // Skip invalid elements
        }
        return false; // No more valid elements
    }

    @Override
    public X next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no elements to get");
        }

        // Get the next valid element
        nextElement = list.get(i++);
        return nextElement;

    }

    @Override
    public void remove() {
         if(nextElement==null){
             throw new NoSuchElementException("Cannot remove element before calling next().");// Delegate removal to the original iterator
         }
         list.remove(list.indexOf(nextElement));
         nextElement=null;
    }

    /**
     * Validates if the given candidate satisfies all the criteria.
     */
    private boolean isValid(X candidate) {
        for (P criterion : criteria) {
            // Check if the candidate is approved for the given criterion
            if (candidate.approved(criterion) == null) {
                return false;
            }
        }
        return true;
    }
}

class FilteredIterator1P<X extends Approvable<P, T>, P, T> implements Iterator<X> {
    private final SinglyLinkedList<X> list; // The original iterator over the entries
    private final P criterium;             // The criterion to filter the entries
    private X nextElement;                 // The next valid element
    private int i = 0;                     // The index of the next valid element
    private boolean in;                    // Whether to include or exclude approved elements

    public FilteredIterator1P(SinglyLinkedList<X> entries, P criterium, boolean in) {
        this.list = entries;
        this.criterium = criterium;
        this.in = in;
    }

    @Override
    public boolean hasNext() {
        // Look for the next valid element
        while (i < list.size()) {
            if (isValid(list.get(i))) {
                return true; // Found a valid element
            }
            i++; // Skip invalid elements
        }
        return false; // No more valid elements
    }

    @Override
    public X next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no elements to get");
        }

        // Get the next valid element
        nextElement = list.get(i++);
        return nextElement;
    }

    @Override
    public void remove() {
        if (nextElement == null) {
            throw new IllegalStateException("Cannot remove before calling next().");
        }
        list.remove(--i); // Remove the last returned element
        nextElement = null; // Reset the next element
    }

    /**
     * Checks if the current element satisfies the condition based on the `in` flag.
     */
    private boolean isValid(X candidate) {
        return in ? candidate.approved(criterium) != null : candidate.approved(criterium) == null;
    }

}