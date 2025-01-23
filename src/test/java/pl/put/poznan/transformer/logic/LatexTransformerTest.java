package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LatexTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testLatexTransformer1() {
        when(mockBaseTransformer.transform("& $ #")).thenReturn("& $ #");

        TextTransformer transformer = new LatexTransformer(mockBaseTransformer);

        String result = transformer.transform("& $ #");

        verify(mockBaseTransformer).transform("& $ #");

        assertEquals("\\& \\$ \\#", result);
    }

    @Test
    void testLatexTransformer2() {
        when(mockBaseTransformer.transform("100% #1")).thenReturn("100% #1");

        TextTransformer transformer = new LatexTransformer(mockBaseTransformer);

        String result = transformer.transform("100% #1");

        verify(mockBaseTransformer).transform("100% #1");

        assertEquals("100\\% \\#1", result);
    }
}