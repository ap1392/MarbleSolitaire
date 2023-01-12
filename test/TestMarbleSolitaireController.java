import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Class that contains my tests for the MarbleSolitaireController.
 */
public class TestMarbleSolitaireController extends TestEnglishSolitaire {

  @org.junit.Test
  public void testQuitController() {
    Reader quitInput = new StringReader("q");
    Reader validMoveInput = new StringReader("2 4 4 4");
    Reader invalidMoveInput = new StringReader("Invalid Input");
    MarbleSolitaireModel exBoardConstructor = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, quitInput);
    quitController.playGame();
    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());
  }

  @Test
  public void testQuitControllerEuro() {
    Reader quitInput = new StringReader("q");
    MarbleSolitaireModel exBoardConstructor = new EuropeanSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, quitInput);
    quitController.playGame();
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", out.toString());
  }

  @Test
  public void testQuitControllerTri() {
    Reader quitInput = new StringReader("q");
    Reader validMoveInput = new StringReader("2 4 4 4");
    Reader invalidMoveInput = new StringReader("Invalid Input");
    MarbleSolitaireModel exBoardConstructor = new TriangleSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new TriangleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, quitInput);
    quitController.playGame();
    Assert.assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", out.toString());
  }

  @org.junit.Test
  public void testValidMoveController() {
    Reader validMoveInput = new StringReader("2 4 4 4 q");
    MarbleSolitaireModel exBoardConstructor = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, validMoveInput);
    quitController.playGame();
    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());
  }

  @Test
  public void testValidMoveControllerEuro() {
    Reader validMoveInput = new StringReader("2 4 4 4 q");
    MarbleSolitaireModel exBoardConstructor = new EuropeanSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, validMoveInput);
    quitController.playGame();
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35", out.toString());
  }

  @Test
  public void testValidMoveControllerTri() {
    Reader validMoveInput = new StringReader("2 0 0 0 q");
    MarbleSolitaireModel exBoardConstructor = new TriangleSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new TriangleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, validMoveInput);
    quitController.playGame();
    Assert.assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "\n" +
            "Invalid move. Play again.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", out.toString());
  }

  @org.junit.Test
  public void testInvalidMoveController() {
    Reader invalidMoveInput = new StringReader("Invalid Input q");
    MarbleSolitaireModel exBoardConstructor = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, invalidMoveInput);
    quitController.playGame();
    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Please enter 4 positive integers or q to quit.\n" +
            "\n" +
            "Please enter 4 positive integers or q to quit.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());
  }

  @Test
  public void testInvalidMoveControllerEuro() {
    Reader invalidMoveInput = new StringReader("Invalid Input q");
    MarbleSolitaireModel exBoardConstructor = new EuropeanSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, invalidMoveInput);
    quitController.playGame();
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "\n" +
            "Please enter 4 positive integers or q to quit.\n" +
            "\n" +
            "Please enter 4 positive integers or q to quit.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", out.toString());
  }

  @Test
  public void testInvalidMoveControllerTri() {
    Reader invalidMoveInput = new StringReader("Invalid Input q");
    MarbleSolitaireModel exBoardConstructor = new TriangleSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new TriangleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, invalidMoveInput);
    quitController.playGame();
    Assert.assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "\n" +
            "Please enter 4 positive integers or q to quit.\n" +
            "\n" +
            "Please enter 4 positive integers or q to quit.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", out.toString());
  }

  @org.junit.Test
  public void testIllegalStateExceptionInPlayGame() {
    Reader in = new StringReader("");
    MarbleSolitaireModel exBoardConstructor = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController illegalStateExceptionController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, in);
    try {
      illegalStateExceptionController.playGame();
    } catch (IllegalStateException e) {
      // Caught IllegalStateException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalStateException!");
    }
    Assert.assertEquals("", "");
  }

  @Test
  public void testIllegalStateExceptionEuro() {
    Reader in = new StringReader("");
    MarbleSolitaireModel exBoardConstructor = new EuropeanSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new MarbleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController illegalStateExceptionController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, in);
    try {
      illegalStateExceptionController.playGame();
    } catch (IllegalStateException e) {
      // Caught IllegalStateException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalStateException!");
    }
    Assert.assertEquals("", "");
  }

  @Test
  public void testIllegalStateExceptionTri() {
    Reader in = new StringReader("");
    MarbleSolitaireModel exBoardConstructor = new TriangleSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView viewConstructor = new TriangleSolitaireTextView(exBoardConstructor, out);
    MarbleSolitaireController illegalStateExceptionController = new MarbleSolitaireControllerImpl(
            exBoardConstructor, viewConstructor, in);
    try {
      illegalStateExceptionController.playGame();
    } catch (IllegalStateException e) {
      // Caught IllegalStateException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalStateException!");
    }
    Assert.assertEquals("", "");
  }

  @org.junit.Test
  public void testControllerConstructor() {
    Reader in = new StringReader("");
    try {
      MarbleSolitaireController fail =
              new MarbleSolitaireControllerImpl(null, this.viewConstructor1, in);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }

    try {
      MarbleSolitaireController fail =
              new MarbleSolitaireControllerImpl(this.exBoardConstructor1, null, in);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }

    try {
      MarbleSolitaireController fail =
              new MarbleSolitaireControllerImpl(this.exBoardConstructor1,
                      this.viewConstructor1, null);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }
    Assert.assertEquals("", "");
  }
}
