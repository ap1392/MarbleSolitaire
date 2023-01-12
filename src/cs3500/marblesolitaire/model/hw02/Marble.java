package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a Marble in the Marble solitaire game.
 * Each marble has a field representing the row it's on, the column it's on, and it's slot state.
 */
public class Marble {
  /**
   * No public types.
   */
  private int row;
  private int col;
  private MarbleSolitaireModelState.SlotState slotState;

  public Marble(int row, int col) {
    this.row = row;
    this.col = col;
  }

  // Returns the row of the marble
  public int getMarbleRow() {
    return this.row;
  }

  // Returns the column of the marble
  public int getMarbleCol() {
    return this.col;
  }

  // Sets the state of the marble
  public void setMarbleState(MarbleSolitaireModelState.SlotState state) {
    this.slotState = state;
  }

  // Returns the state of the marble
  public MarbleSolitaireModelState.SlotState getMarbleState() {
    return this.slotState;
  }
}
