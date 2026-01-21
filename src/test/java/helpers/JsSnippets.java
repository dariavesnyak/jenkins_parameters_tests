package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {

    public static void removeBannersAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
