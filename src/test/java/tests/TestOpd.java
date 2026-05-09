package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class TestOpd extends BaseTest {

    LoginPage login;
    NavigationPage nav;
    RegistrationPage reg;
    BillingPage bill;
    ReceiptPage receipt;

    @BeforeClass
    public void setupTest() {
        login = new LoginPage(driver, wait);
        nav = new NavigationPage(driver, wait);
        reg = new RegistrationPage(driver, wait, actions);
        bill = new BillingPage(driver, wait, actions);
        receipt = new ReceiptPage(driver, wait, actions);
    }

    @Test
    public void opdBillingFlow() {
        login.login("admin", "test");
        nav.goToOPD();
        reg.registerNewPatient();
        bill.addService();
        bill.addMultipleServices();
        receipt.makeReceiptAndLock();
    }
}
