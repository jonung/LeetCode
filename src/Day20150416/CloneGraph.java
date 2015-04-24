package Day20150416;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import common.UndirectedGraphNode;

public class CloneGraph {

	/*
	 * 首先是要弄懂克隆的概念，在用递归做的时候出现栈溢出
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)	return null;
		
		
		
		UndirectedGraphNode root = createNewNode(node);
		
		
		
		
		return root;
    }
	
	public UndirectedGraphNode createNewNode(UndirectedGraphNode node){
	
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
	
		for(int i = 0; i < node.neighbors.size(); i ++)
			neighbors.add(createNewNode(node.neighbors.get(i)));
		
		return newNode;
	}
	
	/*
	 * 本题主要需要完成2个工作，一是生成新节点，而是要保存节点间的关系
	 * 1.用一个map来保存创建的新节点，key是label，每遇到一个label，检查map中是否有，没有则创建节点并push到map
	 * 2.广度遍历图，需要注意的是自环这种情况，若不加考虑为陷入无限循环。
	 */
	
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if(node == null)
			return null;
		
		Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
		
		//广度搜索遍历原图
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		
		int root = node.label;
		UndirectedGraphNode copy = new UndirectedGraphNode(root);
		map.put(root, copy);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode item = queue.poll();
			int label = item.label;
			
			
			
			List<UndirectedGraphNode> neighbors = item.neighbors;
			
			
			for(int i = 0; i < neighbors.size(); i ++){
				UndirectedGraphNode neighbor = neighbors.get(i);
								
				if(!map.containsKey(neighbor.label)){
					//创建一个节点
					UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor.label, newNode);
					
					queue.add(neighbor);//处理自环的情况，若放在外面则会造成无限循环
				}
				
				map.get(label).neighbors.add(map.get(neighbor.label));
			}
		}
		
		return map.get(root);
	}
	
	
}
