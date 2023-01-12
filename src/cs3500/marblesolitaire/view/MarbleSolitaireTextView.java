package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the MarbleSolitaireTextView class.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState englishSolitaire;
  private Appendable out;

  /**
   * Constructor for this class that takes in a MarbleSolitaireModel and initializes it.
   *
   * @param solitaireModel a MarbleSolitaireModel
   * @throws IllegalArgumentException if Model is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState solitaireModel)
          throws IllegalArgumentException {
    if (solitaireModel == null) {
      throw new IllegalArgumentException("Invalid inputs");
    }
    this.englishSolitaire = solitaireModel;
    this.out = System.out;
  }

  /**
   * Constructor for this class that takes in a MarbleSolitaireModel
   * and Appendable and initializes them.
   *
   * @param solitaireModel a MarbleSolitaireModel
   * @param out            an Appendable
   * @throws IllegalArgumentException if Model or Out are null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState solitaireModel, Appendable out)
          throws IllegalArgumentException {
    if (solitaireModel == null || out == null) {
      throw new IllegalArgumentException("Invalid inputs");
    }
    this.englishSolitaire = solitaireModel;
    this.out = out;
  }

  @Override
  public String toString() {
    String stringToReturn = "";
    int armThickness = (englishSolitaire.getBoardSize() + 2) / 3;
    for (int i = 0; i < englishSolitaire.getBoardSize(); i++) {
      for (int j = 0; j < englishSolitaire.getBoardSize(); j++) {
        MarbleSolitaireModelState.SlotState marbleState = englishSolitaire.getSlotAt(i, j);
        if (j > armThickness && marbleState == MarbleSolitaireModelState.SlotState.Invalid) {
          break;
        }
        if (j == englishSolitaire.getBoardSize() && marbleState ==
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
      if (i != englishSolitaire.getBoardSize() - 1) {
        stringToReturn = stringToReturn + "\n";
      }
    }
    return stringToReturn;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above.
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
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
