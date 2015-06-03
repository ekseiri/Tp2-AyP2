package estructuras;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestIterator {

	private ListaEnlazada<String> l = new ListaEnlazada<String>();
	private ListaIterator<String> it;

	@Test
	public void seCreaIterador() {
		l.insert("1");
		l.insert("2");
		l.insert("3");
		l.insert("4");
		l.insert("5");

		it = l.iterator();
		Assert.assertEquals(it.getElement(), "1");
		it = l.iterator(0);
		Assert.assertEquals(it.getElement(), "1");
		it = l.iterator(1);
		Assert.assertEquals(it.getElement(), "2");
		it = l.iterator(2);
		Assert.assertEquals(it.getElement(), "3");
		it = l.iterator(3);
		Assert.assertEquals(it.getElement(), "4");
		it = l.iterator(4);
		Assert.assertEquals(it.getElement(), "5");
		it = l.iterator(l.getSize() - 1);
		Assert.assertEquals(it.getElement(), "5");

	}

	@Test
	public void next() {
		l.insert("1");
		l.insert("2");
		l.insert("3");
		l.insert("4");
		l.insert("5");

		it = l.iterator();
		Assert.assertEquals(it.getElement(), "1");
		it.next();
		Assert.assertEquals(it.getElement(), "2");
		it.next();
		Assert.assertEquals(it.getElement(), "3");
		it.next();
		Assert.assertEquals(it.getElement(), "4");
		it.next();
		Assert.assertEquals(it.getElement(), "5");

		// no se como testear it.next();
		// debe tirar exception
	}

	@Test
	public void first() {
		l.insert("1");
		l.insert("2");
		l.insert("3");
		l.insert("4");
		l.insert("5");

		it = l.iterator(2);
		Assert.assertEquals(it.getElement(), "3");
		it.first();
		Assert.assertEquals(it.getElement(), "1");
	}

	@Test
	public void hasNext() {
		l.insert("1");
		l.insert("2");
		it = l.iterator();
		Assert.assertTrue(it.hasNext());
		it.next();
		Assert.assertFalse(it.hasNext());
	}

	@Test
	// revisar
	public void insertarPrincipio() {
		l.insert("1");
		l.insert("3");
		l.insert("4");

		it = l.iterator();
		it.insert("2");
		Assert.assertEquals(it.getElement(), "1");
		it.next();
		Assert.assertEquals(it.getElement(), "2");
		it.next();
		Assert.assertEquals(it.getElement(), "3");
		it.next();
		Assert.assertEquals(it.getElement(), "4");
	}

	@Test
	public void insertarFinal() {
		l.insert("1");
		l.insert("2");
		l.insert("3");

		it = l.iterator(2);
		it.insert("4");
		it.next();
		Assert.assertEquals(it.getElement(), "4");
	}

	@Test
	public void insertarIntermedio() {
		l.insert("1");
		l.insert("2");
		l.insert("4");

		it = l.iterator(1);
		it.insert("3");
		it.first();
		Assert.assertEquals(it.getElement(), "1");
		it.next();
		Assert.assertEquals(it.getElement(), "2");
		it.next();
		Assert.assertEquals(it.getElement(), "3");
		it.next();
		Assert.assertEquals(it.getElement(), "4");
	}

	@Test
	public void borrar() {
		l.insert("1");
		l.insert("2");
		l.insert("3");

		it = l.iterator(1);
		it.delete();
		it.first();
		Assert.assertEquals(it.getElement(), "1");
		it.next();
		Assert.assertEquals(it.getElement(), "3");
	}

	@Rule
    public ExpectedException thrown= ExpectedException.none();
	@Test
	public void ExceptionNoNext() {
		thrown.expect(NoSuchElementException.class);
		l.insert("");

		it = l.iterator();
		it.next();
		
	}

	@Test
	public void CrearIteradorFueraDeLimite() {
		thrown.expect(NoSuchElementException.class);
		l.insert("1");
		l.insert("2");
		l.insert("3");
		l.insert("4");
		
		it = l.iterator(4);
		
	}
}
