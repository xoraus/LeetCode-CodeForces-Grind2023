//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class MinHeapNode
{
	char data;
	int freq;
	MinHeapNode left, right;
	MinHeapNode(char data, int freq)
	{
		left = right = null;
		this.data = data;
		this.freq = freq;
	}
}

// comparator class helps to compare the node 
// on the basis of one of its attribute. 
// Here we will be compared 
// on the basis of data values of the nodes. 
class MyComparator implements Comparator<MinHeapNode> { 
    public int compare(MinHeapNode x, MinHeapNode y) 
    { 
  
        return x.freq - y.freq; 
    } 
} 

class Driver_class
{
        static HashMap<Character, String> codes = new HashMap<>();
        static HashMap<Character, Integer> freq = new HashMap<>(); 
        
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            String encodedString = "", decodedString="";
            calcFreq(str, str.length());
            HuffmanCodes(str.length());
            for (int i = 0; i < str.length(); i++)
              encodedString += codes.get(str.charAt(i));
            //cout<<encodedString<<endl;
            decodedString = new Decode().decodeHuffmanData(minHeap.peek(), encodedString);
            System.out.println(decodedString);
        }
    }
    static void calcFreq(String str, int n)
    {
    	for (int i=0; i<str.length(); i++)
    	{
    	    char key = str.charAt(i);
    	    if(freq.containsKey(key) == true)
    	    {
    	        int fq = freq.get(key);
    	        freq.put(key, fq+1);
    	    }else freq.put(key, 1);
    	}	
    }
    
    // creating a priority queue q. 
        // makes a min-priority queue(min-heap). 
        static PriorityQueue<MinHeapNode> minHeap 
            = new PriorityQueue<MinHeapNode>(new MyComparator()); 
    
    static void HuffmanCodes(int size)
    {
    	 MinHeapNode left, right, top;
    // 	for (map<char, int>::iterator v=freq.begin(); v!=freq.end(); v++)
    // 		minHeap.push(new MinHeapNode(v->first, v->second));
         for(Map.Entry<Character, Integer> hm: freq.entrySet())
         {
             char ch = hm.getKey();
             int val = hm.getValue();
             minHeap.add(new MinHeapNode(ch, val));
         }
    	while (minHeap.size() != 1)
    	{
    		left = minHeap.peek();
    		minHeap.poll();
    		right = minHeap.peek();
    		minHeap.poll();
    		top = new MinHeapNode('$', left.freq + right.freq);
    		top.left = left;
    		top.right = right;
    		minHeap.add(top);
    	}
    	storeCodes(minHeap.peek(), "");
    }
    
    static void storeCodes(MinHeapNode root, String str)
    {
    	if (root==null)
    		return;
    	if (root.data != '$')
    		codes.put(root.data, str);
    	storeCodes(root.left, str + "0");
    	storeCodes(root.right, str + "1");
    }

}


// } Driver Code Ends


//User function Template for Java

/*class MinHeapNode
{
    char data;
    int freq;
    MinHeapNode left, right, top;
    MinHeapNode(char c, int freq)
    {
        left = right = null;
        this.data = c;
        this.freq = freq;
    }
}*/

class Decode {
    static String decodeHuffmanData(MinHeapNode node, String binaryString) {
        StringBuilder res = new StringBuilder();
        MinHeapNode root = node;
        
        for(char ch: binaryString.toCharArray()){
            if(ch == '0') node = node.left;
            else node = node.right;
            
            if(node.data != '$'){
                res.append(node.data);
                node = root;
            }
        }
        
        return res.toString();
    }
}

