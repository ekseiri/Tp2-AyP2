package estructuras;

import org.junit.Assert;
import org.junit.Test;


public class TestsLista {

	private ListaEnlazada l = new ListaEnlazada(); 
	
	@Test
	public void seCreaListaYEstaVacia() {
		ListaEnlazada lista = new ListaEnlazada();
		
		Assert.assertTrue(lista.isEmpty());
	}
	
	@Test
	public void seInsertaCorrectamenteUnElemento() {
		l.insert("elemento");
		
		Assert.assertEquals("elemento", l.top.element);
	}
	
	@Test
	public void seInsertanElementosYLaListaDejaDeEstarVacia() {
		l.insert("elemento");
		l.insert("elemento2");
		l.insert("elemento3");
		l.insert("elemento4");
		l.insert("elemento5");
	
		Assert.assertFalse(l.isEmpty());
	}
	
	@Test
	public void busquedaCorrecta() {
		l.insert("elemento");
		l.insert("elemento2");
		l.insert("elemento3");
		l.insert("elemento4");
		l.insert("elemento5");
		
		Assert.assertTrue(l.buscar("elemento4"));
		Assert.assertFalse(l.buscar("lista"));
	}
	@Test
	public void seInsertanElementosTopYBackCorrectos() {
		l.insert("elemento");
		l.insert("elemento2");
		l.insert("elemento3");
		l.insert("elemento4");
		l.insert("elemento5");
		
		Assert.assertTrue(l.top.element.equals("elemento"));
		Assert.assertTrue(l.back.element.equals("elemento5"));
	}
	
	@Test
	public void sizeReportadoCorrectamente() {
		l.insert("elemento");
		l.insert("elemento2");
		l.insert("elemento3");
		l.insert("elemento4");
		l.insert("elemento5");
		
		Assert.assertEquals("", 5, l.getSize(), 0.0001);
	}
	
	@Test
	public void seEliminaElElementoIndicado() {
		l.insert("elemento");
		l.insert("elemento2");
		l.insert("elemento3");
		l.insert("elemento4");
		l.insert("elemento5");
		
		l.delete("elemento3");
		
		Assert.assertEquals("",4, l.getSize(), 0.0001);
		Assert.assertFalse(l.buscar("elemento3"));
		Assert.assertTrue(l.buscar("elemento"));
		Assert.assertTrue(l.buscar("elemento2"));
		Assert.assertTrue(l.buscar("elemento4"));
		Assert.assertTrue(l.buscar("elemento5"));
		
	}
	
	@Test
	public void seEliminanTodosLosElementos(){
		l.insert("elemento");
		l.insert("elemento2");
		l.insert("elemento3");
		l.insert("elemento4");
		l.insert("elemento5");
		
		l.removeAll();
		Assert.assertEquals("",0, l.getSize(), 0.0001);
		
		Assert.assertNull(l.top);
		Assert.assertNull(l.back);
	}
}
