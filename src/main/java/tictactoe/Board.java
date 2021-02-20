package tictactoe;

public class Board {
  private Square takenSquare;

  public Board(Square takenSquare) {
    this.takenSquare = takenSquare;
  }

  public Board(){
    this.takenSquare = null;
  }

  public boolean alreadyTaken(Square square) {
    return takenSquare == square;
  }

  public Board take(Square square) {
    return new Board(square);
  }
}
