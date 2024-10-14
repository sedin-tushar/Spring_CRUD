package foo.bar;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessgae {
  public String getWelcomeMessage()
  {
    return "Welcome";
  }
}
