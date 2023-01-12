package cs3500.marblesolitaire;

import java.io.InputStreamReader;
import java.util.HashMap;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Use this to play a game of Marble Solitaire. You must specify what type of
 * Marble Solitaire you want to play (type "english" for English Solitaire,
 * "european" for European Solitaire, and "triangular" for Triangle Solitaire). If you want to
 * customize the size, type in -size and whatever size you want (<STRONG>PLEASE NOTE:</STRONG>
 * size must be a positive odd integer for English and European Solitaire,
 * and must be a positive integer for Triangle Solitaire). If you want to specify the
 * empty hole you would like to start at, type -hole and
 * followed by the row and col (both as integers) that the empty hole will
 * be placed at (<STRONG>PLEASE NOTE:</STRONG> you must enter holes where a marble will exist,
 * anything off the board will not to work).
 */
public class MarbleSolitaire {
  static MarbleSolitaireModel solitaireType;
  static InputStreamReader consoleStreamReader = new InputStreamReader(System.in);
  static MarbleSolitaireView mainView;

  /**
   * A main method to play a game of English, European, or Triangle solitaire.
   *
   * @param args an Array of strings
   */
  public static void main(String[] args) {
    HashMap<String, String> inputMap = new HashMap<>();
    inputMap = parseInput(args);
    createSolitaireModelAndView(inputMap);
    MarbleSolitaireControllerImpl controller_ =
            new MarbleSolitaireControllerImpl(solitaireType, mainView,
                    consoleStreamReader);
    playGame(controller_);
  }

  private static void createSolitaireModelAndView(HashMap<String, String> inputMap) {
    String solitaireType = inputMap.get("solitaireType");
    String size = inputMap.get("size");
    String emptyMarbleRow = inputMap.get("marbleRow");
    String emptyMarbleCol = inputMap.get("marbleCol");
    int sizeInt = Integer.parseInt(size);
    int emptyMarbleRowInt = Integer.parseInt(emptyMarbleRow);
    int emptyMarbleColInt = Integer.parseInt(emptyMarbleCol);

    switch (solitaireType) {
      case "english":
        if (size.equals("-1") && (emptyMarbleRow.equals("-1") || emptyMarbleCol.equals("-1"))) {
          sizeInt = EnglishSolitaireModel.DEFAULT_SIZE;
          emptyMarbleRowInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          emptyMarbleColInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          MarbleSolitaire.solitaireType =
                  new EnglishSolitaireModel(sizeInt,
                          emptyMarbleRowInt, emptyMarbleColInt);
        } else if (!(size.equals("-1")) && (emptyMarbleRow.equals("-1")
                || emptyMarbleCol.equals("-1"))) {
          emptyMarbleRowInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          emptyMarbleColInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          MarbleSolitaire.solitaireType =
                  new EnglishSolitaireModel(sizeInt,
                          emptyMarbleRowInt, emptyMarbleColInt);
        } else if (size.equals("-1")) {
          sizeInt = EnglishSolitaireModel.DEFAULT_SIZE;
          MarbleSolitaire.solitaireType =
                  new EnglishSolitaireModel(sizeInt,
                          emptyMarbleRowInt - 1, emptyMarbleColInt - 1);
        } else {
          MarbleSolitaire.solitaireType =
                  new EnglishSolitaireModel(sizeInt,
                          emptyMarbleRowInt - 1, emptyMarbleColInt - 1);
        }
        MarbleSolitaire.mainView = new MarbleSolitaireTextView(MarbleSolitaire.solitaireType);
        break;
      case "european":
        if (size.equals("-1") && (emptyMarbleRow.equals("-1") || emptyMarbleCol.equals("-1"))) {
          sizeInt = EuropeanSolitaireModel.DEFAULT_EURO_SIZE;
          emptyMarbleRowInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          emptyMarbleColInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          MarbleSolitaire.solitaireType =
                  new EuropeanSolitaireModel(sizeInt,
                          emptyMarbleRowInt, emptyMarbleColInt);
        } else if (!(size.equals("-1")) && (emptyMarbleRow.equals("-1")
                || emptyMarbleCol.equals("-1"))) {
          emptyMarbleRowInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          emptyMarbleColInt = (((sizeInt - 1) * 2) + sizeInt) / 2;
          MarbleSolitaire.solitaireType =
                  new EuropeanSolitaireModel(sizeInt,
                          emptyMarbleRowInt, emptyMarbleColInt);
        } else if (size.equals("-1")) {
          sizeInt = EuropeanSolitaireModel.DEFAULT_EURO_SIZE;
          MarbleSolitaire.solitaireType =
                  new EuropeanSolitaireModel(sizeInt,
                          emptyMarbleRowInt - 1, emptyMarbleColInt - 1);
        } else {
          MarbleSolitaire.solitaireType =
                  new EuropeanSolitaireModel(sizeInt,
                          emptyMarbleRowInt - 1, emptyMarbleColInt - 1);
        }
        MarbleSolitaire.mainView = new MarbleSolitaireTextView(MarbleSolitaire.solitaireType);
        break;
      case "triangular":
        if (size.equals("-1") && (emptyMarbleRow.equals("-1") || emptyMarbleCol.equals("-1"))) {
          sizeInt = TriangleSolitaireModel.DEFAULT_SIZE;
          emptyMarbleRowInt = TriangleSolitaireModel.DEFAULT_EMPTY_MARBLE_ROW_AND_COL;
          emptyMarbleColInt = TriangleSolitaireModel.DEFAULT_EMPTY_MARBLE_ROW_AND_COL;
          MarbleSolitaire.solitaireType =
                  new TriangleSolitaireModel(sizeInt,
                          emptyMarbleRowInt, emptyMarbleColInt);
        } else if (!(size.equals("-1")) &&
                (emptyMarbleRow.equals("-1") || emptyMarbleCol.equals("-1"))) {
          emptyMarbleRowInt = TriangleSolitaireModel.DEFAULT_EMPTY_MARBLE_ROW_AND_COL;
          emptyMarbleColInt = TriangleSolitaireModel.DEFAULT_EMPTY_MARBLE_ROW_AND_COL;
          MarbleSolitaire.solitaireType =
                  new TriangleSolitaireModel(sizeInt,
                          emptyMarbleRowInt, emptyMarbleColInt);
        } else if (size.equals("-1")) {
          sizeInt = TriangleSolitaireModel.DEFAULT_SIZE;
          MarbleSolitaire.solitaireType =
                  new TriangleSolitaireModel(sizeInt,
                          emptyMarbleRowInt - 1, emptyMarbleColInt - 1);
        } else {
          MarbleSolitaire.solitaireType =
                  new TriangleSolitaireModel(sizeInt,
                          emptyMarbleRowInt - 1, emptyMarbleColInt - 1);
        }
        MarbleSolitaire.mainView = new TriangleSolitaireTextView(MarbleSolitaire.solitaireType);
        break;
      default:
        // do nothing
    }
  }

  private static HashMap<String, String> parseInput(String[] args) {
    HashMap<String, String> mapToReturn = new HashMap<>();
    String solitaireType = "";
    String size = "-1";
    String marbleRow = "-1";
    String marbleCol = "-1";
    if (args.length < 1) {
      throw new IllegalArgumentException("You must enter english, european, or triangular. " +
              "You may optionally enter an empty hole you wish to start from or " +
              "a desired thickness.");
    }
    String s = args[0];
    solitaireType = s.toLowerCase();
    if (args.length > 1) {
      int argPosition = 1;
      boolean moreArgs = true;
      while (moreArgs) {
        String nextArg = args[argPosition];
        if (nextArg.equals("-size")) {
          size = args[argPosition + 1];
          argPosition = argPosition + 2;
        }
        if (nextArg.equals("-hole")) {
          marbleRow = args[argPosition + 1];
          marbleCol = args[argPosition + 2];
          argPosition = argPosition + 3;
        }
        if (argPosition >= args.length) {
          moreArgs = false;
        }
      }
    }
    mapToReturn.put("solitaireType", solitaireType);
    mapToReturn.put("size", size);
    mapToReturn.put("marbleRow", marbleRow);
    mapToReturn.put("marbleCol", marbleCol);
    return mapToReturn;
  }


  static void playGame(MarbleSolitaireControllerImpl controller) {
    try {
      controller.playGame();
    } catch (IllegalStateException e) {
      System.out.println("\nIllegal State Exception caught");
    }
  }

}

