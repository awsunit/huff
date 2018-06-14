//HuffmanNode class
//sets the left/right values of the node &
//nodes ascii value &
// the nodes rate of occurrence in textfile

public class HuffmanNode implements Comparable<HuffmanNode> {

	public int occurrenceRate;

	public int myVal;

	public HuffmanNode left;
	public HuffmanNode right;

	// constuctor for when left and right are null
	// maybe delete
	public HuffmanNode(int occurrenceRate, int myVal) {
		this(occurrenceRate, myVal, null, null);
	}

	public HuffmanNode(int occurrenceRate, int myVal, HuffmanNode left, HuffmanNode right) {
		this.occurrenceRate = occurrenceRate;
		this.myVal = myVal;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(HuffmanNode n1) {
		// needs to return positive val if this is greater
		// neg val if this is smaller
		// zero if this is the same

		if (this.occurrenceRate == n1.occurrenceRate) {
			return 0;
		} else {
			return (this.occurrenceRate > n1.occurrenceRate ? 1 : -1);
		}
	}

}
