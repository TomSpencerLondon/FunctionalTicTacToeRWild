package tictactoe;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Board {
  private Set<Square> takenSquares;

  public Board(){
    this.takenSquares = Collections.emptySet();
  }

  private Board(Set<Square> takenSquares) {
    this.takenSquares = takenSquares;
  }

  public boolean alreadyTaken(Square square) {
    return takenSquares.contains(square);
  }

  public Board take(Square square) {
    Set<Square> newBoard = new HashSet<>(takenSquares);
    newBoard.add(square);
    return new Board(newBoard);
  }
}
