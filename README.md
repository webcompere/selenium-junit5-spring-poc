# Selenium JUnit 5 Framework
## Overview

An opinionated framework for writing JUnit 5 tests using selenium.

- Uses a pool of browsers via the `DriverPool`
- Plugs in state management and creational patterns for page objects
- Uses concurrency
- Takes screenshots of failed tests

## Entry Point

- Create a package called `junit` in your package space

  - Add `Config` to it with the package scan of your namespace:

    ```java
    @Configuration
    @ComponentScan(basePackages = "uk.co.yourorg.yourpackage")
    public class Config {
    }
    ```

  - Add this `SeleniumTest` annotation, referencing your `Config`:

    ```java
    @Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @uk.co.webcompere.seleniumjunit5.annotations.SeleniumTest
    @ContextConfiguration(classes = Config.class)
    public @interface SeleniumTest {
    }
    ```

- Each of your tests needs to be annotated with **your** `SeleniumTest` annotation.

- Create page objects a a subclass of `PageObjectBase`, annotated with `@PageObject`

  ```java
  @PageObject
  public class ExamplePageObject extends PageObjectBase {
  }
  ```

  - Containing any of the Selenium page object annotations as required

- Inject page objects, actions(annotated with `@Action`) and state (annotated with `@State`) into the test class and each other using `@Inject` on the field or `@Inject` on other spring-component scanning objects.

  ```java
  @SeleniumTest
  class SomeTest {
  
  	@Inject
  	private ExamplePageObject examplePage;
  
    @Inject
    private LoginAction loginAction;
    
    @Inject
    private SomeTestState testState;
  }
  
  @Action
  public class LoginAction { 
  
    @Inject
    private LoginPage loginPage;
    
    @Inject
    private SomeTestState testState
  }
  
  @State
  public class SomeTestState {
    private boolean isLoggedIn;
  }
  ```

- Provide `config.yml` to configure the choice of WebDriver/pool sizes etc

Write tests, be happy...

## Configuration

The `config.yml` should be put in the resource path. It must not be blank, and can contain:

```yaml
# maximum number of browsers
poolMax: 10

# max time to keep a driver/browser before release (ms)
poolMaxIdleTime: 2000
```

These can also be configured with environment variable placeholders and defaults as per [lightweight-configuration](https://github.com/webcompere/lightweight-config).

There's a default configuration for `junit-platform.properties`. This might be overridden by putting a new copy of the file in `src/test/resources`.



