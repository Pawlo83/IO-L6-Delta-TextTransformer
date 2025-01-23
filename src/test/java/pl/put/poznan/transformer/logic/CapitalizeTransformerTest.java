package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CapitalizeTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testCapitalizeTransformer1() {
        when(mockBaseTransformer.transform("test")).thenReturn("test");

        TextTransformer transformer = new CapitalizeTransformer(mockBaseTransformer);

        String result = transformer.transform("test");

        verify(mockBaseTransformer).transform("test");

        assertEquals("Test", result);
    }

    @Test
    void testCapitalizeTransformer2() {
        when(mockBaseTransformer.transform("capitalize Test number two")).thenReturn("capitalize Test number two");

        TextTransformer transformer = new CapitalizeTransformer(mockBaseTransformer);

        String result = transformer.transform("capitalize Test number two");

        verify(mockBaseTransformer).transform("capitalize Test number two");

        assertEquals("Capitalize Test Number Two", result);
    }
}