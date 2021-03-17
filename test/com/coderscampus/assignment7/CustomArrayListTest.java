package com.coderscampus.assignment7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    private CustomList<Integer> sut;

    @BeforeEach
    void init () {
        sut = new CustomArrayList<>();

        for (int i = 0; i < 20; i++) {
            sut.add(i+1);
        }
    }

    @Test
    void should_add_into_middle_of_arraylist() {
        // Act
        sut.add(9, 100);

        // Assert
        Integer actual = sut.get(9);
        Integer expected = 100;
        assertEquals(expected, actual);

    }

    @Test
    void should_add_into_middle_of_large_arraylist() {
        // Arrange
        for (int i=0; i<100000; i++) {
            sut.add(i);
        }
        // Act
        sut.add(90000, -5);

        // Assert
        assertEquals(-5, sut.get(90000));
        assertEquals(100021, sut.getSize());
    }

    @Test
    void should_add_into_beginning_of_arraylist() {
        // Act
        sut.add(0, -5);

        // Assert
        assertEquals(-5, sut.get(0));
        assertEquals(21, sut.getSize());
    }

    @Test
    void should_add_into_end_of_arraylist() {
        sut.add(20, -5);

        assertEquals(-5, sut.get(20));
        assertEquals(21, sut.getSize());
    }

    @Test
    void should_remove_from_beginning_of_arraylist() {
        Integer itemRemoved = sut.remove(0);

        assertEquals(1, itemRemoved);
        assertEquals(19, sut.getSize());
        assertEquals(2, sut.get(0));
        assertEquals(20, sut.get(sut.getSize()-1));
    }

    @Test
    void should_remove_from_middle_of_arraylist() {
        Integer itemRemoved = sut.remove(11);

        assertEquals(12, itemRemoved);
        assertEquals(19, sut.getSize());
        assertEquals(1, sut.get(0));
        assertEquals(20, sut.get(sut.getSize()-1));
    }

    @Test
    void should_remove_from_middle_of_large_arraylist() {
        // Arrange
        for (int i=0; i<100000; i++) {
            sut.add(i);
        }

        Integer itemRemoved = sut.remove(50000);

        assertEquals(49980, itemRemoved);
        assertEquals(100019, sut.getSize());
        assertEquals(1, sut.get(0));
        assertEquals(99999, sut.get(sut.getSize()-1));
    }

    @Test
    void should_remove_from_end_of_arraylist() {
        Integer itemRemoved = sut.remove(19);

        assertEquals(20, itemRemoved);
        assertEquals(19, sut.getSize());
        assertEquals(1, sut.get(0));
        assertEquals(19, sut.get(sut.getSize()-1));
    }

    @Test
    void should_throw_exception_when_getting_out_of_bounds () {
        try {
            sut.get(20);
            fail("Expected an IndexOutOfBoundsException but did not get one.");
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("Expected an IndexOutOfBoundsException but did not get one.");

    }
    @Test
    void should_throw_exception_when_removing_out_of_bounds () {
        try {
            sut.remove(20);
            fail("Expected an IndexOutOfBoundsException but did not get one.");
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("Expected an IndexOutOfBoundsException but did not get one.");

    }

    @Test
    void should_throw_exception_when_adding_out_of_bounds () {
        try {
            sut.add(21, -5);
            fail("Expected an IndexOutOfBoundsException but did not get one.");
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("Expected an IndexOutOfBoundsException but did not get one.");

    }

}