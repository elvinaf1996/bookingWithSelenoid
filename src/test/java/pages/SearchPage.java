package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    public final By CHECK_BOXES = By.cssSelector(".bbdb949247");
    public final By WAITING_PLATE = By.cssSelector("[data-testid='overlay-message-title']");
    public final By STARS = By.cssSelector("[data-testid=\"rating-stars\"]");
    public final By STAR = By.cssSelector("span");
    public final By MAP_BUTTON = By.cssSelector(".show_map.bui-button");
    public final By LOADING_MAP_MESSAGE = By.cssSelector(".map_left_cards__loading-message");

    public SearchPage chooseCountOfStars(int countStar){
        $(String.format("[data-filters-item=\"class:class=%s\"]", Integer.toString(countStar)))
                .$(CHECK_BOXES).click();
        checkDownloadHasPassed();
        return this;
    }

    public SearchPage checkNumberOfStars(int countStar){
        ElementsCollection allStarsInCard = $$(STARS);

        for(SelenideElement selenideElement : allStarsInCard){
            ElementsCollection allStars = selenideElement.findAll(STAR);
            allStars.shouldHave(CollectionCondition.size(countStar));
        }
        return this;
    }

    private SearchPage checkDownloadHasPassed(){
        $(WAITING_PLATE).shouldBe(visible).shouldNotBe(visible);
        return this;
    }

    public SearchPage selectMap(){
        $(MAP_BUTTON).click();
        loadingMapMessage();
        return this;
    }

    private SearchPage loadingMapMessage(){
        $(LOADING_MAP_MESSAGE).shouldBe(visible).shouldNotBe(visible);
        return this;
    }
}