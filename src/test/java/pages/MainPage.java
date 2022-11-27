package pages;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public MainPage findCategory(String category) {
        $x("//div[@class='catalog-menu__i ']//a[contains(text(),'" + category + "')]").click();
        return this;
    }

    public MainPage checkSubcategory(List<String> subcategory) {
        $$x("//div[@class='category__name']")
                .shouldHave(CollectionCondition.texts(subcategory));
        return this;
    }

    public MainPage searchProduct(String productName) {
        $("#search-product-input").setValue(productName).pressEnter();
        return this;
    }


}
