package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Represents the controller for a game of Marble Solitaire.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable in;
  private int moveFromMarbleRow;
  private int moveFromMarbleCol;
  private int moveToMarbleRow;
  private int moveToMarbleCol;
  private boolean gameOver;
  private boolean isQPressed;


  /**
   * A Constructor that takes in a model, view, and readable and initializes the fields accordingly.
   *
   * @param model A MarbleSolitaireStateModel
   * @param view  A MarbleSolitaireView
   * @param in    A Readable
   * @throws IllegalArgumentException if any inputs are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable in) throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Invalid inputs");
    }

    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void playGame() throws IllegalStateException {
    try {
      this.view.renderBoard();
      this.view.renderMessage("\nScore: " + Integer.toString(this.model.getScore()) + "\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }
    this.gameOver = false;
    this.isQPressed = false;
    Scanner scan = new Scanner(this.in);
    while (!this.gameOver) {
      this.getUserInput(scan);
      if (this.isQPressed) {
        this.renderMessageManageException("\nGame quit!\n");
        this.renderMessageManageException("State of game when quit:\n");
        try {
          this.view.renderBoard();
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        this.renderMessageManageException("\nScore: " + Integer.toString(this.model.getScore()));
        break;
      }
      try {
        this.model.move(this.moveFromMarbleRow - 1, this.moveFromMarbleCol - 1,
                this.moveToMarbleRow - 1, this.moveToMarbleCol - 1);
        try {
          this.view.renderBoard();
          this.renderMessageManageException("\nScore: " +
                  Integer.toString(this.model.getScore()) + "\n");
        } catch (IOException ex) {
          throw new IllegalStateException();
        }
      } catch (IllegalArgumentException e) {
        try {
          this.view.renderMessage("\nInvalid move. Play again.\n");
        } catch (IOException ex) {
          throw new IllegalStateException();
        }
      }

      if (this.model.isGameOver()) {
        this.gameOver = true;
        try {
          this.view.renderMessage("Game over!\n");
          this.view.renderBoard();
          this.view.renderMessage("\nScore: " + Integer.toString(this.model.getScore()) + "\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
      }

    }
  }

  // Gathers the user's input
  private StringBuilder gatherInput(Scanner scan) throws NoSuchElementException {
    boolean done = false;

    int scanCounter = 0;
    int num = 0;
    StringBuilder inputString = new StringBuilder();
    while (!done) {
      String s = scan.next();
      if (s.equals("q") || s.equals("Q")) {
        done = true;
        inputString = new StringBuilder();
        inputString.append(s);
        //return inputString;
      } else {
        try {
          num = Integer.parseInt(s);
          scanCounter++;
          inputString.append(s);
          if (scanCounter == 4) {
            done = true;
            //return inputString;
          } else {
            inputString.append(",");
          }
        } catch (NumberFormatException e) {
          this.renderMessageManageException("\nPlease enter 4 positive integers or q to quit.\n");
        }
      }
    }
    return inputString;
  }

  // A method that lets me render messages so I don't have 1000 try catch methods
  private void renderMessageManageException(String message) {
    try {
      this.view.renderMessage(message);
    } catch (IOException ioEx) {
      throw new IllegalStateException();
    }
    return;
  }


  private void getUserInput(Scanner scan) throws IllegalStateException {
    StringBuilder userInput = new StringBuilder();
    try {
      userInput = this.gatherInput(scan);
    } catch (NoSuchElementException nsEx) {
      throw new IllegalStateException();
    }

    if (userInput.toString().equals("q") || userInput.toString().equals("Q")) {
      this.gameOver = true;
      this.isQPressed = true;
      return;
    }
    Scanner scannedInput = new Scanner(userInput.substring(0));
    scannedInput.useDelimiter(",");
    int scanCounter = 0;
    while (scannedInput.hasNext()) {
      String scannedString = scannedInput.next();
      switch (scanCounter) {
        case 0:
          this.moveFromMarbleRow = Integer.parseInt(scannedString);
          scanCounter++;
          break;
        case 1:
          this.moveFromMarbleCol = Integer.parseInt(scannedString);
          scanCounter++;
          break;
        case 2:
          this.moveToMarbleRow = Integer.parseInt(scannedString);
          scanCounter++;
          break;
        case 3:
          this.moveToMarbleCol = Integer.parseInt(scannedString);
          break;
        default:
          // do nothing
      }

    }
    return;
  }

}
