//   For more info see :  http://introcs.cs.princeton.edu/java/52turing/  (visited 20.10.2015)
//   http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html 
//  written by pavlinaKonstantinova@gmail.com (for errors and recommendations)
public class TuringDemo {   // for more info:  http://introcs.cs.princeton.edu/java/52turing/    
    public static void main(String args[]) {
        char InpSymb;
        StringBuilder Tape = new StringBuilder("####AAA#######"); // OK
      //  StringBuilder Tape = new StringBuilder("####AAAAAA######"); // OK
       //   StringBuilder Tape = new StringBuilder("####AAAAAAAAAAA#"); // OK
        int TapeInd = 4;
        char state = 'R';
        int i;
        InpSymb = Tape.charAt(TapeInd);
        int TapeSize = 12;//for printing
        System.out.print("\nUsing SWITCH\nBegin:TapeInd=" + TapeInd + ", InpSymb=" + InpSymb
                                        + ", state R, InitialTape:");
        for (i = 0; i < TapeSize; i++)System.out.print("" + Tape.charAt(i));
        for (;;) {
            InpSymb = Tape.charAt(TapeInd);
            switch (state)
            {    case 'R':
                     switch ( InpSymb)
                     {    case 'A':
                              Tape.deleteCharAt(TapeInd); Tape.insert(TapeInd, 'X'); 
                              state = 'L';  TapeInd--;
                              break;
                          case '#':
                              state = 'l';  TapeInd--;
                              break;
                          default:
                              TapeInd++;
                    }//end of switch InpSymb for case 'R'
                 break;
                 case 'L':
                     switch ( InpSymb)
                     {    case '#':
                              Tape.deleteCharAt(TapeInd); Tape.insert(TapeInd, '1'); 
                              state = 'R';  TapeInd++;
                              break;
                          case '0':
                              Tape.deleteCharAt(TapeInd); Tape.insert(TapeInd, '1'); 
                              state = 'R';  TapeInd++;
                              break;
                          case '1':
                              Tape.deleteCharAt(TapeInd); Tape.insert(TapeInd, '0'); 
                              TapeInd--;
                              break;
                          default:
                              TapeInd--;
                    }//end of switch InpSymb  for case 'L'
                 break;     
                 case 'l':
                     switch ( InpSymb)
                     {    case '0':
                              state = 'H'; 
                              break;
                          case '1':
                              state = 'H'; 
                              break;
                          case 'X':
                              Tape.deleteCharAt(TapeInd); Tape.insert(TapeInd, '#'); 
                              TapeInd--;
                              break;
                          default:
                              TapeInd--;
                    }//end of switch InpSymb  for case 'l'
            } //end of  switch (state)
            System.out.print("\n     :TapeInd=" + TapeInd + ", InpSymb=" + InpSymb
                    + ", state="+state+", InitialTape:");
            for (i = 0; i < TapeSize; i++)System.out.print("" + Tape.charAt(i));
            if (state=='H') break;
        }// end of for(;;)
    }// end of main
}//end of class
