import java.io.IOException;

/**
 * A corrupt class that implements Appendable solely for the sake of testing IO exceptions.
 */
public class CorruptAppendable implements Appendable {
  public CorruptAppendable() {
    // Constructor does nothing
  }

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
