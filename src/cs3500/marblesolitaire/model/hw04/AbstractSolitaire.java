package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.Marble;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Contains the common methods in the English, European, and Triangle solitaire classes.
 */
public abstract class AbstractSolitaire implements MarbleSolitaireModel {
  protected ArrayList<ArrayList<Marble>> board;
  protected int numOfRows;
  protected int numOfCol;

  protected int armThickness;
  protected int emptyMarbleRow;
  protected int emptyMarbleCol;
  protected ArrayList<Integer> listOfValidRowAndCol;

  /**
   * Sets the row and column size based off arm thickness.
   *
   * @param armThickness arm thickness of board
   * @return the row and column size based off arm thickness
   */
  protected int getRowAndColSizeFromThickness(int armThickness) {
    int rowAndCol = armThickness - 1;
    return (rowAndCol * 2) + armThickness;
  }

  /**
   * Creates the board which contains marbles for marble solitaire.
   *
   * @return A 2d ArrayList containing all the marbles in the game marble solitaire.
   */
  protected abstract ArrayList<ArrayList<Marble>> makeBoard();

  /**
   * Takes a marble and sets its state.
   *
   * @param marble a Marble.
   */
  protected void setMarble(Marble marble) {
    if (this.listOfValidRowAndCol.contains(marble.getMarbleRow()) ||
            this.listOfValidRowAndCol.contains(marble.getMarbleCol())) {
      marble.setMarbleState(SlotState.Marble);
    } else {
      marble.setMarbleState(SlotState.Invalid);
    }
  }

  protected ArrayList<ArrayList<Marble>> getBoard() {
    return this.board;
  }

  /**
   * Returns a list containing the index of the rows and columns that are within the arm thickness
   * of the board. Ex: a board with arm thickness of 3 has a row size of 7.
   * Of the indices (0, 1, 2, 3, 4, 5, 6) the only ones that can hold a marble are (2, 3, 4),
   * this method returns that list.
   *
   * @return Returns a list containing the valid lists.
   */
  protected ArrayList<Integer> getValidList() {
    ArrayList<Integer> rowList = new ArrayList<Integer>();
    for (int i = 0; i < this.numOfCol; i++) {
      int lowerBound = this.armThickness - 1;
      int higherBound = (this.numOfCol - this.armThickness);
      if (!(i < lowerBound || i > higherBound)) {
        rowList.add(i);
      }
    }
    return rowList;
  }


  /**
   * Returns a marble that's at the given row/col.
   *
   * @param rowToCheck Represents the row
   * @param colToCheck Represents the col
   */
  protected Marble find(int rowToCheck, int colToCheck) throws IllegalArgumentException {
    for (int row = 0; row < this.numOfRows; row++) {
      if (row == rowToCheck) {
        ArrayList<Marble> rowArrayList = this.board.get(row);
        for (int col = 0; col < this.numOfCol; col++) {
          if (col == colToCheck) {
            return rowArrayList.get(col);
          }
        }
      }
    }
    throw new IllegalArgumentException("This marble does not exist");
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (fromRow != toRow) {
      if (fromCol != toCol) {
        throw new IllegalArgumentException("Can't jump there!");
      }
    }
    if (fromRow == toRow && fromCol == toCol) {
      throw new IllegalArgumentException("Can't jump there!");
    }
    this.moveMarble(fromRow, fromCol, toRow, toCol, false);
  }

  /**
   * A helper method for move that moves the marbles.
   *
   * @param fromRow   row the marble is coming from
   * @param fromCol   col the marble is coming from
   * @param toRow     row the marble is going to
   * @param toCol     col the marble is going to
   * @param checkOnly a boolean that is true if the doesMarbleHaveValidMoves calls this method,
   *                  if it is true it does not initialize the
   *                  fields of the board (i.e. it tests if the method throws an exception,
   *                  but does not execute the method)
   * @throws IllegalArgumentException if a position to jump is not allowed.
   */
  protected void moveMarble(int fromRow, int fromCol, int toRow, int toCol, boolean checkOnly)
          throws IllegalArgumentException {
    Marble originalMarble = this.find(fromRow, fromCol);
    Marble spotToJumpTo = this.find(toRow, toCol);
    if (fromRow == toRow) {
      if (fromCol > toCol) {
        if (fromCol - 1 != toCol + 1) {
          throw new IllegalArgumentException("Can't jump there");
        }
      } else if (toCol > fromCol) {
        if (toCol - 1 != fromCol + 1) {
          throw new IllegalArgumentException("Can't jump there");
        }
      }
    }
    if (fromCol == toCol) {
      if (fromRow > toRow) {
        if (fromRow - 1 != toRow + 1) {
          throw new IllegalArgumentException("Can't jump there");
        }
      } else if (toRow > fromRow) {
        if (toRow - 1 != fromRow + 1) {
          throw new IllegalArgumentException("Can't jump there");
        }
      }
    }
    if (spotToJumpTo.getMarbleState() != SlotState.Empty) {
      throw new IllegalArgumentException("Can't jump there!");
    }
    Marble marbleToJumpOver = this.getMarbleToJumpOver(fromRow, fromCol, toRow, toCol);
    if (marbleToJumpOver.getMarbleState() != SlotState.Marble) {
      throw new IllegalArgumentException("Can't jump there!");
    }
    if (!checkOnly) {
      marbleToJumpOver.setMarbleState(SlotState.Empty);
      originalMarble.setMarbleState(SlotState.Empty);
      spotToJumpTo.setMarbleState(SlotState.Marble);
    }
  }

  /**
   * Gets the marble that needs to be jumped over.
   *
   * @param fromRow row the marble is coming from
   * @param fromCol col the marble is coming from
   * @param toRow   row the marble is going to
   * @param toCol   col the marble is going to
   * @return the marble that is being jumped over
   * @throws IllegalArgumentException if you can't jump over this marble.
   */
  protected Marble getMarbleToJumpOver(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    Marble marbleToJumpOver;
    if (fromRow == toRow) {
      if (toCol > fromCol) {
        marbleToJumpOver = this.find(fromRow, toCol - 1);
      } else {
        marbleToJumpOver = this.find(fromRow, fromCol - 1);
      }
      return marbleToJumpOver;
    } else if (fromCol == toCol) {
      if (toRow > fromRow) {
        marbleToJumpOver = this.find(toRow - 1, fromCol);
      } else {
        marbleToJumpOver = this.find(fromRow - 1, toCol);
      }
      return marbleToJumpOver;
    }
    throw new IllegalArgumentException("Can't jump there!");
  }

  @Override
  public boolean isGameOver() {
    if (this.getScore() == 1) {
      return true;
    }
    for (int row = 0; row < this.numOfRows; row++) {
      ArrayList<Marble> rowArrayList = this.board.get(row);
      for (int col = 0; col < this.numOfCol; col++) {
        Marble marble = rowArrayList.get(col);
        if (marble.getMarbleState() == SlotState.Marble) {
          if (this.doesMarbleHaveValidMoves(marble)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Takes a marble and returns true if it is able to move.
   *
   * @param marble a marble in the board
   * @return true or false depending on if the marble can move anywhere.
   */
  protected boolean doesMarbleHaveValidMoves(Marble marble) {
    int fromRow = marble.getMarbleRow();
    int fromCol = marble.getMarbleCol();
    int numberOfMoves = 4;
    int toRow = fromRow;
    int toCol = fromCol;

    for (int i = 0; i < numberOfMoves; i++) {
      boolean illegalMove = false;
      switch (i) {
        case 0:
          toCol = fromCol - 2;
          break;
        case 1:
          toRow = fromRow;
          toCol = fromCol + 2;
          break;
        case 2:
          toRow = fromRow - 2;
          toCol = fromCol;
          break;
        case 3:
          toRow = fromRow + 2;
          toCol = fromCol;
          break;
        default:
          // do nothing
      }
      try {
        this.moveMarble(fromRow, fromCol, toRow, toCol, true);
      } catch (IllegalArgumentException ex) {
        illegalMove = true;
      }
      if (!illegalMove) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int getBoardSize() {
    return this.numOfRows;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    Marble marbleToReturn = this.find(row, col);
    return marbleToReturn.getMarbleState();
  }

  @Override
  public int getScore() {
    int gameScore = 0;
    for (int i = 0; i < this.numOfRows; i++) {
      ArrayList<Marble> rowArrayList = this.board.get(i);
      for (int j = 0; j < this.numOfCol; j++) {
        Marble marble = rowArrayList.get(j);
        if (marble.getMarbleState() == SlotState.Marble) {
          gameScore++;
        }
      }
    }
    return gameScore;
  }
}