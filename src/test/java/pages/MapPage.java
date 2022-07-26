package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MapPage {
    private final By FILTERS_IN_THE_MAP = By.cssSelector(".map_left_filters");
    private final By CHECK_BOXES = By.cssSelector(".bbdb949247");
    public final By LOADING_MAP_MESSAGE = By.cssSelector(".map_left_cards__loading-message");

    public MapPage chooseCountOfStars(int countOfStars){
        $(FILTERS_IN_THE_MAP).$(String.format("[data-filters-item=\"class:class=%s\"]", Integer.toString(countOfStars)))
                .$(CHECK_BOXES).click();
        loadingMapMessage();
        return this;
    }
    private MapPage loadingMapMessage(){
        $(LOADING_MAP_MESSAGE).shouldBe(visible).shouldNotBe(visible);
        return this;
    }
}
