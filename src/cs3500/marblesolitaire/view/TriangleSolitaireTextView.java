package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the View for Triangle Solitaire. This view takes a right triangle and shifts
 * it so that it appears as an equilateral triangle in whatever output is specified. If no outputs
 * are specified, the out defaults to System.out. However, the user can enter whatever output
 * they would like to use (for example they could use a StringBuffer/StringBuilder).
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState triangleSolitaire;
  private Appendable out;

  /**
   * A constructor that takes in a Triangle Solitaire Model and outputs it to the console.
   *
   * @param triangleSolitaire a model which contains the functionality for triangle solitaire
   * @throws IllegalArgumentException if the inputted Triangle Solitaire is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState triangleSolitaire)
          throws IllegalArgumentException {
    if (triangleSolitaire == null) {
      throw new IllegalArgumentException();
    }
    this.triangleSolitaire = triangleSolitaire;
    this.out = System.out;
  }

  /**
   * A constructor that takes in a Triangle Solitaire Model and outputs it to the console.
   *
   * @param triangleSolitaire a model which contains the functionality for triangle solitaire
   * @param out               a specified Appendable where the view outputs to.
   * @throws IllegalArgumentException if the inputted Triangle Solitaire is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState triangleSolitaire, Appendable out) {
    if (triangleSolitaire == null || out == null) {
      throw new IllegalArgumentException();
    }
    this.triangleSolitaire = triangleSolitaire;
    this.out = out;
  }

  @Override
  public String toString() {
    String stringToReturn = "";
    String formattedString = " ";
    formattedString = formattedString.repeat(this.triangleSolitaire.getBoardSize() - 1);
    stringToReturn += formattedString;

    for (int i = 0; i < this.triangleSolitaire.getBoardSize(); i++) {
      for (int j = 0; j < this.triangleSolitaire.getBoardSize(); j++) {
        MarbleSolitaireModelState.SlotState marbleState = this.triangleSolitaire.getSlotAt(i, j);
        if (j > 0 && marbleState == MarbleSolitaireModelState.SlotState.Invalid) {
          break;
        }
        if (j == this.triangleSolitaire.getBoardSize() && marbleState ==
                MarbleSolitaireModelState.SlotState.Marble) {
          stringToReturn = stringToReturn + "O";
          break;
        }
        if (marbleState == MarbleSolitaireModelState.SlotState.Marble) {
          stringToReturn = stringToReturn + "O ";
        } else if (marbleState == MarbleSolitaireModelState.SlotState.Empty) {
          stringToReturn = stringToReturn + "_ ";
        } else if (marbleState == MarbleSolitaireModelState.SlotState.Invalid) {
          stringToReturn = stringToReturn + "  ";
        }
      }
      stringToReturn = stringToReturn.substring(0, stringToReturn.length() - 1);
      if (i != this.triangleSolitaire.getBoardSize() - 1) {
        stringToReturn = stringToReturn + "\n";
      }
      if (formattedString.length() != 0) {
        formattedString = formattedString.substring(0, formattedString.length() - 1);
        stringToReturn += formattedString;
      }
    }
    return stringToReturn;
  }

  @Override
  public void renderBoard() throws IOException {
    String fullBoard = this.toString();
    this.out.append(fullBoard);
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.out.append(message);
  }

}
