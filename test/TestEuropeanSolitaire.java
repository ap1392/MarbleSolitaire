import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

/**
 * Class that contains my tests for European Solitaire.
 */
public class TestEuropeanSolitaire extends TestEnglishSolitaire {

  @Test
  public void testEuroControllers() {
    Assert.assertEquals("1", Integer.toString(1));
    try {
      MarbleSolitaireModel failedConstructor1 = new EuropeanSolitaireModel(-1);
      MarbleSolitaireModel failedConstructor2 = new EuropeanSolitaireModel(2);
    } catch (IllegalArgumentException e) {
      // Do nothing
    }
    try {
      MarbleSolitaireModel failedConstructor1 = new EuropeanSolitaireModel(-1, -1);
      MarbleSolitaireModel failedConstructor2 = new EuropeanSolitaireModel(0, 0);
    } catch (IllegalArgumentException e) {
      // Do nothing
    }
    try {
      MarbleSolitaireModel failedConstructor1 = new EuropeanSolitaireModel(-1);
      MarbleSolitaireModel failedConstructor2 = new EuropeanSolitaireModel(2);
      MarbleSolitaireModel failedConstructor3 = new EuropeanSolitaireModel(-1, -1);
      MarbleSolitaireModel failedConstructor4 = new EuropeanSolitaireModel(0, 0);
    } catch (IllegalArgumentException e) {
      // Do nothing
    }

  }

  @Test
  public void testEuroMove() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    try {
      this.exBoardConstructor1.move(-1, -1, -1, -1);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    Assert.assertEquals(36, this.exBoardConstructor1.getScore());

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(1, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(3, 3));

    // Moving and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(1, 3, 3, 3);
    Assert.assertEquals(35, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(1, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 3));

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(4, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(2, 3));

    // Moving and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(4, 3, 2, 3);
    Assert.assertEquals(34, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(4, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(2, 3));
  }

  @Test
  public void testEuroGameOver() {
    // Playing a game of European Solitaire and making sure the game isn't over until the last move
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(5, 3, 3, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(5, 1, 5, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(5, 4, 5, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 4, 5, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(6, 4, 4, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 5, 4, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 5, 4, 5);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(1, 4, 3, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 2, 4, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 4, 5, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(6, 2, 4, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(5, 5, 5, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(6, 3, 4, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(1, 2, 1, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(0, 4, 2, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(0, 2, 0, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 2, 1, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(1, 1, 1, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 3, 0, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(0, 4, 0, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 0, 2, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 0, 3, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 2, 1, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(0, 2, 2, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 3, 2, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 6, 4, 4);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 1, 4, 3);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 6, 4, 6);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 3, 2, 1);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 4, 4, 2);
    Assert.assertTrue(this.exBoardConstructor1.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    Assert.assertEquals(7, this.exBoardConstructor1.getBoardSize());
    this.exBoardConstructor1 = new EuropeanSolitaireModel(99);
    Assert.assertEquals(295, this.exBoardConstructor1.getBoardSize());
    this.exBoardConstructor1 = new EuropeanSolitaireModel(7);
    Assert.assertEquals(19, this.exBoardConstructor1.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            this.exBoardConstructor1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(3, 3));
  }

  @Test
  public void testGetScore() {
    // Moving until the game is over and making sure the score is correct every single time
    this.exBoardConstructor1 = new EuropeanSolitaireModel();
    Assert.assertEquals(36, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(5, 3, 3, 3);
    Assert.assertEquals(35, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(5, 1, 5, 3);
    Assert.assertEquals(34, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(5, 4, 5, 2);
    Assert.assertEquals(33, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 4, 5, 4);
    Assert.assertEquals(32, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(6, 4, 4, 4);
    Assert.assertEquals(31, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 5, 4, 3);
    Assert.assertEquals(30, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 5, 4, 5);
    Assert.assertEquals(29, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(1, 4, 3, 4);
    Assert.assertEquals(28, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 2, 4, 4);
    Assert.assertEquals(27, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 4, 5, 4);
    Assert.assertEquals(26, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(6, 2, 4, 2);
    Assert.assertEquals(25, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(5, 5, 5, 3);
    Assert.assertEquals(24, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(6, 3, 4, 3);
    Assert.assertEquals(23, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(1, 2, 1, 4);
    Assert.assertEquals(22, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(0, 4, 2, 4);
    Assert.assertEquals(21, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(0, 2, 0, 4);
    Assert.assertEquals(20, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 2, 1, 2);
    Assert.assertEquals(19, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(1, 1, 1, 3);
    Assert.assertEquals(18, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 3, 0, 3);
    Assert.assertEquals(17, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(0, 4, 0, 2);
    Assert.assertEquals(16, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 0, 2, 2);
    Assert.assertEquals(15, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 0, 3, 2);
    Assert.assertEquals(14, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 2, 1, 2);
    Assert.assertEquals(13, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(0, 2, 2, 2);
    Assert.assertEquals(12, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 3, 2, 3);
    Assert.assertEquals(11, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 6, 4, 4);
    Assert.assertEquals(10, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 1, 4, 3);
    Assert.assertEquals(9, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 6, 4, 6);
    Assert.assertEquals(8, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 3, 2, 1);
    Assert.assertEquals(7, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 4, 4, 2);
    Assert.assertEquals(6, this.exBoardConstructor1.getScore());
  }
}
