package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book b1 = new Book(1, "Book1", 200, "A1");
    private Book b2 = new Book(2, "Book2", 150, "A3");
    private Book b3 = new Book(3, "Book3", 200, "A1");
    private Book b4 = new Book(4, "Book4", 300, "A2");
    private Smartphone s1 = new Smartphone(1, "Phone1", 5500, "P3");
    private Smartphone s2 = new Smartphone(2, "Phone2", 8000, "P2");
    private Smartphone s3 = new Smartphone(3, "Phone3", 6000, "P2");
    private Smartphone s4 = new Smartphone(4, "Phone4", 8000, "P1");

    @BeforeEach
    void setUp(){
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] expected = new Product[]{b2};
        Product[] actual = manager.searchBy("Book2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        Product[] expected = new Product[]{s1};
        Product[] actual = manager.searchBy("Phone1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = new Product[]{b1, b3};
        Product[] actual = manager.searchBy("A1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {
        Product[] expected = new Product[]{s2, s3};
        Product[] actual = manager.searchBy("P2");
        assertArrayEquals(expected, actual);
    }
}
