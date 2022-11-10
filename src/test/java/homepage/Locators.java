package homepage;

import org.openqa.selenium.By;

public interface Locators {
    String url = "https://wow-ai.com/";
    By location = By.xpath("(//a[@class=\"topbar__address\"])[1]");
    By contactMail = By.xpath("(//a[@class=\"topbar__address\"])[2]");
    By flags = By.cssSelector("div.topbar__language>a");

    By logo = By.cssSelector("a.navbar__logo");
    By contactUs = By.cssSelector("a.home-banner__contact");
    By firstNameInput = By.id("first_name");
    By submitButton = By.id("form_submit");
    By message = By.cssSelector("div.page-post__content");

    //second section
    By scrollDown = By.cssSelector("div.home-banner__scroll-down");
    By videoLink = By.cssSelector("div.home-about__youtube");
    By video=By.cssSelector("div.home-about__youtube");

    //third section
    By thirdSection = By.xpath("//h2[text()=\"Services\"]");
    By iframeSection=By.id("LeadboosterContainer");
    By chatButton=By.xpath("//button[@data-test-id=\"chat-bubble\"]");

    By selections=By.cssSelector("div.sc-ehmTmK>button");
    By footerContainer=By.cssSelector("footer.container");
    By socialItems = By.cssSelector("div.footer__social>a");
    By event=By.linkText("Event");
    By applyForm=By.cssSelector("div.why");

    By applyNameInput=By.cssSelector("div>input");
    By registered=By.xpath("//*[text()=\"Registration submitted\"]");

}
