package estructuras;

public class ListNode<Cliente> extends Node {

        public ListNode<Cliente> next;
        
        public ListNode (Cliente element) {
            super(element);
            this.next = null;
        }

        public ListNode (Cliente element, ListNode<Cliente> n) {
            this.element = element;
            next = n;
        }
        
}
