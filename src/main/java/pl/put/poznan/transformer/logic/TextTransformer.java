package pl.put.poznan.transformer.logic;

/**
 * Interfejs definiujący kontrakt dla transformatorów tekstu.
 * Implementacje tego interfejsu przekształcają podany tekst zgodnie z określoną logiką.
 * 
 * <p>Przykładowe implementacje obejmują zmienianie wielkości liter, 
 * rozszerzanie skrótów, odwracanie tekstu itp.</p>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
public interface TextTransformer {
    
    /**
     * Przekształca podany tekst zgodnie z implementowaną logiką.
     *
     * @param text Tekst do przekształcenia.
     * @return Przekształcony tekst.
     */
    String transform(String text);
}
