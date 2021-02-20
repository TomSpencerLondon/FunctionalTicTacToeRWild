package tictactoe;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class GameState {
  private final Status status;
  private final Player nextUp;

  public GameState(Status status, Player nextUp) {
    this.status = status;
    this.nextUp = nextUp;
  }

  @Override
  public boolean equals(Object other) {
    return reflectionEquals(this, other);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
}
