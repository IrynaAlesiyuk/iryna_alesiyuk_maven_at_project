package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.google.HomePageGoogle;
import pages.w3schools.HomePageW3School;

public class GeneralTest extends BaseTest {

    @Test
    public void copyTestFindInGoogle() {
        HomePageW3School w3schoolHomePage = new HomePageW3School();
        w3schoolHomePage.navigateToW3School();
        w3schoolHomePage.acceptAll();
        w3schoolHomePage.copyTutorialText();

        HomePageGoogle homePageGoogle = new HomePageGoogle();
        homePageGoogle.navigateToGooglePage();
        homePageGoogle.acceptAll();
        homePageGoogle.pastedCopiedTextIntoSearchField();

        Assert.assertTrue(homePageGoogle.checkIfTutorialIsFound());
    }
}
