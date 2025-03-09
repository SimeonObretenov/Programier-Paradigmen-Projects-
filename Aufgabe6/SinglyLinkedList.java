package Aufgabe6;


import java.util.NoSuchElementException;

public class SinglyLinkedList implements CustomIterable {


    private int counter;  // counter>=0
    private ListNode head;
    private ListNode tail;

    /**
     * Initializes 'this' as an empty list.
     */
    public SinglyLinkedList(){

    }

    /**
     * Adds an element at the beginning of the list (head).
     *
     * Design by Contract (DbC):
     * - Precondition: e != null.
     * - Postcondition: If the list is empty, 'e' becomes the first element (head = tail).
     *                  If the list is not empty, 'e' is added to the front of the list, making it the new head.
     */
    public void addFirst(Object e) {
        if(indexOf(e)!=-1){
            return;
        }
        if (head == null) {
            head = tail = new ListNode(e, null);
        } else {
            head = new ListNode(e, head);

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
    public void addLast(Object e) {

        if (head == null) {
            head = tail = new ListNode(e, null);
        } else {
            ListNode newN = new ListNode(e, null);
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
    public Object get(int i) {

        ListNode current = head;
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
    public int indexOf(Object e) {

        ListNode current = head;
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


    @Override
    public CustomIterator iterator() {
        return new LinkedListIter(this);
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
                ListNode help = head;
                for (int j = 0; j < i - 1; j++) {
                    help = help.getNext();
                }
                ListNode next = help.getNext().getNext();
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


class ListNode {
    private final Object value; //value!=null
    private ListNode next;

    /**
     * Design by Contract (DbC):
     * - Precondition: value!=null
     * - Postcondition: this.value=value && this.next=next
     *
     */
    public ListNode(Object value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: returning this.value
     *
     */
    public Object getValue() {
        return value;
    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: this.next=next
     */
    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: returning this.next
     */
    public ListNode getNext() {
        return next;
    }
}

class LinkedListIter implements CustomIterator{
    private SinglyLinkedList list; //list!=null
    private int i=0; //i never decrements
    private Object nextElement;

    /** Design by Contract (DbC):
     *  - Precondition: parameter 'list'!=null
     *  - Postcondtion: this.list has the same reference as the parameter 'list'
     *
     * */
    public LinkedListIter(SinglyLinkedList list){
        this.list=list;
    }

    @Override
    public boolean hasNext() {

        return i<list.size();
    }


    @Override
    public Object next() throws NoSuchElementException{
        if(!hasNext()){
            throw new NoSuchElementException("There are no elements to get.");
        }
        nextElement = list.get(i);
        i++;
        return nextElement;

    }
    public void remove() throws NoSuchElementException {
        if (nextElement==null) {
            throw new NoSuchElementException("Cannot remove element before calling next().");
        }
        list.remove(list.indexOf(nextElement));
        nextElement = null;
    }
}


