package P133_Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Definition for undirected graph.
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null){
            return node;
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, result);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode nodeInQueue = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>) nodeInQueue.neighbors;
            for(int i = 0; i < neighbors.size(); i++){
                UndirectedGraphNode n1 = neighbors.get(i);
                if(map.containsKey(n1)){
                    map.get(nodeInQueue).neighbors.add(map.get(n1));
                } else {
                    UndirectedGraphNode n1clone = new UndirectedGraphNode(n1.label);
                    map.get(nodeInQueue).neighbors.add(n1clone);
                    map.put(n1, n1clone);
                    queue.add(n1);
                }
            }
            
        }
        return result;
	}
}
