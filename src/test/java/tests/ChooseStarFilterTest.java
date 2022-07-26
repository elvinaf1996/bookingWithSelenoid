package tests;

import org.junit.Test;
import pages.HomePage;
import pages.MapPage;
import pages.SearchPage;

import java.time.LocalDate;

public class ChooseStarFilterTest extends BaseTest {
    String nameOfCity = "Барселона";
    int countAdults = 1;
    int countChildren = 0;
    int countRooms = 1;
    int countOfNight = 6;
    int countOfStar = 5;
    LocalDate dateStart = LocalDate.now();
    LocalDate dateFinish = dateStart.plusDays(countOfNight);

    @Test
    public void chooseFiveStarFilterInSearchTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .chooseACity(nameOfCity)
                .selectDates(dateStart, dateFinish)
                .selectNumberOfPersonAndRooms(countAdults, countChildren, countRooms)
                .search();
        SearchPage searchPage = new SearchPage();
        searchPage.chooseCountOfStars(countOfStar)
                .checkNumberOfStars(countOfStar);
    }
    @Test
    public void chooseFiveStarFilterInMapTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .chooseACity(nameOfCity)
                .selectDates(dateStart, dateFinish)
                .selectNumberOfPersonAndRooms(countAdults, countChildren, countRooms)
                .search();
        SearchPage searchPage = new SearchPage();
        searchPage.chooseCountOfStars(countOfStar)
                .selectMap();
        MapPage mapPage = new MapPage();
        mapPage.chooseCountOfStars(countOfStar);
    }
}
