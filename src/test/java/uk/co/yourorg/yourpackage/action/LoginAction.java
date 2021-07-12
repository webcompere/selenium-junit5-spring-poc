package uk.co.yourorg.yourpackage.action;

import uk.co.webcompere.seleniumjunit5.annotations.Action;
import uk.co.webcompere.seleniumjunit5.annotations.Inject;
import uk.co.yourorg.yourpackage.page.ExamplePageObject;
import uk.co.yourorg.yourpackage.page.OtherPageObject;
import uk.co.yourorg.yourpackage.state.TestState;

import java.util.UUID;

@Action
public class LoginAction {
    private String id = UUID.randomUUID().toString();

    @Inject
    private ExamplePageObject examplePageObject;

    @Inject
    private OtherPageObject otherPageObject;

    @Inject
    private TestState state;

    public void doAction() {
        state.setLoggedIn(true);
    }
}
