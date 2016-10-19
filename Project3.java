import java.io.*;
import java.util.*;

class Project3 {
  // METHOD: main
  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
        System.out.println("Error: Directory name is missing");
        System.out.println("Usage: java scoreProcess directory_name");
        return;
    }
    File directory = new File(args[0]); // args[0] contains the directory name
    File[] files = directory.listFiles(); // get the list of files from that directory

    File file;
    Scanner input;
    Scanner kb = new Scanner(System.in);
    String inputName;
    HashTable<String, Double> hasht = new HashTableImpl<String, Double>();
    HashTable<String, Integer> hashS = new HashTableImpl<String, Integer>();
    int count;

    // process the arguments stores in args
    for (int i = 0; i < files.length; i++) {
      input = new Scanner(files[i]);

	String name;
	Double score;

        while (input.hasNext()) {
            name = "";

	      	while (!input.hasNextDouble()){
      		name += input.next() + " ";
      		}

      	score = new Double(input.next());

	if (score == Double.NaN) {
		System.out.println("Error, not a number");
	}

	if (hasht.get(name) != null) {
	score = score + hasht.get(name);
	count = hashS.get(name);
	count = count + 1;
	hasht.put(name, score);
	hashS.put(name, count);

	} else {
	count = 1;
	hasht.put(name, score);
	hashS.put(name, count);
	}

        } // while
    } // for

	// user input
	do {
		System.out.print("Enter name: ");
      		inputName = kb.nextLine();

		// break while-loop
		if (inputName.equals("q")){
		break;
		}

		String inputNamed = inputName + " ";
		if (hasht.get(inputNamed) != null) {
		System.out.println(inputName + ": Avg: " + (hasht.get(inputNamed)/hashS.get(inputNamed)) + " # Scores: " + hashS.get(inputNamed));
		} else {
		System.out.println(inputName + " not found");
		}

	} while (!inputName.equals("q"));


  } // main
} // class


