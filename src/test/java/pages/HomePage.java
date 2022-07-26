package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By GO_TO_CITY = By.cssSelector("#ss");
    private final By DATES = By.cssSelector(".sb-date-field__icon");
    private final By DATE = By.cssSelector(".bui-calendar__date");
    private final By COUNT_PEOPLE_AND_ROOM = By.cssSelector(".xp__guests__count");
    private final By MINUS_ADULT = By.cssSelector("[aria-label=\"Взрослых: уменьшить количество\"]");
    private final By PlUS_ADULT = By.cssSelector("[aria-label=\"Взрослых: увеличить количество\"]");
    private final By PLUS_CHILD = By.cssSelector("[aria-label=\"Детей: увеличить количество\"]");
    private final By PLUS_ROOM = By.cssSelector("[aria-label=\"Номера: увеличить количество\"]");
    private final By CHECK_PRICE = By.cssSelector(".sb-searchbox__button");
    private final By COOKIE = By.cssSelector("button#onetrust-accept-btn-handler");


    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public HomePage chooseACity(String nameCity) {
        $(GO_TO_CITY).shouldBe(Condition.visible, Duration.ofSeconds(20)).sendKeys(nameCity);
        $(COOKIE).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }

    public HomePage selectDates(LocalDate date1,LocalDate date2){
        $$(DATES).first().click();
        $$(DATE).find(Condition.attribute("data-date", date1.toString())).click();
        $$(DATE).find(Condition.attribute("data-date", date2.toString())).click();
        return this;
    }

    public HomePage selectNumberOfPersonAndRooms(int countAdults, int countChildren, int countRooms){
        $(COUNT_PEOPLE_AND_ROOM).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        if(countAdults < 2 && countAdults > 0){
            $(MINUS_ADULT).click();
        }
        else if(countAdults > 2){
            for(int i = 0; i < countAdults - 2; i++){
                $(PlUS_ADULT).click();
            }
        }
        for(int i = 0; i < countChildren; i++){
            $(PLUS_CHILD).click();
        }
        for(int i = 1; i < countRooms; i++){
            $(PLUS_ROOM).click();
        }
        return this;
    }

    public HomePage search(){
        $(CHECK_PRICE).click();
        return this;
    }
}