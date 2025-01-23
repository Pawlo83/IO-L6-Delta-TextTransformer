package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShortenTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testShortenTransformer1() {
        when(mockBaseTransformer.transform("Test Na przykład między innymi to jest")).thenReturn("Test Na przykład między innymi to jest");

        TextTransformer transformer = new ShortenTransformer(mockBaseTransformer);

        String result = transformer.transform("Test Na przykład między innymi to jest");

        verify(mockBaseTransformer).transform("Test Na przykład między innymi to jest");

        assertEquals("Test Np. m.in. tj.", result);
    }

    @Test
    void testShortenTransformer2() {
        when(mockBaseTransformer.transform("Tak zwany test i tym podobne w związku z tym")).thenReturn("Tak zwany test i tym podobne w związku z tym");

        TextTransformer transformer = new ShortenTransformer(mockBaseTransformer);

        String result = transformer.transform("Tak zwany test i tym podobne w związku z tym");

        verify(mockBaseTransformer).transform("Tak zwany test i tym podobne w związku z tym");

        assertEquals("Tzw. test itp. w.z.t.", result);
    }
}