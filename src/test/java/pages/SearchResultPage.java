package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    public SearchResultPage verifySearchResult(String result) {
        $x("//span[@class='category-head__search' and contains(text(),'" + result + "')] ").should(Condition.visible).shouldHave(Condition.text(result));
        return this;
    }

    public SearchResultPage clickOnSearchProduct(String product){
        $$x("//div[@class='title']//a[text()='"+product+"']").get(0).should(Condition.visible)
                .shouldHave(Condition.text(product)).click();
        return this;
    }

    public SearchResultPage verifyProductPrice (String product, String price) {
        $x("//h1[@class='product-title' and contains(text(),'"+product+"')]").should(Condition.visible).shouldHave(Condition.text(product));
        $(".product-price").shouldHave(Condition.text(price));
        return this;

    }
}
