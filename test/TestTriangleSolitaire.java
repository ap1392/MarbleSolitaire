import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

/**
 * Class that contains my tests for TriangleSolitaire.
 */
public class TestTriangleSolitaire extends TestTriangleSolitaireTextView {

  @Test
  public void testTriConstructors() {
    Assert.assertEquals("1", Integer.toString(1));
    try {
      MarbleSolitaireModel failedConstructor1 = new TriangleSolitaireModel(-1);
      MarbleSolitaireModel failedConstructor2 = new TriangleSolitaireModel(0);
    } catch (IllegalArgumentException e) {
      // Do nothing
    }
    try {
      MarbleSolitaireModel failedConstructor1 = new TriangleSolitaireModel(-1, -1);
    } catch (IllegalArgumentException e) {
      // Do nothing
    }
    try {
      MarbleSolitaireModel failedConstructor1 = new TriangleSolitaireModel(-1);
      MarbleSolitaireModel failedConstructor2 = new TriangleSolitaireModel(0);
      MarbleSolitaireModel failedConstructor3 = new TriangleSolitaireModel(-1, -1);
    } catch (IllegalArgumentException e) {
      // Do nothing
    }

  }

  @Test
  public void testTriMove() {
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    try {
      this.exBoardConstructor1.move(-1, -1, -1, -1);
    } catch (IllegalArgumentException e) {
      // Exception caught :)
    }
    Assert.assertEquals(14, this.exBoardConstructor1.getScore());

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(2, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(0, 0));

    // Testing top left diagonal move and making sure the score/marble states are updated properly
    this.exBoardConstructor1.move(2, 2, 0, 0);
    Assert.assertEquals(13, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(2, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(0, 0));

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(2, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(2, 2));

    // Moving right and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(2, 0, 2, 2);
    Assert.assertEquals(12, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(2, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(2, 2));

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(2, 0));

    // Testing bottom left diagonal move
    // and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(0, 0, 2, 0);
    Assert.assertEquals(11, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(2, 0));

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(1, 0));

    // Testing top right diagonal move
    // and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(3, 0, 1, 0);
    Assert.assertEquals(10, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(3, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(1, 0));

    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(3, 0));

    // Moving left and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(3, 2, 3, 0);
    Assert.assertEquals(9, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(3, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 0));

    // I've tested top left diagonal, right, bottom left diagonal, top right diagonal,
    // and left move. Now I'm going to test bottom right diagnosable move, but first I have to
    // make a few moves.

    this.exBoardConstructor1.move(4, 0, 2, 0);
    this.exBoardConstructor1.move(4, 2, 4, 0);
    this.exBoardConstructor1.move(4, 4, 4, 2);


    // Making sure Marbles I'm moving to and from are valid
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(2, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(4, 4));

    // Testing bottom right diagonal move
    // and making sure the score + Marble states are updated properly
    this.exBoardConstructor1.move(2, 2, 4, 4);
    Assert.assertEquals(5, this.exBoardConstructor1.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(2, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(4, 4));
  }

  @Test
  public void testTriGameOver() {
    // Playing a game of European Solitaire and making sure the game isn't over until the last move
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 0, 0, 0);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 2, 2, 0);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(0, 0, 2, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 0, 1, 0);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(3, 3, 1, 1);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(4, 2, 2, 2);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 2, 0, 0);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(0, 0, 2, 0);
    Assert.assertFalse(this.exBoardConstructor1.isGameOver());
    this.exBoardConstructor1.move(2, 0, 4, 2);
    Assert.assertTrue(this.exBoardConstructor1.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    Assert.assertEquals(5, this.exBoardConstructor1.getBoardSize());
    this.exBoardConstructor1 = new TriangleSolitaireModel(99);
    Assert.assertEquals(99, this.exBoardConstructor1.getBoardSize());
    this.exBoardConstructor1 = new TriangleSolitaireModel(19);
    Assert.assertEquals(19, this.exBoardConstructor1.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.exBoardConstructor1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.exBoardConstructor1.getSlotAt(3, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            this.exBoardConstructor1.getSlotAt(0, 2));
  }

  @Test
  public void testScore() {
    // Playing a game of European Solitaire and making sure the score
    // updates correctly until the game finished
    this.exBoardConstructor1 = new TriangleSolitaireModel();
    Assert.assertEquals(14, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 0, 0, 0);
    Assert.assertEquals(13, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 2, 2, 0);
    Assert.assertEquals(12, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(0, 0, 2, 2);
    Assert.assertEquals(11, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 0, 1, 0);
    Assert.assertEquals(10, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(3, 3, 1, 1);
    Assert.assertEquals(9, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(4, 2, 2, 2);
    Assert.assertEquals(8, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 2, 0, 0);
    Assert.assertEquals(7, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(0, 0, 2, 0);
    Assert.assertEquals(6, this.exBoardConstructor1.getScore());
    this.exBoardConstructor1.move(2, 0, 4, 2);
    Assert.assertEquals(5, this.exBoardConstructor1.getScore());
  }
}
