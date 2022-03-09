public class Encryptor
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  /** Constructor*/
  public Encryptor(int r, int c)
  {
    letterBlock = new String[r][c];
    numRows = r;
    numCols = c;
  }
  
  public String[][] getLetterBlock()
  {
    return letterBlock;
  }
  
  /** Places a string into letterBlock in row-major order.
   *
   *   @param str  the string to be processed
   *
   *   Postcondition:
   *     if str.length() < numRows * numCols, "A" in each unfilled cell
   *     if str.length() > numRows * numCols, trailing characters are ignored
   */
  public void fillBlock(String str) {
    for (int row = 0; row != letterBlock.length; row++) {
      for (int col = 0; col != letterBlock[row].length; col++) {
        if (!str.equals("")) {
          String letter = str.substring(0, 0 + 1);
          letterBlock[row][col] = letter;
          str = str.substring(1);
        } else {
          letterBlock[row][col] = "A";
        }
      }
    }
  }

  /** Extracts encrypted string from letterBlock in column-major order.
   *
   *   Precondition: letterBlock has been filled
   *
   *   @return the encrypted string from letterBlock
   */
  public String encryptBlock() {
    String newWord = "";
    for (int col = 0; col != letterBlock[0].length; col++) {
      for (int row = 0; row != letterBlock.length; row++) {
          newWord += letterBlock[row][col];
      }
    }
    return newWord;
  }

  /** Encrypts a message.
   *
   *  @param message the string to be encrypted
   *
   *  @return the encrypted message; if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message) {
    String newWord = "";
    int boxes = numRows * numCols;
    while (message.length() >= boxes) {
      fillBlock(message);
      newWord += encryptBlock();
      message = message.substring(boxes);
    }
    fillBlock(message);
    String test = "";
    for (int i = 0; i != boxes; i++) {
      test += "A";
    }
    if (!encryptBlock().equals(test)) {
      newWord += encryptBlock();
    }
    return newWord;
  }
  
  /**  Decrypts an encrypted message. All filler 'A's that may have been
   *   added during encryption will be removed, so this assumes that the
   *   original message (BEFORE it was encrypted) did NOT end in a capital A!
   *
   *   NOTE! When you are decrypting an encrypted message,
   *         be sure that you have initialized your Encryptor object
   *         with the same row/column used to encrypted the message! (i.e. 
   *         the �encryption key� that is necessary for successful decryption)
   *         This is outlined in the precondition below.
   *
   *   Precondition: the Encryptor object being used for decryption has been
   *                 initialized with the same number of rows and columns
   *                 as was used for the Encryptor object used for encryption. 
   *  
   *   @param encryptedMessage  the encrypted message to decrypt
   *
   *   @return  the decrypted, original message (which had been encrypted)
   *
   *   TIP: You are encouraged to create other helper methods as you see fit
   *        (e.g. a method to decrypt each section of the decrypted message,
   *         similar to how encryptBlock was used)
   */
  public String decryptMessage(String encryptedMessage) {
    String actualWord = "";
    int boxes = numRows * numCols;
    while (encryptedMessage.length() >= boxes) {
      String testing = encryptedMessage.substring(0,boxes);
      for (int i )
        for (int col = 0; col < numCols; col = col + numRows) {
          String letter = testing.substring(col, col + 1);
          if (!letter.equals("A")) {
            actualWord += letter;
          }
        }

      }

      encryptedMessage = encryptedMessage.substring(boxes);
    }

  }
}