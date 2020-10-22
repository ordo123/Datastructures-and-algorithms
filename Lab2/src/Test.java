
public class Test {

	public static int checkBalance(AVLTreeNode<Integer> curr) {
		if (curr == null) {
			return 0;
		}
		return curr.getLeft().getHeight() - curr.getRight().getHeight();
	}

	public static void main(String[] args) {
		
		AVLTree<Integer> tree = new AVLTree<Integer>(); 
		
		for (Integer i = 1; i <= 50; i++) {
			tree.insert(i);
		}
		
		int x = checkBalance(tree.getRoot()); 
		if (x < -1 || x > 1) {
			System.out.println("Obalans!! Insert() fungerar ej som den ska");
		} else {
			System.out.println("Insert() = BALANSERAT!");
		}
		
		System.out.println("Är trädet tomt? "+tree.empty() +"\n");
		
		for (int i = 5; i <= 35; i++) {
			tree.remove(i);
		}
		
		int y = checkBalance(tree.getRoot()); 
		
		if (y < -1 || y > 1) {
			System.out.println("Obalans!! Remoove() fungerar ej som den ska");
		} else {
			System.out.println("Remove() #1 (delvis borttagning) = BALANSERAT!");
		}	
		
		System.out.println("Är trädet tomt? "+tree.empty()+"\n");
		
		while (!tree.empty()) {
		tree.remove(tree.findMax());
		
		
		}
		int v = checkBalance(tree.getRoot()); 
		
		if (v < -1 || v > 1) {
			System.out.println("Obalans!! Remoove() fungerar ej som den ska");
		} else {
			System.out.println("Remove() #2 (allt borttaget) = BALANSERAT!");
		}	
		
		System.out.println("Är trädet tomt? "+tree.empty());
	}

}

