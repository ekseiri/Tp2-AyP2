package estructuras;

public class ListNode<T> {

        public T element;
        public ListNode<T> next;

          // Constructors
        public ListNode( T element ) {
            this(element, null);
        }

        public ListNode(T element, ListNode<T> n) {
            this.element = element;
            next    = n;
        }
    }
