package uk.co.yourorg.yourpackage;

import org.junit.jupiter.api.Test;
import uk.co.webcompere.seleniumjunit5.annotations.Inject;
import uk.co.yourorg.yourpackage.junit.SeleniumTest;
import uk.co.yourorg.yourpackage.page.JsonPlaceholderHome;

import static org.assertj.core.api.Assertions.assertThat;

@SeleniumTest
class JsonPlaceholderTest {

    @Inject
    private JsonPlaceholderHome homePage;

    @Test
    void canGoToHomePageAndTryScript() throws Exception {
        homePage.navigateTo();
        homePage.runScript();

        Thread.sleep(100);

        assertThat(homePage.getResultText())
                .contains("delectus aut autem");
    }

    @Test
    void canGoToHomePageAndTryScriptInParallel() throws Exception {
        homePage.navigateTo();
        homePage.runScript();

        Thread.sleep(100);

        assertThat(homePage.getResultText())
                .contains("delectus aut autem");
    }
}
