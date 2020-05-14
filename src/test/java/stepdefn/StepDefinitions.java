package stepdefn;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class StepDefinitions extends ServiceHooks {

    public static Page page;

    @After
    public void closeApp() {
        page.closeApp();
    }

    @Given("User launch application")
    public void userLaunchApplication() throws MalformedURLException, InterruptedException {
        setup();

        page = new Page(ServiceHooks.driver);
    }

    @And("User click popup root button")
    public void userClickPopupRootButton() {
        page.PopupRootClick();
    }

    @When("User click login button")
    public void userClickLoginButton() {
        page.LoginClick();
    }

    @And("Username with {string}")
    public void userWith(String arg0) {
        page.SetUserName(arg0);
    }

    @And("Password with {string}")
    public void passwordWith(String arg0) {
        page.SetPassword(arg0);
    }

    @And("User click membership login button")
    public void userClickMembershipLoginButton() {
        page.MembershipLoginClick();
    }

    @And("User see {string} message")
    public void userSeeMessage(String arg0) {
        page.CheckMemberId(arg0);
    }

    @And("User click kupondas button")
    public void userClickKupondasButton() {
        page.KupondasClick();
    }

    @And("User click all shares button")
    public void userClickAllSharesButton() {
        page.AllShareClick();
    }

    @And("User click play now button")
    public void userClickPlayNowButton() {
        page.PlayNowClick();
    }

    @Then("Get coupon detail team name")
    public void getCouponDetailTeamName() {
        page.GetCouponDetailTeamName();
    }

    @And("User click detail play now button")
    public void userClickDetailPlayNowButton() {
        page.CouponDetailPlayNowClick();
    }

    @And("Check basket page")
    public void checkBasketPage() {
        page.CheckBasketPage();
    }
}
