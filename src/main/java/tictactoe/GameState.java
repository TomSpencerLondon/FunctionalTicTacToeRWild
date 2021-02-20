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

  public GameState(Status status) {
    this.status = status;
    nextUp = null;
  }

  @Override
  public String toString() {
    return nextUp == null
        ? "Status: " + status : "Status: " + status + ", next up: " + nextUp;
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
