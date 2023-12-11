package example.container;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Тесты на методы добавления и удаления класса Container
 */
public class Test2 extends TestCase {
    /**
     * Тест на методы добавления класса
     */
    @Test
    public void testAddMethod() {
        Container container = new Container();
        Item item = new Item(1);
        boolean added = container.add(item);
        assertTrue(added);
        assertEquals(1, container.size());
        assertTrue(container.contains(item));
    }

    /**
     * Тест на метод удаления класса
     */
    @Test
    public void testRemoveMethod() {
        Container container = new Container();
        Item item = new Item(1);
        container.add(item);
        boolean removed = container.remove(item);
        assertTrue(removed);
        assertEquals(0, container.size());
        assertFalse(container.contains(item));
    }
}
