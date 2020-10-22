import java.io.*;

public class newSymbolTableTest {

	
	public static void main(final String[] args) throws IOException {
		
		SymbolTable st = new SymbolTable();
		
		System.out.println("TEST");
		System.out.println("----");
		
		st.put("hej", 'x');

		st.dump();
		
		st.put("hej", null);
		
		st.dump();

	}
	
}
