package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaire;

/**
 * Represents the functionality of the English Solitaire Model. This class extends the
 * Abstract Solitaire class and implements the make board method in it.
 */
public class EnglishSolitaireModel extends AbstractSolitaire {

  public static int DEFAULT_SIZE = 3;

  /**
   * Initializes a game of English Solitaire with a hole in the middle and an arm thickness of 3.
   */
  public EnglishSolitaireModel() {
    this.armThickness = 3;
    this.numOfRows = this.getRowAndColSizeFromThickness(3);
    this.numOfCol = this.getRowAndColSizeFromThickness(3);
    this.board = this.makeBoard();
    this.emptyMarbleRow = this.numOfRows / 2;
    this.emptyMarbleCol = this.numOfCol / 2;
    this.find(this.emptyMarbleRow, this.emptyMarbleCol).setMarbleState(SlotState.Empty);
  }


  /**
   * Initializes a game of English Solitaire with a hole at the specified spot
   * and an arm thickness of 3.
   *
   * @param emptySlotRow    the row where the empty marble is to be placed.
   * @param emptySlotColumn the column where the empty marble is to be placed.
   * @throws IllegalArgumentException if inputted cell position is invalid or off the board
   */
  public EnglishSolitaireModel(int emptySlotRow, int emptySlotColumn)
          throws IllegalArgumentException {
    this.armThickness = 3;
    this.numOfRows = this.getRowAndColSizeFromThickness(3);
    this.numOfCol = this.getRowAndColSizeFromThickness(3);
    this.board = this.makeBoard();
    this.emptyMarbleRow = emptySlotRow;
    this.emptyMarbleCol = emptySlotColumn;
    if (this.find(emptySlotRow, emptySlotColumn).getMarbleState() == SlotState.Invalid) {
      throw new IllegalArgumentException(
              "Invalid empty cell position (" + emptySlotRow + "," + emptySlotColumn + ")");
    }
    this.find(emptySlotRow, emptySlotColumn).setMarbleState(SlotState.Empty);
  }

  /**
   * Initializes a game of English Solitaire with a hole in the middle and an
   * arm thickness of a desired length.
   *
   * @param armThickness the desired arm thickness of the board
   * @throws IllegalArgumentException if arm thickness is negative or even
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness < 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness needs to be and odd non-negative integer");
    }
    this.armThickness = armThickness;
    this.numOfRows = this.getRowAndColSizeFromThickness(armThickness);
    this.numOfCol = this.getRowAndColSizeFromThickness(armThickness);
    this.board = this.makeBoard();
    this.emptyMarbleRow = this.numOfRows / 2;
    this.emptyMarbleCol = this.numOfCol / 2;
    if (this.find(this.emptyMarbleRow, this.emptyMarbleCol).getMarbleState()
            == SlotState.Invalid) {
      throw new IllegalArgumentException(
              "Invalid empty cell position (" + this.emptyMarbleRow + "," +
                      this.emptyMarbleCol + ")");
    }
    this.find(this.emptyMarbleRow, this.emptyMarbleCol).setMarbleState(SlotState.Empty);

  }

  /**
   * Initializes a game of English Solitaire with a hole at the specified spot
   * arm thickness of a desired length.
   *
   * @param armThickness    the desired arm thickness of the board
   * @param emptySlotRow    the row where the empty marble is to be placed
   * @param emptySlotColumn the col where the empty marble is to be placed
   * @throws IllegalArgumentException if arm thickness is negative or even or if
   *                                  the specified empty spot is invalid or off the board
   */
  public EnglishSolitaireModel(int armThickness, int emptySlotRow, int emptySlotColumn)
          throws IllegalArgumentException {
    if (armThickness < 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness needs to be and odd non-negative integer");
    }
    this.armThickness = armThickness;
    this.numOfRows = this.getRowAndColSizeFromThickness(armThickness);
    this.numOfCol = this.getRowAndColSizeFromThickness(armThickness);
    this.board = this.makeBoard();
    this.emptyMarbleRow = emptySlotRow;
    this.emptyMarbleCol = emptySlotColumn;
    if (this.find(emptySlotRow, emptySlotColumn).getMarbleState() == SlotState.Invalid) {
      throw new IllegalArgumentException(
              "Invalid empty cell position (" + emptySlotRow + "," + emptySlotColumn + ")");
    }
    this.find(emptySlotRow, emptySlotColumn).setMarbleState(SlotState.Empty);

  }

  @Override
  protected ArrayList<ArrayList<Marble>> makeBoard() {
    this.listOfValidRowAndCol = this.getValidList();

    ArrayList<ArrayList<Marble>> boardArrayList = new ArrayList<>();
    for (int i = 0; i < super.numOfRows; i++) {
      ArrayList<Marble> rowArrayList = new ArrayList<Marble>();
      for (int j = 0; j < super.numOfCol; j++) {
        Marble marble = new Marble(i, j);
        super.setMarble(marble);
        rowArrayList.add(marble);
      }
      boardArrayList.add(rowArrayList);
    }
    return boardArrayList;
  }

}