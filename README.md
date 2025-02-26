# IO-L6-Delta-TextTransformer
Aplikacja ma za zadanie spełniać następujący scenariusz:

Dla osób pracujących z danymi tekstowymi nasza aplikacja Text Transformer umożliwi transformacje danych tekstowych (np. zmiana wielkości liter, eliminacja duplikatów, itd.). Aplikacja będzie dostępna poprzez GUI a także zdalne API dzięki czemu będzie można ją zintegrować z istniejącymi narzędziami.

## Planowana funkcjonalność:
- Jako twórca aplikacji mogę wywołać transformację zdalnie poprzez REST, aby móc  zintegrować narzędzie z moimi innymi aplikacjami
- Jako użytkownik mogę zmianać wielkości liter – zestaw trzech transformacji (upper, lower, capitalize)
- Jako użytkownik mogę odwracać ciąg znaków z zachowaniem wielkości liter na konkretnych pozycjach (inverse)
- Jako użytkownik mogę o zamieniać wybrane (predefiniowane) słowa na skróty (Pieczywo to na przykład chleb i bułki -> Pieczywo to np. chleb i bułki) – zakres obsługiwanych skrótów do negocjacji
- Jako użytkownik mogę rozwijać wybrane skróty do pełnych postaci (Pan Prof. spóźnił się na zajęcia -> Pan Profesor spóźnił się na zajęcia)
- Jako użytkownik mogę eliminować powtarzające się wyrazy w bezpośrednim sąsiedztwie (Wyślij do do mnie wiadomość -> Wyślij do mnie wiadomość)

## Końcowy diagram UML
![image](https://github.com/user-attachments/assets/466332c8-3582-4d69-8061-4a6be15ad089)

## Wymagania
- Java 11 lub nowsza.
- ...

## Autorzy:
- Paweł Skiba - [GitHub](https://github.com/Pawlo83)
- Maciej Szymaniak - [GitHub](https://github.com/masz00)
- Szymon Tadych - [GitHub](https://github.com/szymont20)
- Kacper Zatoń - [GitHub](https://github.com/KacperZaton)
