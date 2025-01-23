package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeduplicateTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testDeduplicateTransformer1() {
        when(mockBaseTransformer.transform("duplicate duplicate")).thenReturn("duplicate duplicate");

        TextTransformer transformer = new DeduplicateTransformer(mockBaseTransformer);

        String result = transformer.transform("duplicate duplicate");

        verify(mockBaseTransformer).transform("duplicate duplicate");

        assertEquals("duplicate", result);
    }

    @Test
    void testDeduplicateTransformer2() {
        when(mockBaseTransformer.transform("a a a b b a b a b")).thenReturn("a a a b b a b a b");

        TextTransformer transformer = new DeduplicateTransformer(mockBaseTransformer);

        String result = transformer.transform("a a a b b a b a b");

        verify(mockBaseTransformer).transform("a a a b b a b a b");

        assertEquals("a b a b a b", result);
    }
}