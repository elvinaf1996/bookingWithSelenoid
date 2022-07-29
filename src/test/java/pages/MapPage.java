package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MapPage {
    private final By FILTERS_IN_THE_MAP = By.cssSelector(".map_left_filters");
    private final By CHECK_BOXES = By.cssSelector(".bbdb949247");
    public final By LOADING_MAP_MESSAGE = By.cssSelector(".map_left_cards__loading-message");
    public final By STARS = By.cssSelector(".bui-rating--smaller");
    public final By STAR = By.cssSelector("span");
    public final By LEFT_FILTERS = By.cssSelector(".map_left_filters");

    private MapPage chooseLeftFiltersVisible(){
        $(LEFT_FILTERS).shouldBe(visible);
        return this;
    }

    public MapPage chooseCountOfStars(int countOfStars){
        chooseLeftFiltersVisible();
        $(FILTERS_IN_THE_MAP).$(String.format("[data-filters-item=\"class:class=%s\"]", Integer.toString(countOfStars)))
                .$(CHECK_BOXES).scrollTo().click();
        loadingMapMessage();
        return this;
    }
    private MapPage loadingMapMessage(){
        $(LOADING_MAP_MESSAGE).shouldBe(visible, Duration.ofSeconds(20)).shouldBe(Condition.not(visible), Duration.ofSeconds(20));
        return this;
    }
    public MapPage checkNumberOfStars(int countStar){
        ElementsCollection allStarsInCard = $$(STARS);

        for(SelenideElement selenideElement : allStarsInCard){
            ElementsCollection allStars = selenideElement.findAll(STAR);
            allStars.shouldHave(CollectionCondition.size(countStar));
        }
        return this;
    }
}
