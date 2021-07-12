# Selenium JUnit 5 Framework
## Overview

An opinionated framework for writing JUnit 5 tests using selenium with Spring for managing components lifecycle.

- Uses a pool of browsers via the `DriverPool`
- Plugs in state management and creational patterns for page objects
- Uses concurrency
- Takes screenshots of failed tests

In particular, this lightweight framework ensures that each object needed to run individual test
cases is suitably created and destroyed within the lifecycle of the test.

It's worth noting that a browser instance is provided to every test inside
an annotated test class, wired into the page objects and anything else
that `@Inject`s a `WebDriver`.

Drivers are kept in a pool, passivated by having their cookies cleared and being navigated to `about:blank`.

It's worth pointing out that there's an assumption that the system under test
can be tested in parallel without any conflict. I.e. it's assumed that the state of the
system under test can be concurrently modified by each test with unique IDs for
things.

If tests were not to be parallelizable, then techniques [for isolation provided by JUnit](https://junit.org/junit5/docs/snapshot/user-guide/#writing-tests-parallel-execution-synchronization)
may help mark some tests as sequential.

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

## Browser Type and Headless

By setting the `remoteDriverUrl` in the `config.yml` to the address of a docker container running
a headless browser, the test will run headless.

The driver type can be set via `config.yml`'s `driver` property, which defaults
to `CHROME`. It can also be `FIREFOX` and others could be added via
the `DriverType` class.

To run a docker image of Chrome:

```bash
# need to map the SHM volume
docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:3.141.59
```

For switching between headless and "real" browser between CI and dev
type, consider making the remote driver url an environment variable-driven
piece of config:

```yaml
remoteDriverUrl: ${DRIVER_URL}
driver: ${DRIVER:-CHROME}
```

An example of the environment variable: 
`DRIVER_URL=http://localhost:4444/wd/hub`

## Responsibilities of Objects

- _Test state_ - any information that needs to be remembered across the test can
either be kept in fields in the test class, or can be stored in objects annotated with `@State`,
  which can be injected into all other objects via the `@Inject` annotatioin
- _Page objects_ - each page object should represent the user interface of a single page
and should be used to load the page, wait for things on it, and interact with its controls.
Page objects may also use children objects that represent reusable controls on the page
  if that helps. A page object does not know about business logic, only UI.
- _Actions_ - an action is used to execute a business process by coordinating non-trivial use of pages.
It keeps state in the test state where needed. It may be asked to perform an assertion by a test,
  but may just perform an action and return the result for assertion.
- _Assertions_ - these are almost never executed in page objects - outside of _this interaction isn't possible/didn't work_.
They're sometimes the domain of actions, and often the domain of test cases.
  
