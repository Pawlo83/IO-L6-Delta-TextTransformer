package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PunctuationTransformerTest {
    private TextTransformer mockBaseTransformer;

    @BeforeEach
    void setUp() {
        mockBaseTransformer = Mockito.mock(TextTransformer.class);
    }

    @Test
    void testPunctuationTransformer1() {
        when(mockBaseTransformer.transform("short ( punctuation) test !")).thenReturn("short ( punctuation) test !");

        TextTransformer transformer = new PunctuationTransformer(mockBaseTransformer);

        String result = transformer.transform("short ( punctuation) test !");

        verify(mockBaseTransformer).transform("short ( punctuation) test !");

        assertEquals("short (punctuation) test!", result);
    }

    @Test
    void testPunctuationTransformer2() {
        when(mockBaseTransformer.transform("' ( cats ) ' , dogs .humans ? ")).thenReturn("' ( cats ) ' , dogs .humans ? ");

        TextTransformer transformer = new PunctuationTransformer(mockBaseTransformer);

        String result = transformer.transform("' ( cats ) ' , dogs .humans ? ");

        verify(mockBaseTransformer).transform("' ( cats ) ' , dogs .humans ? ");

        assertEquals("'(cats)', dogs. humans?", result);
    }
}