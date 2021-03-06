/* The following code was generated by JFlex 1.4.3 on 2/3/14 2:24 PM */

package org.angularjs.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static org.angularjs.lang.lexer.AngularJSTokenTypes.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/3/14 2:24 PM from the specification file
 * <tt>/Users/denofevil/Code/IDEA/tools/lexer/../../contrib/AngularJS/src/org/angularjs/lang/lexer/angular.flex</tt>
 */
class _AngularJSLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYSTRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\3\1\1\1\0\1\60\22\0\1\30\1\41\1\10"+
    "\1\0\1\11\1\36\1\44\1\10\1\46\1\47\1\34\1\33\1\54"+
    "\1\7\1\5\1\35\12\4\1\56\1\55\1\42\1\40\1\43\1\57"+
    "\1\0\4\61\1\6\1\61\24\12\1\52\1\2\1\53\1\37\1\11"+
    "\1\0\1\20\1\31\1\26\1\24\1\16\1\17\2\12\1\25\1\12"+
    "\1\27\1\21\1\12\1\23\3\12\1\14\1\22\1\13\1\15\3\12"+
    "\1\32\1\12\1\50\1\45\1\51\42\0\1\1\uff5f\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\7\6\5\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\2\36\1\37\1\0\2\3\3\5\1\40\1\5\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\0"+
    "\1\3\5\5\1\51\1\52\1\53\1\54\1\55\3\5"+
    "\1\56\1\54\2\5\1\57\1\54\1\0\1\5\1\0"+
    "\1\5\1\60\1\5\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[85];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\u015e"+
    "\0\144\0\144\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a"+
    "\0\144\0\144\0\144\0\144\0\144\0\u02bc\0\u02ee\0\u0320"+
    "\0\u0352\0\u0384\0\u03b6\0\144\0\144\0\144\0\144\0\144"+
    "\0\144\0\144\0\144\0\144\0\144\0\u03e8\0\u041a\0\144"+
    "\0\144\0\310\0\u044c\0\u047e\0\u04b0\0\u04e2\0\u0514\0\u015e"+
    "\0\u0546\0\u015e\0\u0578\0\u05aa\0\144\0\144\0\144\0\144"+
    "\0\144\0\u05dc\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\u0708"+
    "\0\144\0\144\0\144\0\u073a\0\u015e\0\u076c\0\u079e\0\u07d0"+
    "\0\u015e\0\u0802\0\u0834\0\u0866\0\u015e\0\u0898\0\u08ca\0\u08fc"+
    "\0\u092e\0\u0960\0\144\0\u0992\0\u015e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[85];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\4\1\6\1\7\1\10\1\11"+
    "\1\12\2\10\1\13\1\10\1\14\1\10\1\15\1\16"+
    "\2\10\1\17\1\10\1\20\2\10\1\4\2\10\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\4\1\10\2\46\1\47"+
    "\1\50\4\46\1\51\47\46\1\50\1\46\63\0\1\4"+
    "\1\52\1\4\24\0\1\4\27\0\1\4\4\0\1\4"+
    "\62\0\1\6\1\53\1\54\7\0\1\54\47\0\1\53"+
    "\61\0\1\10\1\0\1\10\3\0\16\10\1\0\2\10"+
    "\26\0\1\10\4\0\1\10\1\0\1\10\3\0\2\10"+
    "\1\55\13\10\1\0\2\10\26\0\1\10\4\0\1\10"+
    "\1\0\1\10\3\0\11\10\1\56\4\10\1\0\2\10"+
    "\26\0\1\10\4\0\1\10\1\0\1\10\3\0\6\10"+
    "\1\57\7\10\1\0\2\10\26\0\1\10\4\0\1\10"+
    "\1\0\1\10\3\0\10\10\1\60\5\10\1\0\2\10"+
    "\26\0\1\10\4\0\1\10\1\0\1\10\3\0\3\10"+
    "\1\61\12\10\1\0\2\10\26\0\1\10\4\0\1\10"+
    "\1\0\1\10\3\0\11\10\1\62\4\10\1\0\2\10"+
    "\26\0\1\10\40\0\1\63\61\0\1\64\61\0\1\65"+
    "\61\0\1\66\65\0\1\67\62\0\1\70\14\0\2\46"+
    "\2\0\4\46\1\0\47\46\1\0\1\46\3\71\1\0"+
    "\11\71\1\72\42\71\1\0\1\71\4\0\1\53\1\0"+
    "\1\54\7\0\1\54\47\0\1\73\2\0\1\73\23\0"+
    "\1\73\32\0\1\10\1\0\1\10\3\0\3\10\1\74"+
    "\2\10\1\75\7\10\1\0\2\10\26\0\1\10\4\0"+
    "\1\10\1\0\1\10\3\0\12\10\1\76\3\10\1\0"+
    "\2\10\26\0\1\10\4\0\1\10\1\0\1\10\3\0"+
    "\7\10\1\77\6\10\1\0\2\10\26\0\1\10\4\0"+
    "\1\10\1\0\1\10\3\0\7\10\1\100\6\10\1\0"+
    "\2\10\26\0\1\10\40\0\1\101\61\0\1\102\21\0"+
    "\4\103\1\104\1\103\1\104\7\103\3\104\3\103\1\104"+
    "\1\103\1\104\2\103\1\104\27\103\1\104\4\0\1\73"+
    "\61\0\1\10\1\0\1\10\3\0\4\10\1\105\11\10"+
    "\1\0\2\10\26\0\1\10\4\0\1\10\1\0\1\10"+
    "\3\0\14\10\1\106\1\10\1\0\2\10\26\0\1\10"+
    "\4\0\1\10\1\0\1\10\3\0\4\10\1\107\11\10"+
    "\1\0\2\10\26\0\1\10\4\0\1\10\1\0\1\10"+
    "\3\0\10\10\1\110\5\10\1\0\2\10\26\0\1\10"+
    "\4\0\1\10\1\0\1\10\3\0\7\10\1\111\6\10"+
    "\1\0\2\10\26\0\1\10\4\0\1\112\1\0\1\112"+
    "\7\0\3\112\3\0\1\112\1\0\1\112\2\0\1\112"+
    "\27\0\1\112\4\0\1\10\1\0\1\10\3\0\15\10"+
    "\1\113\1\0\2\10\26\0\1\10\4\0\1\10\1\0"+
    "\1\10\3\0\5\10\1\114\10\10\1\0\2\10\26\0"+
    "\1\10\4\0\1\10\1\0\1\10\3\0\4\10\1\115"+
    "\11\10\1\0\2\10\26\0\1\10\4\0\1\116\1\0"+
    "\1\116\7\0\3\116\3\0\1\116\1\0\1\116\2\0"+
    "\1\116\27\0\1\116\4\0\1\10\1\0\1\10\3\0"+
    "\16\10\1\117\2\10\26\0\1\10\4\0\1\10\1\0"+
    "\1\10\3\0\13\10\1\120\2\10\1\0\2\10\26\0"+
    "\1\10\4\0\1\71\1\0\1\71\7\0\3\71\3\0"+
    "\1\71\1\0\1\71\2\0\1\71\27\0\1\71\31\0"+
    "\1\121\34\0\1\10\1\0\1\10\3\0\11\10\1\122"+
    "\4\10\1\0\2\10\26\0\1\10\32\0\1\123\33\0"+
    "\1\10\1\0\1\10\3\0\4\10\1\124\11\10\1\0"+
    "\2\10\26\0\1\10\4\0\1\10\1\0\1\10\3\0"+
    "\12\10\1\125\3\10\1\0\2\10\26\0\1\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2500];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\5\1\2\11\6\1\5\11\6\1\12\11"+
    "\2\1\2\11\1\0\12\1\5\11\1\0\6\1\3\11"+
    "\13\1\1\0\1\1\1\0\1\1\1\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[85];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;


  _AngularJSLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _AngularJSLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 136) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 45: 
          { return TRUE_KEYWORD;
          }
        case 50: break;
        case 15: 
          { return LT;
          }
        case 51: break;
        case 42: 
          { return NEQEQ;
          }
        case 52: break;
        case 26: 
          { return SEMICOLON;
          }
        case 53: break;
        case 9: 
          { return MULT;
          }
        case 54: break;
        case 21: 
          { return LBRACE;
          }
        case 55: break;
        case 22: 
          { return RBRACE;
          }
        case 56: break;
        case 14: 
          { return EXCL;
          }
        case 57: break;
        case 38: 
          { return ANDAND;
          }
        case 58: break;
        case 12: 
          { return XOR;
          }
        case 59: break;
        case 19: 
          { return LPAR;
          }
        case 60: break;
        case 24: 
          { return RBRACKET;
          }
        case 61: break;
        case 30: 
          { yypushback(yytext().length()); yybegin(YYINITIAL);
          }
        case 62: break;
        case 25: 
          { return COMMA;
          }
        case 63: break;
        case 4: 
          { return DOT;
          }
        case 64: break;
        case 18: 
          { return OR;
          }
        case 65: break;
        case 29: 
          { return STRING_LITERAL;
          }
        case 66: break;
        case 10: 
          { return DIV;
          }
        case 67: break;
        case 32: 
          { return AS_KEYWORD;
          }
        case 68: break;
        case 48: 
          { return TRACK_BY_KEYWORD;
          }
        case 69: break;
        case 49: 
          { return UNDEFINED_KEYWORD;
          }
        case 70: break;
        case 27: 
          { return COLON;
          }
        case 71: break;
        case 34: 
          { return EQEQ;
          }
        case 72: break;
        case 17: 
          { return AND;
          }
        case 73: break;
        case 43: 
          { yypushback(1); return INVALID_ESCAPE_SEQUENCE;
          }
        case 74: break;
        case 37: 
          { return GE;
          }
        case 75: break;
        case 11: 
          { return PERC;
          }
        case 76: break;
        case 20: 
          { return RPAR;
          }
        case 77: break;
        case 3: 
          { return NUMERIC_LITERAL;
          }
        case 78: break;
        case 39: 
          { return OROR;
          }
        case 79: break;
        case 44: 
          { return INVALID_ESCAPE_SEQUENCE;
          }
        case 80: break;
        case 16: 
          { return GT;
          }
        case 81: break;
        case 47: 
          { return FALSE_KEYWORD;
          }
        case 82: break;
        case 23: 
          { return LBRACKET;
          }
        case 83: break;
        case 28: 
          { return QUEST;
          }
        case 84: break;
        case 35: 
          { return NE;
          }
        case 85: break;
        case 6: 
          { return MINUS;
          }
        case 86: break;
        case 7: 
          { yybegin(YYSTRING); return STRING_LITERAL;
          }
        case 87: break;
        case 1: 
          { return BAD_CHARACTER;
          }
        case 88: break;
        case 5: 
          { return IDENTIFIER;
          }
        case 89: break;
        case 41: 
          { return EQEQEQ;
          }
        case 90: break;
        case 31: 
          { yybegin(YYINITIAL); return STRING_LITERAL;
          }
        case 91: break;
        case 13: 
          { return EQ;
          }
        case 92: break;
        case 33: 
          { return IN_KEYWORD;
          }
        case 93: break;
        case 2: 
          { return WHITE_SPACE;
          }
        case 94: break;
        case 8: 
          { return PLUS;
          }
        case 95: break;
        case 40: 
          { return ESCAPE_SEQUENCE;
          }
        case 96: break;
        case 46: 
          { return NULL_KEYWORD;
          }
        case 97: break;
        case 36: 
          { return LE;
          }
        case 98: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
