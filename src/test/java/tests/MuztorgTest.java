package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchResultPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class MuztorgTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();


    @BeforeEach
    public void openMainPage() {
        open("https://www.muztorg.ru/");
    }


    static Stream<Arguments> checkSubcategoryTest() {
        return Stream.of(Arguments.of("Гитары", List.of("Акустические гитары", "Электрогитары", "Классические гитары", "Бас-гитары", "Акустические бас-гитары", "Гиталеле", "Усилители для гитар", "Процессоры и педали эффектов", "Тюнеры и метрономы", "Струны", "Гитарные аксессуары и комплектующие", "Чехлы и кейсы", "Custom shop")),
                Arguments.of("Клавишные инструменты", List.of("Синтезаторы", "Цифровые пианино", "Цифровые органы", "Акустические клавишные инструменты", "MIDI-клавиатуры", "MIDI контроллеры", "Оригинальные аксессуары для клавишных инструментов")));
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия подкатегорий {1} в категории {0}")
    @Tag("CRITICAL")
    void checkSubcategoryTest(String category, List<String> subcategory) {
        mainPage.findCategory(category)
                .checkSubcategory(subcategory);

    }


    @ValueSource(strings = {"YAMAHA F310", "krk rp5g4"})
    @DisplayName("Проверка результатов поиска")
    @ParameterizedTest
    void checkSearchResult(String productName) {
        mainPage.searchProduct(productName);
        searchResultPage.verifySearchResult(productName);
    }
}
