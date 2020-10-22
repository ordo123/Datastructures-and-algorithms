import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    final static private int WordLength = 4;

    public static void main (String args[]) throws IOException {
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	WordList.read(WordLength, stdin);
	LongestChain lc = new LongestChain(WordLength);
	while (true) {
	    String line = stdin.readLine();
	    if (line == null) {
		break;
	    }
	    String tokens[] = line.split(" ");
	    if (tokens.length == 1) {
		lc.checkAllStartWords(tokens[0]);
	    } else if (tokens.length == 2) {
		WordRec wr = lc.breadthFirst(tokens[0], tokens[1]);
		if (wr == null) {
		    System.out.println(tokens[0] + " " +
				       tokens[1] + ": ingen l�sning");
		} else {
			System.out.println("\n");
		    System.out.println(tokens[0] + " " +
				       tokens[1] + ": "+ wr.chainLength()
				       + " ord");
		    wr.printChain();
		}
	    } else{
		System.out.println("felaktig fråga: '" + line + "'");
		System.out.println("syntax för frågor: slutord");
		System.out.println("eller:             startord slutord");
	    }
	}
    }
}
