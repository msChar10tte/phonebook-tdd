package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAdd() {
        int countAfterAdd = phoneBook.add("John Doe", "123456789");
        assertEquals(1, countAfterAdd);

        int countAfterDuplicateAdd = phoneBook.add("John Doe", "987654321");
        assertEquals(1, countAfterDuplicateAdd); // Размер не должен измениться
    }

    @Test
    public void testFindByNumber() {
        phoneBook.add("Jane Doe", "987654321");
        String name = phoneBook.findByNumber("987654321");
        assertEquals("Jane Doe", name);
    }

    @Test
    public void testFindByNumber_nonExistent() {
        String name = phoneBook.findByNumber("111222333");
        assertNull(name);
    }

    @Test
    public void testFindByName() {
        phoneBook.add("Peter Jones", "555666777");
        String number = phoneBook.findByName("Peter Jones");
        assertEquals("555666777", number);
    }

    @Test
    public void testFindByName_nonExistent() {
        String number = phoneBook.findByName("Unknown Person");
        assertNull(number);
    }

    @Test
    public void testPrintAllNames() {
        phoneBook.add("Charlie", "333");
        phoneBook.add("Alice", "111");
        phoneBook.add("Bob", "222");

        List<String> expected = List.of("Alice", "Bob", "Charlie");
        List<String> actual = phoneBook.printAllNames();

        assertEquals(expected, actual);
    }
}