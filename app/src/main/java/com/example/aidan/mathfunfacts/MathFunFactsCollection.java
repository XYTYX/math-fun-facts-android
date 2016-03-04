public class MathFunFactsCollection {
 
    List<ParserMathFunFact> MathFunFacts;
    Context context;

    public MathFunFactCollection(Context context) {
        this.MathFunFacts = new LinkedList<ParserMathFunFact>();
        this.context = context;
        ParseAllMathFunFactFile(context);
    }



public ArrayList<ParserMathFunFact> findMFFWithLevel(int level) {
    ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();
    ListIterator<ParserMathFunFact> iter = MathFunFacts.listIterator();
    while (iter.hasNext()) {
        ParserMathFunFact mathfunfact = iter.next();
        if (mathfunfact.getLevel() == level) {
            results.add(mathfunfact);
        }
    }
    return results;
}

public ArrayList<ParserMathFunFact> findMFFWithSubject(Subject subject_to_find) {
    ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();
    ListIterator<ParserMathFunFact> iter = MathFunFacts.listIterator();
        while (iter.hasNext()) {
            ParserMathFunFact mathfunfact = iter.next();
			for(Subject subject_of_MFF_iterated : mathfunfact.getSubjects()){
				if (subject_to_find.equalTo(subject_to_find)) {
                results.add(mathfunfact);
            	}
			}
        }
        return results;
}

public ListIterator<Student> getAllMathFunFacts() {
    return MathFunFacts.listIterator();
}


    public void ParseAllMathFunFactFile(Context context){
    	File[] files = new File(context.getAssets()).listFiles();

    	for(File file: files){
    		if(file.isFile()){
    			MathFunFacts.add(ParserMathFunFact(context,file.getName()));
    		}
    	}
    }

}