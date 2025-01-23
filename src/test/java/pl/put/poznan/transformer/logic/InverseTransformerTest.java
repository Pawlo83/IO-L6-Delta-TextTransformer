package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class InverseTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testInverseTransformer1() {
        when(mockBaseTransformer.transform("test")).thenReturn("test");

        TextTransformer transformer = new InverseTransformer(mockBaseTransformer);

        String result = transformer.transform("test");

        verify(mockBaseTransformer).transform("test");

        assertEquals("tset", result);
    }

    @Test
    void testInverseTransformer2() {
        when(mockBaseTransformer.transform("wEiRd teST")).thenReturn("wEiRd teST");

        TextTransformer transformer = new InverseTransformer(mockBaseTransformer);

        String result = transformer.transform("wEiRd teST");

        verify(mockBaseTransformer).transform("wEiRd teST");

        assertEquals("tSeT driEW", result);
    }
}