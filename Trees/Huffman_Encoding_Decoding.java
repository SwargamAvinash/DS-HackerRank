import java.util.Scanner;
import java.util.Map;
import java.lang.Integer;
import java.lang.Character;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;


class HuffmanNode {
	int frequency;
	char data;
	HuffmanNode left,right;

	public HuffmanNode(char data, int freq, HuffmanNode left, HuffmanNode right){
		this.frequency = freq;
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return String.format(
			"\t---(%s , %d)---\n" +
			"\t%s            r %s",
			this.data,
			this.frequency,
			this.left,
			this.right
		);
	}
}

class PQHuffmanNodeComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode h1, HuffmanNode h2) {
		if (h1.frequency < h2.frequency) return -1;
		else if (h1.frequency > h2.frequency) return 1;
		else return 0;
	}
}

class HuffmanAlgorithm {

	private static Scanner in = new Scanner(System.in);

	public static Map<Character,Integer> createFrquecyMap(String message){
		Map<Character,Integer> charCount = new HashMap<>();
		for (char c : message.toCharArray()) {
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			}else {
				charCount.put(c,1);
			}
		}

		for(Map.Entry<Character,Integer> val : charCount.entrySet()) {
			System.out.println(val.getKey() + "-->"+ val.getValue());
		}
		
		return charCount;
	}

	public static HuffmanNode createHuffmanTree(String message) {
		Map<Character,Integer> freq = createFrquecyMap(message);
		PriorityQueue<HuffmanNode> pqueue = new PriorityQueue<>(1, new PQHuffmanNodeComparator());

		for (Map.Entry<Character,Integer> val : freq.entrySet()) {
			pqueue.add(new HuffmanNode(val.getKey(), val.getValue(), null, null));
		}

		while(pqueue.size() > 1) {
			HuffmanNode left = pqueue.poll();
			HuffmanNode right = pqueue.poll();
			HuffmanNode newNode = new HuffmanNode('$', left.frequency + right.frequency, left, right);
			pqueue.add(newNode);
		}

		return pqueue.poll();
	}

	public static void treeTraversal(HuffmanNode root, String encode, Map<Character,String> mapings) {
		if (root == null) return;

		treeTraversal(root.left, encode+"0", mapings);
		treeTraversal(root.right, encode+"1",mapings);

		if(root.left == null && root.right == null) {
			mapings.put(root.data, encode);
		}
	}

	public static String encodeMessage(HuffmanNode tree, String message) {
		String encodedString = "";
		Map<Character,String> mapings = new HashMap<>();

		treeTraversal(tree, "", mapings);

		for (Map.Entry<Character,String> val : mapings.entrySet()){
			System.out.println(val.getKey() + " ---> " + val.getValue());
		}

		for (char c : message.toCharArray()) {
			encodedString += mapings.get(c);
		}

		return encodedString;
	}

	public static String decodeMessage(HuffmanNode tree, String encodedMessage) {
		HuffmanNode temp = tree;
        String decodedString = "";
        for(char c : encodedMessage.toCharArray()) {
            if (c == '0') temp = temp.left;
            else temp = temp.right;

            if(temp.left == null && temp.right == null){
                decodedString += temp.data;
                temp = tree;
            }
        }
		return decodedMessage;
	}

	public static void main(String[] args) {
		String message = in.nextLine();

		HuffmanNode tree = createHuffmanTree(message);
		
		String encodedMess = encodeMessage(tree, message);

		System.out.println(encodedMess);

		String decodedMessage = decodeMessage(tree, encodedMess);

		System.out.println(decodedMessage);
	}

}