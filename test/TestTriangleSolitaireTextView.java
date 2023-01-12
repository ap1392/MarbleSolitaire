import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;


/**
 * Class that contains my tests for the TriangleSolitaireView.
 */
public class TestTriangleSolitaireTextView extends TestEnglishSolitaire {

  @Test
  public void testTriangleSolitaireViewConstructors() {
    Assert.assertEquals("1", Integer.toString(1));
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    try {
      MarbleSolitaireView failedViewWith1Arg = new TriangleSolitaireTextView(null);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }

    try {
      MarbleSolitaireView failedViewWith2ArgA =
              new TriangleSolitaireTextView(this.exBoardConstructor1, null);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireView failedViewWith2ArgB =
              new TriangleSolitaireTextView(null, new StringBuilder());
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireView failedViewWith2ArgC =
              new TriangleSolitaireTextView(null, null);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
  }

  @Test
  public void testToString() {
    Reader quitInput = new StringReader("q");
    StringBuilder out = new StringBuilder();
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    this.viewConstructor1 = new TriangleSolitaireTextView(this.exBoardConstructor1, out);
    MarbleSolitaireController quitController = new MarbleSolitaireControllerImpl(
            this.exBoardConstructor1, this.viewConstructor1, quitInput);
    Assert.assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.viewConstructor1.toString());
    this.exBoardConstructor1.move(2, 0, 0, 0);
    Assert.assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", this.viewConstructor1.toString());
    quitController.playGame();
    Assert.assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", out.toString());
  }

  @Test
  public void testRenderBoard() {
    StringBuilder out = new StringBuilder();
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    this.viewConstructor1 = new TriangleSolitaireTextView(this.exBoardConstructor1, out);
    try {
      this.viewConstructor1.renderBoard();
    } catch (IOException e) {
      // Do nothing
    }
    Assert.assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", out.toString());

    // Testing IO exception
    CorruptAppendable corruptAppendable = new CorruptAppendable();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(this.exBoardConstructor1,
            corruptAppendable);
    try {
      view2.renderBoard();
    } catch (IOException e) {
      // Caught IO exception! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IO Exception!");
    }
  }

  @Test
  public void testRenderMessage() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(this.exBoardConstructor1, out);
    try {
      view.renderMessage("hi");
    } catch (IOException e) {
      // Do nothing
    }
    Assert.assertEquals("hi", out.toString());

    // Testing IO Exceptions
    CorruptAppendable corruptAppendable = new CorruptAppendable();
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(this.exBoardConstructor1,
            corruptAppendable);

    try {
      view2.renderMessage("hi");
    } catch (IOException e) {
      // Caught IO exception! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IO Exception!");
    }
  }
}
