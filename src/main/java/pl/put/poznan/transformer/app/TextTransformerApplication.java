package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Główna klasa aplikacji Text Transformer.
 * 
 * <p>
 * Klasa ta uruchamia aplikację Spring Boot, która zapewnia interfejs REST 
 * do transformacji tekstu za pomocą różnych transformatorów.
 * </p>
 * 
 * <p>
 * Aplikacja jest skonfigurowana do skanowania pakietów <code>pl.put.poznan.transformer.rest</code> 
 * w poszukiwaniu komponentów Spring, takich jak kontrolery REST.
 * </p>
 * 
 *<p>Przykładowe endpointy API:</p>
 *
 * <ul>
 *     <li><code>/transform</code> - Punkt końcowy do przekształcania tekstu za pomocą zdefiniowanych transformatorów.</li>
 *     <li><code>/health</code> - Punkt końcowy do sprawdzania stanu aplikacji.</li>
 * </ul>

 * 
 * <p>
 * Aby uruchomić aplikację, użyj metody <code>main</code>, która inicjalizuje i uruchamia 
 * kontekst Spring Boot.
 * </p>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    /**
     * Główna metoda uruchamiająca aplikację Spring Boot.
     *
     * <p>
     * Metoda ta uruchamia kontekst aplikacji Spring Boot, który zarządza 
     * wszystkimi komponentami aplikacji, w tym kontrolerami REST, serwisami 
     * oraz innymi beanami.
     * </p>
     * 
     * @param args Argumenty linii poleceń. Można je użyć do przekazania 
     *             dodatkowych konfiguracji lub ustawień aplikacji.
     */
    public static void main(String[] args) {
        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
