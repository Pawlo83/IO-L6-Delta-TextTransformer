package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpperTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testUpperTransformer1() {
        when(mockBaseTransformer.transform("lower to UPPER")).thenReturn("lower to UPPER");

        TextTransformer transformer = new UpperTransformer(mockBaseTransformer);

        String result = transformer.transform("lower to UPPER");

        verify(mockBaseTransformer).transform("lower to UPPER");

        assertEquals("LOWER TO UPPER", result);
    }

    @Test
    void testUpperTransformer2() {
        when(mockBaseTransformer.transform("test 123 tEsT")).thenReturn("test 123 tEsT");

        TextTransformer transformer = new UpperTransformer(mockBaseTransformer);

        String result = transformer.transform("test 123 tEsT");

        verify(mockBaseTransformer).transform("test 123 tEsT");

        assertEquals("TEST 123 TEST", result);
    }
}