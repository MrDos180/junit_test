package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {

    public SearchResultPage verifySearchResult(String result) {
        $x("//span[@class='category-head__search' and contains(text(),'" + result + "')] ").should(Condition.visible).shouldHave(Condition.text(result));
        return this;
    }
}
