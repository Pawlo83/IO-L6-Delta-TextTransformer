package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LowerTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testLowerTransformer1() {
        when(mockBaseTransformer.transform("UPPER TO LoWeR")).thenReturn("UPPER TO LoWeR");

        TextTransformer transformer = new LowerTransformer(mockBaseTransformer);

        String result = transformer.transform("UPPER TO LoWeR");

        verify(mockBaseTransformer).transform("UPPER TO LoWeR");

        assertEquals("upper to lower", result);
    }

    @Test
    void testLowerTransformer2() {
        when(mockBaseTransformer.transform("SHORT TEST 123")).thenReturn("SHORT TEST 123");

        TextTransformer transformer = new LowerTransformer(mockBaseTransformer);

        String result = transformer.transform("SHORT TEST 123");

        verify(mockBaseTransformer).transform("SHORT TEST 123");

        assertEquals("short test 123", result);
    }
}