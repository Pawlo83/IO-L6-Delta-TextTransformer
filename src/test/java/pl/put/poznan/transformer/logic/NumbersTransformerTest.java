package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class NumbersTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testNumbersTransformer1() {
        when(mockBaseTransformer.transform("0 1 2 3")).thenReturn("0 1 2 3");

        TextTransformer transformer = new NumbersTransformer(mockBaseTransformer);

        String result = transformer.transform("0 1 2 3");

        verify(mockBaseTransformer).transform("0 1 2 3");

        assertEquals("zero jeden dwa trzy", result);
    }

    @Test
    void testNumbersTransformer2() {
        when(mockBaseTransformer.transform("1500 100 900 420")).thenReturn("1500 100 900 420");

        TextTransformer transformer = new NumbersTransformer(mockBaseTransformer);

        String result = transformer.transform("1500 100 900 420");

        verify(mockBaseTransformer).transform("1500 100 900 420");

        assertEquals("tysiąc pięćset sto dziewięćset czterysta dwadzieścia", result);
    }
}