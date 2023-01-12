import org.junit.Assert;
import org.junit.Before;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Class that contains my tests for english solitaire.
 */
public class TestEnglishSolitaire {
  protected MarbleSolitaireModel exBoardConstructor1;
  protected MarbleSolitaireModel exBoardConstructor2;
  protected MarbleSolitaireModel exBoardConstructor3;
  protected MarbleSolitaireModel exBoardConstructor4;
  protected MarbleSolitaireView viewConstructor1;

  @Before
  public void init() {
    this.exBoardConstructor1 = new EnglishSolitaireModel();
    this.exBoardConstructor2 = new EnglishSolitaireModel(1, 2);
    this.exBoardConstructor3 = new EnglishSolitaireModel(7);
    this.exBoardConstructor4 =
            new EnglishSolitaireModel(9, 10, 8);
    this.viewConstructor1 = new MarbleSolitaireTextView(this.exBoardConstructor1);

  }

  @org.junit.Test
  public void testConstructors() {
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(-1, 4);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(0, 0);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(-3);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(2);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(-1, 1, -2);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(1, 1, -2);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(2, 1, -2);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    try {
      MarbleSolitaireModelState invalidBoardConstructor
              = new EnglishSolitaireModel(1, 0, 0);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    Assert.assertEquals(25, this.exBoardConstructor4.getBoardSize());
  }

  @org.junit.Test
  public void testGetBoardSize() {
    Assert.assertEquals(7, this.exBoardConstructor1.getBoardSize());
    Assert.assertEquals(7, this.exBoardConstructor2.getBoardSize());
    Assert.assertEquals(19, this.exBoardConstructor3.getBoardSize());
    Assert.assertEquals(25, this.exBoardConstructor4.getBoardSize());
  }

  @org.junit.Test
  public void testGetSlotAt() {
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(3, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            this.exBoardConstructor1.getSlotAt(0, 0));
  }

  @org.junit.Test
  public void testGetScore() {
    Assert.assertEquals(32, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(1, 3, 3, 3);
    Assert.assertEquals(31, this.exBoardConstructor1.getScore());
  }

  @org.junit.Test
  public void testMove() {
    try {
      this.exBoardConstructor1.move(-1, -1, -1, -1);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    Assert.assertEquals(32, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(1, 3, 3, 3);
    this.exBoardConstructor1.move(4, 3, 2, 3);
    Assert.assertEquals(30, this.exBoardConstructor1.getScore());
  }

  @org.junit.Test
  public void testIsGameOver() {
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
  }

}

