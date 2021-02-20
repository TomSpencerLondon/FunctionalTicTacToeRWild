package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameShould {
  private Game game;

  @BeforeEach
  void setUp() {
    game = new Game();
  }

  @Test
  void wait_for_x_to_play_first() {
    assertThat(game.state()).isEqualTo(new GameState(Status.GAME_ON, Player.X));
  }
}
