
public class MorphoAna {
	static int maxSoFar = 0;
	public static FST f = new FST();
	public static void main(String[] args){
		f.add_arc(0, 1, '\0', '\0');
		FST f = new FST();
	    f.add_arc(0, 1, 'c', 'c');
	    f.add_arc(1, 2, 'a', 'u');
	    f.add_arc(2, 3, 't', 't');
	    f.feed("cat");
	}
	
	public static void addregularWord(String word) {
		FST t = new FST();
		for (int i = 0; i < word.length(); i++){
		    char c = word.charAt(i);   
		    t.add_arc(i, i+1, c, c);
		    
		}
		
		
		
		
	}

}
