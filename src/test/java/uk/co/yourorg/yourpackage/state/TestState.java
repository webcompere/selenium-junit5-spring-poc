package uk.co.yourorg.yourpackage.state;

import uk.co.webcompere.seleniumjunit5.annotations.State;

@State
public class TestState {
    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
