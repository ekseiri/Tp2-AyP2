package estructuras;

public class ListNode<T> {

		public T element;
        public ListNode<T> next;
        
        public ListNode () {
        	this.element = null;
        }
        
        public ListNode (T element) {
            this.element = element;
            this.next = null;
        }

        public ListNode (T element, ListNode<T> n) {
            this.element = element;
            next = n;
        }
        
}
