package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ExpandTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testExpandTransformer1() {
        when(mockBaseTransformer.transform("dr Kowalski")).thenReturn("dr Kowalski");

        TextTransformer transformer = new ExpandTransformer(mockBaseTransformer);

        String result = transformer.transform("dr Kowalski");

        verify(mockBaseTransformer).transform("dr Kowalski");

        assertEquals("doktor Kowalski", result);
    }

    @Test
    void testExpandTransformer2() {
        when(mockBaseTransformer.transform("Itp. itd. m.in.")).thenReturn("Itp. itd. m.in.");

        TextTransformer transformer = new ExpandTransformer(mockBaseTransformer);

        String result = transformer.transform("Itp. itd. m.in.");

        verify(mockBaseTransformer).transform("Itp. itd. m.in.");

        assertEquals("I tym podobne i tak dalej między innymi", result);
    }
}