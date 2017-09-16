 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoDijkstra;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author yaffa & khadijah
 */
public class Node {
    private String name;
    private HashMap<Node, Integer> neighborMap=new HashMap();
    public Node(){}
    
    public Node (String name){ setName(name); }
    
    public void setName(String name){  this.name=name;   }
    
    public void setNeighbor(Node neighbor, int cost){  this.neighborMap.put(neighbor, cost);   }
    
    public void EditNeighbor(Node neighbor, int aldCost,int newCost){
        this.neighborMap.replace(neighbor, aldCost, newCost);
    }
    
    public String getName(){  return this.name;  }
    
    public HashMap getNeighborMap(){
        return this.neighborMap;
    }
    public String printNeighbors(){
        String pn,n = "";
        for(Object key : neighborMap.keySet()){
            Node NodeKey=(Node) key;
                n +=" "+NodeKey.getName()+" = "+neighborMap.get(key)+" ";
            }
        return n;
    }
    
}
