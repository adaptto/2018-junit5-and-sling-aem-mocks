package to.adapt.junit5demo.components;

/**
 * Example exception.
 */
public class MailserverNotConfiguredException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * @param message Message
   */
  public MailserverNotConfiguredException(String message) {
    super(message);
  }

}
