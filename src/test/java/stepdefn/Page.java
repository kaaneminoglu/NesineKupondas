package stepdefn;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Page {

    private final String popupRootId = "android:id/button1";

    private final String btnLoginId = "com.pordiva.nesine.android:id/btn_login";

    private final String txtUserNameId = "com.pordiva.nesine.android:id/username_edit";

    private final String txtPasswordId = "com.pordiva.nesine.android:id/password_edit";

    private final String btnMembershipLoginId = "com.pordiva.nesine.android:id/login_btn";

    private final String txtMemberId = "com.pordiva.nesine.android:id/memberidValue";

    private final String btnKupondasXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[4]/android.widget.TextView";

    private final String btnAllShareXPath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Tüm Paylaşımlar\"]";

    private final String btnPlayNowXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button";

    private final String vwCouponDetailId = "com.pordiva.nesine.android:id/recycler_view_events";

    private final String vwCouponDetailXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView";

    private final String btnStatus = "com.pordiva.nesine.android:id/status_btn";

    public MobileDriver driver;

    List<String> teamListName = new ArrayList<String>();

    public Page(MobileDriver driver) {
        this.driver = driver;
    }

    public void PopupRootClick() {
        driver.findElementById(popupRootId).click();
    }

    public void LoginClick() {
        driver.findElementById(btnLoginId).click();
    }

    public void SetUserName(String text) {
        driver.findElementById(txtUserNameId).sendKeys(text);
    }

    public void SetPassword(String text) {
        driver.findElementById(txtPasswordId).sendKeys(text);
    }

    public void MembershipLoginClick() {
        driver.findElementById(btnMembershipLoginId).click();
    }

    public void CheckMemberId(String id) {
        Assert.assertEquals(driver.findElementById(txtMemberId).getText(), id);
    }

    public void KupondasClick() {
        driver.findElementByXPath(btnKupondasXPath).click();
    }

    public void AllShareClick() {
        driver.findElementByXPath(btnAllShareXPath).click();
    }

    public void PlayNowClick() {
        driver.findElementByXPath(btnPlayNowXPath).click();
    }

    public void GetCouponDetailTeamName() {
        List<MobileElement> teamList = driver.findElementsById("tv_teams");
        for (MobileElement element : teamList) {
            teamListName.add(element.getText());
        }
    }

    public void CouponDetailPlayNowClick() {
        driver.findElementById(btnStatus).click();
    }

    public void CheckBasketPage() {
        List<MobileElement> teamNames = driver.findElementsById("teamName");
        Assert.assertEquals(teamNames.size(), teamListName.size());

        for (int i = 0; i < teamNames.size(); i++) {
            Assert.assertEquals(teamNames.get(i).getText().trim(), teamListName.get(i).toString().trim());
        }
    }

    public void closeApp() {
        driver.closeApp();
    }
}
