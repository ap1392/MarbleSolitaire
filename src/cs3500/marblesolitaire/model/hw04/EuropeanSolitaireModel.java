package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.Marble;

/**
 * Represents the class for European Solitaire. This class extends the English Solitaire class and
 * keeps all the methods except makeBoard and setMarble. The difference in makeBoard is the way
 * I'm mutating the listOfValidRowsAndCol, and the difference in set marble is here
 * I only want to look at the column, whereas in EnglishSolitaire I wanted to look at both
 * the column and row.
 */
public class EuropeanSolitaireModel extends EnglishSolitaireModel {

  public static int DEFAULT_EURO_SIZE = 3;

  /**
   * Initializes a game of European Solitaire.
   */
  public EuropeanSolitaireModel() {
    super();
  }

  /**
   * Initializes a game of European Solitaire where the emptyMarble is placed at a
   * desired location.
   *
   * @param emptySlotRow    row where empty marble is to be placed.
   * @param emptySlotColumn column where empty marble is to be placed.
   */
  public EuropeanSolitaireModel(int emptySlotRow, int emptySlotColumn) {
    super(emptySlotRow, emptySlotColumn);
  }

  /**
   * Initializes a game of European Solitaire with a desired side length.
   *
   * @param sideLength the desired side length
   */
  public EuropeanSolitaireModel(int sideLength) {
    super(sideLength);
  }

  /**
   * Initializes a game of European Solitaire with a desired side length and desired position
   * for the empty marble.
   *
   * @param sideLength      the desired side length
   * @param emptySlotRow    row where empty marble is to be placed.
   * @param emptySlotColumn column where empty marble is to be placed.
   */
  public EuropeanSolitaireModel(int sideLength, int emptySlotRow, int emptySlotColumn) {
    super(sideLength, emptySlotRow, emptySlotColumn);
  }

  /**
   * Creates the board which contains marbles for marble solitaire.
   *
   * @return A 2d ArrayList containing all the marbles in the game marble solitaire.
   */
  @Override
  protected ArrayList<ArrayList<Marble>> makeBoard() {
    this.listOfValidRowAndCol = this.getValidList();
    ArrayList<ArrayList<Marble>> boardArrayList = new ArrayList<>();
    for (int i = 0; i < super.numOfRows; i++) {
      ArrayList<Marble> rowArrayList = new ArrayList<Marble>();
      for (int j = 0; j < super.numOfCol; j++) {
        Marble marble = new Marble(i, j);
        this.setMarble(marble);
        rowArrayList.add(marble);
      }
      if (i < (super.armThickness - 1)) {
        int firstElement = this.listOfValidRowAndCol.get(0);
        int lastElement = this.listOfValidRowAndCol.get(super.listOfValidRowAndCol.size() - 1);
        this.listOfValidRowAndCol.add(0, firstElement - 1);
        this.listOfValidRowAndCol.add(this.listOfValidRowAndCol.size(), lastElement + 1);
      } else if (i > (super.getBoardSize() - this.armThickness - 1)) {
        this.listOfValidRowAndCol.remove(this.listOfValidRowAndCol.size() - 1);
        this.listOfValidRowAndCol.remove(0);
      }
      boardArrayList.add(rowArrayList);
    }
    return boardArrayList;
  }

  @Override
  protected void setMarble(Marble marble) {
    if (this.listOfValidRowAndCol.contains(marble.getMarbleCol())) {
      marble.setMarbleState(SlotState.Marble);
    } else {
      marble.setMarbleState(SlotState.Invalid);
    }
  }

}