package Aufgabe6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListGen<X> implements Iterable<X> {


    private int counter;  // counter>=0
    private ListGenNode<X> head;
    private ListGenNode<X> tail;

    /**
     * Initializes 'this' as an empty list.
     */
    public SinglyLinkedListGen(){

    }

    /**
     * Adds an element at the beginning of the list (head).
     *
     * Design by Contract (DbC):
     * - Precondition: e != null.
     * - Postcondition: If the list is empty, 'e' becomes the first element (head = tail).
     *                  If the list is not empty, 'e' is added to the front of the list, making it the new head.
     */
    public void addFirst(X e) {
        if(indexOf(e)!=-1){
            return;
        }
        if (head == null) {
            head = tail = new ListGenNode<>(e, null);
        } else {
            head = new ListGenNode<>(e, head);

        }
        counter++;
    }


    /**
     * Design by Contract (DbC):
     * - Precondition: e!=null
     * - Postcondition: if the list is empty, it receives its first element and head=tail, else the methode
     * appends the specified element 'e' to the end of this list.
     *
     */
    public void addLast(X e) {

        if (head == null) {
            head = tail = new ListGenNode<>(e, null);
        } else {
            ListGenNode<X> newN = new ListGenNode<>(e, null);
            tail.setNext(newN);
            tail = newN;
        }
        counter++;
    }

    /**
     * Returns the element with the specified index in this list. Returns 'null' if the list is
     * empty.
     *
     * @param i the list index of the element to be retrieved
     * Design by Contract (DbC):
     * - Precondition: i >= 0 && i < size().
     * - Postcondition returning the retrieved element at the specified position.
     */
    public X get(int i) {

        ListGenNode<X> current = head;
        for (;i > 0; i--) {
            current = current.getNext();
        }
        return current.getValue();

    }

    /**
     * Returns the index  of the specified element in this list, or -1 if
     * this list does not contain the element. More formally, returns the lowest index i such
     * that e == get(i), or -1 if there is no such index.
     *
     * @param e the body to search for.
     * Design by Contract (DbC):
     * - Precondition: e!=null
     * - Postcondition: e == get(i) XOR -1
     *
     */
    public int indexOf(X e) {

        ListGenNode current = head;
        for (int i = 0; current != null; current = current.getNext(), i++) {
            if (current.getValue().equals(e)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: return this.counter
     */
    public int size() {

        if (head == null) {
            return 0;
        }
        return counter;
    }

    /**
     * Returns an iterator over elements of type 'X'.
     *
     * @return an iterator over elements of type 'X'.
     */
    @Override
    public Iterator<X> iterator() {
        return new LinkedListGenIter<>(this);
    }


    /**
     * Removes the element at the specified position in the linked list.
     * Shifts any subsequent elements to the left (i.e., subtracts one from their indices).
     *
     * Design by Contract (DbC):
     * - Precondition: The index `i` must be greater than or equal to `0` and less than the size of the list.
     * - Postcondition: The element at the specified position is removed from the list, and all subsequent
     *   elements are shifted one position to the left. The object variable counter is reduced by 1.
     *
     * @param i the index of the element to be removed
     * does nothing if the index `i` is out of range (`i < 0 || i >= size()`).
     */
    public void remove(int i) {
        if (head != null) {

            if (i == 0 && head.getNext() == null) {
                head = null;
            } else if (i == 0) {
                head = head.getNext();
            } else {
                ListGenNode<X> help = head;
                for (int j = 0; j < i - 1; j++) {
                    help = help.getNext();
                }
                ListGenNode<X> next = help.getNext().getNext();
                help.setNext(next);
            }
            counter--; // Decrement the node counter
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: Returns a string representation of the list.
     */
    public String toString() {
        if (head == null) {
            return "Empty";
        }
        String output = "";
        for (Object a : this){
            output += output.isEmpty()? a: "\n"+a;
        }
        output+="\n\n";
        return output;
    }
}


class ListGenNode<X> {
    private final X value; //value!=null
    private ListGenNode<X> next;

    /**
     * Design by Contract (DbC):
     * - Precondition: value!=null
     * - Postcondition: this.value=value && this.next=next
     *
     */
    public ListGenNode(X value, ListGenNode<X> next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: returning this.value
     *
     */
    public X getValue() {
        return value;
    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: this.next=next
     */
    public void setNext(ListGenNode<X> next) {
        this.next = next;
    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: returning this.next
     */
    public ListGenNode<X> getNext() {
        return next;
    }
}

class LinkedListGenIter<X> implements Iterator<X>{
    private SinglyLinkedListGen<X> list; //list!=null
    private int i=0; //i never decrements

    private X nextElement;


    /** Design by Contract (DbC):
     *  - Precondition: parameter 'list'!=null
     *  - Postcondtion: this.list has the same reference as the parameter 'list'
     *
     * */
    public LinkedListGenIter(SinglyLinkedListGen<X> list){
        this.list=list;
    }

    /**
     * Returns 'true' if the iteration has more elements, 'false' otherwise.
     *
     * @return 'true' if the iteration has more elements, 'false' otherwise.
     */
    @Override
    public boolean hasNext() {

        return i<list.size();
    }

    /**
     * Returns the next element of the iteration. Throws a 'java.util.NoSuchElementException'
     * with the detail message "There are no elements to get." if the iteration has no more elements.
     *
     * @return the next element of the iteration.
     * @throws NoSuchElementException if the iteration has no more elements. The detail message
     * is "There are no elements to get.".
     */
    @Override
    public X next() throws NoSuchElementException{
        if(!hasNext()){
            throw new NoSuchElementException("There are no elements to get");
        }
        nextElement = list.get(i);
        i++;
        return nextElement;

    }

    /**
     * Removes from the underlying collection the last element returned by
     * this iterator. This method can be called only once per call to next.
     * @throws NoSuchElementException if removed is called for a second time in a row. The detail message
     * is "Cannot remove element before calling next().".
     * */
    public void remove() throws NoSuchElementException {
        if (nextElement==null) {
            throw new NoSuchElementException("Cannot remove element before calling next().");
        }
        list.remove(list.indexOf(nextElement));
        nextElement = null;
    }
}


