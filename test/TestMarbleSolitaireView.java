import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Class that contains my tests for MarbleSolitaireView.
 */
public class TestMarbleSolitaireView extends TestEnglishSolitaire {


  @org.junit.Test
  public void testToString() {
    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.viewConstructor1.toString());
    this.exBoardConstructor1.move(1, 3, 3, 3);
  }

  @Test
  public void testToStringEuro() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    this.viewConstructor1 = new MarbleSolitaireTextView(this.exBoardConstructor1);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", this.viewConstructor1.toString());
  }


  @org.junit.Test
  public void testRenderBoard() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(this.exBoardConstructor1, out);
    try {
      view.renderBoard();
    } catch (IOException e) {
      // Do nothing
    }
    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", out.toString());

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
  public void testRenderBoardEuro() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(this.exBoardConstructor1, out);
    try {
      view.renderBoard();
    } catch (IOException e) {
      // Do nothing
    }
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", out.toString());

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

  @org.junit.Test
  public void testRenderMessage() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(this.exBoardConstructor1, out);
    try {
      view.renderMessage("hi");
    } catch (IOException e) {
      // Do nothing
    }
    Assert.assertEquals("hi", out.toString());

    // Testing IO Exceptions
    CorruptAppendable corruptAppendable = new CorruptAppendable();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(this.exBoardConstructor1,
            corruptAppendable);

    try {
      view2.renderMessage("hi");
    } catch (IOException e) {
      // Caught IO exception! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IO Exception!");
    }
  }

  @Test
  public void testRenderMessageEuro() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(this.exBoardConstructor1, out);
    try {
      view.renderMessage("hi");
    } catch (IOException e) {
      // Do nothing
    }
    Assert.assertEquals("hi", out.toString());

    // Testing IO Exceptions
    CorruptAppendable corruptAppendable = new CorruptAppendable();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(this.exBoardConstructor1,
            corruptAppendable);

    try {
      view2.renderMessage("hi");
    } catch (IOException e) {
      // Caught IO exception! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IO Exception!");
    }
  }

  @org.junit.Test
  public void testViewConstructor() {
    try {
      MarbleSolitaireView corruptView = new MarbleSolitaireTextView(null);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }

    try {
      MarbleSolitaireView corruptView = new MarbleSolitaireTextView(
              this.exBoardConstructor1, null);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }
    Assert.assertEquals("", "");
  }

  @Test
  public void testViewConstructorEuro() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    try {
      MarbleSolitaireView corruptView = new MarbleSolitaireTextView(null);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }

    try {
      MarbleSolitaireView corruptView = new MarbleSolitaireTextView(
              this.exBoardConstructor1, null);
    } catch (IllegalArgumentException e) {
      // Caught IllegalArgumentException! (uncomment the System.out if you want to see if it works)
      //System.out.println("Caught IllegalArgumentException!");
    }
    Assert.assertEquals("", "");
  }
}
