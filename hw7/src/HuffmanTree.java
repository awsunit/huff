import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanTree {

	// where it all starts
	private HuffmanNode overallRoot;

	public HuffmanTree(int[] array) {
		PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
		// go through the array
		// if the value at array[i] is greater than 0 - means we counted char at least
		// once
		// add it to the queue, in the form of a node
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				HuffmanNode n1 = new HuffmanNode(array[i], i);
				queue.offer(n1);
			}
		}
		// have our queue
		// where is the end of the file?
		// create node with occurrence rate of 1
		// make mvVal greater than CHAR_MAX from MakeCode
		HuffmanNode ender = new HuffmanNode(1, array.length);
		queue.offer(ender);

		// go through queue and get it arranged correctly
		// want a queue with only one node
		while (queue.size() > 1) {
			// take the first two nodes out
			HuffmanNode n1 = queue.remove();
			HuffmanNode n2 = queue.remove();

			// System.out.println(n1.myVal + " " +
			// n2.myVal);

			// combine them into a new node//combine their occurrence rates
			// no longer need n1 or n2 myVal - set to null?
			int i = n1.occurrenceRate + n2.occurrenceRate;
			// System.out.println(i);
			HuffmanNode n3 = new HuffmanNode(i, -1, n1, n2);
			queue.offer(n3);
		}
		// queue is down to 1, make it the overallRoot
		overallRoot = queue.remove();
	}

	// create HuffmanTree using data from a scanner
	public HuffmanTree(Scanner input) {
		while (input.hasNextLine()) {
			//want to take two lines - myVal and the string that is the location
			int myVal = Integer.parseInt(input.nextLine());
			String location = input.nextLine();
			//now start constructing the tree
			//using recursion? check the node now
			
			overallRoot = assemble(overallRoot,myVal,location);
		}
	}
	private HuffmanNode assemble(HuffmanNode n1,int myVal,String myLocation) {
		//avoid nullexception
		if(n1 == null) {
			//create a node
			//make myVal null (-1) since Im just a path node
			n1 = new HuffmanNode(0,-1);
		}
		//when do we print this value??
		//myLocation gives map back to location
		//while myLocation isn't empty then we have a path to travel
		
		//path ended, at the node the value should be
		if(myLocation.length() == 0) {
			HuffmanNode n = new HuffmanNode(0,myVal);
			return n;
		}else if(myLocation.charAt(0) == '0') {
			//must have been a node on the left
			n1.left = assemble(n1.left,myVal,myLocation.substring(1));
			System.out.println(n1.left.myVal);
		}else {
			//must have been a node on the right
			n1.right = assemble(n1.right,myVal,myLocation.substring(1));
			System.out.println(n1.right.myVal);
		}
//		System.out.println(n1.myVal);
		return n1;
	}
	

	

	// reads bits from input writes characters to output
	// stops at ender
	public void decode(BitInputStream input, PrintStream output, int ender) {

	}

	// lets write 
	public void write(PrintStream output) {
		if (overallRoot != null) {
			writeHelp(output, overallRoot, "");
		}
	}

	private void writeHelp(PrintStream output, HuffmanNode n1, String s) {
		// basecase - at a leaf aka an ascii val
		if (n1.right == null && n1.left == null) {
			output.println(n1.myVal);
			output.println(s);
		} else {
			// lets call it on the kids
			// dont print my data - effect of Huffman design
			// going left - add 0 to s
			// going right - add 1
			String left = s + "0";
			String right = s + "1";
			writeHelp(output, n1.left, left);
			writeHelp(output, n1.right, right);
		}
	}

}
