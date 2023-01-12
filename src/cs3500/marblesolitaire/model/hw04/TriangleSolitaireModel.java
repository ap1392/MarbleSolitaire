package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.Marble;

/**
 * Represents the functionality of the Triangle Solitaire Model. This class extends the
 * Abstract Solitaire Class and overrides the setMarble, getValidList, move, moveMarble,
 * getMarbleToJumpOver, and doesMarbleHaveValidMoves methods. I needed to abstract these methods
 * because in Triangle Solitaire I added 2 extra moves. Because of this I obviously needed
 * to change the way I was moving the marbles, but I also had to change my helper for isGameOver.
 * In isGameOver, I used the move to see if an exception was caught, this obviously needed
 * to change. I also had to change my setMarble and getValidList method, since now I am
 * only looking at columns in setMarble and my getValidList needs to simply return an
 * empty ArrayList for makeBoard to mutate. It also implements the makeBoard method, and the
 * difference between this makeBoard and the ones in English and European Solitaire is the
 * way I'm mutating the listOfValidRowsAndCol.
 */
public class TriangleSolitaireModel extends AbstractSolitaire {
  public static int DEFAULT_SIZE = 5;
  public static int DEFAULT_EMPTY_MARBLE_ROW_AND_COL = 0;

  /**
   * Initializes a game of triangle solitaire with default settings
   * (dimension of 5 and the empty marble at (0, 0)).
   */
  public TriangleSolitaireModel() {
    this.armThickness = 5;
    this.numOfRows = 5;
    this.numOfCol = 5;
    this.board = this.makeBoard();
    this.emptyMarbleRow = 0;
    this.emptyMarbleCol = 0;
    this.find(0, 0).setMarbleState(SlotState.Empty);
  }

  /**
   * Initializes a game of Triangle Solitaire with a hole at the specified spot.
   *
   * @param emptySlotRow    row where marble is to be placed.
   * @param emptySlotColumn column where marble is to be placed.
   * @throws IllegalArgumentException if empty slot is off the board or invalid.
   */
  public TriangleSolitaireModel(int emptySlotRow, int emptySlotColumn)
          throws IllegalArgumentException {
    this.armThickness = 5;
    this.numOfRows = 5;
    this.numOfCol = 5;
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
   * Initializes a game of Triangle Solitaire where the dimensions are set to the desired length.
   *
   * @param sideLength desired dimensions
   * @throws IllegalArgumentException if the desired dimension is less than 1.
   */
  public TriangleSolitaireModel(int sideLength) throws IllegalArgumentException {
    if (sideLength < 2) {
      throw new IllegalArgumentException("Side length must be an integer greater than 1");
    }
    this.armThickness = sideLength;
    this.numOfRows = sideLength;
    this.numOfCol = sideLength;
    this.board = this.makeBoard();
    this.emptyMarbleRow = 0;
    this.emptyMarbleCol = 0;
    this.find(0, 0).setMarbleState(SlotState.Empty);
  }

  /**
   * Initializes a game of triangle solitaire where the dimensions are set to the desired length
   * and a hole at the specified spot.
   *
   * @param sideLength      desired dimensions
   * @param emptySlotRow    row where marble is to be placed.
   * @param emptySlotColumn column where marble is to be placed.
   * @throws IllegalArgumentException if the desired dimension is less than 1 or
   *                                  if the empty marble spot is off the board/invalid
   */
  public TriangleSolitaireModel(int sideLength, int emptySlotRow, int emptySlotColumn)
          throws IllegalArgumentException {
    if (sideLength < 2) {
      throw new IllegalArgumentException("Side length must be an integer greater than 1");
    }
    this.armThickness = sideLength;
    this.numOfRows = sideLength;
    this.numOfCol = sideLength;
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
   * Creates the board which contains marbles for marble solitaire.
   *
   * @return A 2d ArrayList containing all the marbles in the game marble solitaire.
   */
  @Override
  protected ArrayList<ArrayList<Marble>> makeBoard() {
    this.listOfValidRowAndCol = this.getValidList();
    this.listOfValidRowAndCol.add(0);
    ArrayList<ArrayList<Marble>> boardArrayList = new ArrayList<>();
    for (int i = 0; i < this.numOfRows; i++) {
      ArrayList<Marble> rowArrayList = new ArrayList<Marble>();
      for (int j = 0; j < this.numOfCol; j++) {
        Marble marble = new Marble(i, j);
        this.setMarble(marble);
        rowArrayList.add(marble);
      }
      if (i < this.armThickness) {
        int lastInt = this.listOfValidRowAndCol.get(this.listOfValidRowAndCol.size() - 1);
        this.listOfValidRowAndCol.add(lastInt + 1);
      }
      boardArrayList.add(rowArrayList);
    }
    return boardArrayList;
  }

  /**
   * Takes a marble and sets its state.
   *
   * @param marble a Marble.
   */
  @Override
  protected void setMarble(Marble marble) {
    if (this.listOfValidRowAndCol.contains(marble.getMarbleCol())) {
      marble.setMarbleState(SlotState.Marble);
    } else {
      marble.setMarbleState(SlotState.Invalid);
    }
  }

  /**
   * Returns a list containing the index of the rows and columns that are within the arm thickness
   * of the board. Ex: a board with arm thickness of 3 has a row size of 7.
   * Of the indices (0, 1, 2, 3, 4, 5, 6) the only ones that can hold a marble are (2, 3, 4),
   * this method returns that list.
   *
   * @return Returns a list containing the valid lists.
   */
  @Override
  protected ArrayList<Integer> getValidList() {
    return new ArrayList<Integer>();

  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
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
  @Override
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
    if (fromRow > toRow && fromCol != toCol) {
      if (fromRow - 1 != toRow + 1 || fromCol - 1 != toCol + 1) {
        throw new IllegalArgumentException("Can't jump there");
      }
    }
    if (toRow > fromRow && fromCol != toCol) {
      if (fromCol + 1 != toCol - 1) {
        throw new IllegalArgumentException("Can't jump there");
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
  @Override
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
    } else {
      if (fromRow > toRow) {
        if (fromCol > toCol) {
          marbleToJumpOver = this.find(fromRow - 1, fromCol - 1);
          return marbleToJumpOver;
        }
      } else {
        if (toCol > fromCol) {
          marbleToJumpOver = this.find(fromRow + 1, fromCol + 1);
          return marbleToJumpOver;
        }
      }
    }
    throw new IllegalArgumentException("Can't jump there!");
  }

  /**
   * Takes a marble and returns true if it is able to move.
   *
   * @param marble a marble in the board
   * @return true or false depending on if the marble can move anywhere.
   */
  @Override
  protected boolean doesMarbleHaveValidMoves(Marble marble) {
    int fromRow = marble.getMarbleRow();
    int fromCol = marble.getMarbleCol();
    int numberOfMoves = 5;
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
          toCol = fromCol + 2;
          break;
        case 5:
          toRow = fromRow - 2;
          toCol = fromCol - 2;
          break;
        case 6:
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

}
