/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoDijkstra;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 *
 * @author yaffa
 */
public class DemoDijkstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Node> DemoDijkstra=new ArrayList();//List of all Nodes
        HashSet<String> NodeSet=new HashSet(); //set of all nodes to remove dublications
        HashMap<String,Node> NodeMap=new HashMap();
        /** read input **/
        Scanner Input =new Scanner(System.in); 
        System.out.print("Enter the Topology Nodes Names Separated With Space: ");
        String topologyNodes=Input.nextLine();
        //split input into set of words<<nodes names
        String[] words = topologyNodes.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // remove special characters
            words[i] = words[i].replaceAll("[^\\w]", "");
            NodeSet.add(words[i]);
        }
        //to walk on the set of names and creat new object Node for therse names
        Iterator<String> iteratorSet=NodeSet.iterator();
        while(iteratorSet.hasNext()){
            Node n=new Node(iteratorSet.next());
            //add the nodes into the list 
            DemoDijkstra.add(n);
            NodeMap.put(n.getName(),n);
        }
        NodeSet.removeAll(NodeSet);
        //get the neighbors information as input for each node in the list
        Iterator<Node> addNeighbors=DemoDijkstra.iterator();
        while(addNeighbors.hasNext()){
            Node CurrentNode = addNeighbors.next();
            System.out.println(CurrentNode.getName()+"'s current neighbors: {"+CurrentNode.printNeighbors()+ "}");
            System.out.print("Enter # "+CurrentNode.getName()+"'s neighbors: ");
            int nei_num=Input.nextInt();
            /*if(nei_num<=DemoDijkstra.size());*/
            int count =0 ;
            while(nei_num>count
                    &&CurrentNode.getNeighborMap().size()!=nei_num){//checkes if the #the current node's neighbors = the entered #                 
                System.out.print("Meighbor's name: ");
               //ptint curret node's neighbors and thier cost
               String neighbor=Input.next();
                //check if this neighbor is a node in the topology
                if(NodeMap.containsKey(neighbor)
                        &&!CurrentNode.getName().equals(neighbor)
                        &&!CurrentNode.getNeighborMap().containsKey(neighbor)) {
                    System.out.print("Cost: ");
                    int cost=Input.nextInt();
                    //add neighbor to the the current node mape and vise versa && increase count
                    CurrentNode.setNeighbor(NodeMap.get(neighbor), cost);//add enterd node to current nod neighbors map
                    NodeMap.get(neighbor).setNeighbor(CurrentNode, cost);
                   count++; 
                   System.out.println(CurrentNode.getName()+" {"+CurrentNode.printNeighbors()+ "}");
                } else 
                   System.err.println("ERROR: The Enterd Neighbor is not accptable! please enter a valid Node");
                //System.out.println(CurrentNode.printNeighbors()+""+CurrentNode.getName());
            } 
        }
         
        System.out.println("Enter the name of the SOURCE Node");
        Scanner InputSrc =new Scanner(System.in);
        String SRC=InputSrc.next();
        if(NodeMap.containsKey(SRC));
        //check if the SRC node is in the list if yes take it ,, no :error
        System.out.println("Enter the name of the DISTENATION Node");
        Scanner InputDst =new Scanner(System.in);
        String DST=InputDst.next();
        if (DST.equals(SRC)){
                System.out.println("Cost from node"+SRC+" to itself = 0");
                System.exit(2);
            }
        if(!NodeMap.containsKey(DST)){
            System.out.println("distenation Node doesn'y exist");
            System.exit(0);
        }
        /*Object flag = null;
        HashMap<Node, Node> PreviousNode = new HashMap();//to store the previous node to arrive to the node
        HashMap<Node, Integer> FakeList = new HashMap();// to store the node and the last cost to arrive to it
        
        int cost = 0;
        //int jj=0;
        String path = SRC.getName()+"";
         Node leastCostNode= new Node();
         leastCostNode=SRC;
         int leastCost = 0;//اقل وحدة بالسطر
         Iterator<Node> iteratorTestDijkstra=TestDijkstra.iterator();//list of the topology
        
        while(iteratorTestDijkstra.hasNext()){//at the first evrey node have infinit cost
            Node currentNode = iteratorTestDijkstra.next();
            if(currentNode.getName()!=SRC.getName()){
                FakeList.put(currentNode,99999);
            }
        }
        //System.out.println(FakeList);
        while(FakeList.size()>0){
            
            for( Object key : leastCostNode.getNeighborMap().keySet()){// find the lowest cost for every node
                Node NodeKey=(Node) key;
                int currentneighbor= (Integer)leastCostNode.getNeighborMap().get(NodeKey);//the cost from the node that have a lowest cost
                // compare betwwen the previous cost and the cost from the node that have a lowest cost
                if(FakeList.containsKey(NodeKey)&&((cost+currentneighbor)<=FakeList.get(NodeKey))){                    
                    FakeList.put(NodeKey, cost+currentneighbor); 
                  
                    if(!path.contains(leastCostNode.getName())){ 
                    path=path+" "+leastCostNode.getName();
                    cost=cost+leastCost;
                    //System.out.println(leastCostNode.getName());
                    }
                    
                }
            }
            for(Object key2 : FakeList.keySet()){//find the node which have the lowest cost from the map
                leastCost=FakeList.get(key2);
                for( Object key3 : FakeList.keySet()){
                    if(leastCost>=FakeList.get(key3)){
                        leastCost=FakeList.get(key3) ;
                        flag=key3;
                        leastCostNode=(Node) key3;
                        
                    }    
                } 
            }
         
            
           
         
            printNodeMap(FakeList);
            FakeList.remove(flag);//remove tha node that have the lowest cost to ignore it from comparison
            
        }
        
        //System.out.println(path);
        System.out.println(cost);
        
    }
    
    
            
            //System.out.println(FakeList);
    public static void printNodeMap(HashMap Map){
        for( Object key : Map.keySet()){
                Node NodeKey=(Node) key;
                System.out.print(NodeKey.getName()+"");    
        }
        System.out.println();*/
    }
}
