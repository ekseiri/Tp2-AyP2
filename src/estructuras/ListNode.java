package estructuras;
/**
 * Clase Nodo Lista Enlazada 
 *
 */
public class ListNode<T> {

		public T element;
        public ListNode<T> next;
        
        /**
         * Crea un nodo vacio
         *
         */
        
        public ListNode () {
        	this.element = null;
        }
        
        /**
         * Crea un nodo con un elemento
         * @param element
         * @
         */
        
        public ListNode (T element) {
            this.element = element;
            this.next = null;
        }

        /**
         * Crea un nodo con un elemento y se enlaza al nodo siguiente
         * @param element
         * @param n
         * 
         */
        
        public ListNode (T element, ListNode<T> n) {
            this.element = element;
            next = n;
        }
        
}
