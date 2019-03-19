/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;


class node
{
    List<node> parents;
    // node next;
    String filestructure;
    Boolean isBranchHead;
    String nodeName = "";
    String commitMessage ="";
    public node(String filestructure, Boolean isBranchHead, String nodeName)
    {
        this.filestructure = filestructure;
        // parents = new node[2];
        this.isBranchHead = isBranchHead;
        this.nodeName = nodeName;
        parents = new ArrayList<node>();
    }
    
    public void assignParent(node x)
    {
        this.parents.add(x);
    }
    
    public String toString()
    {
        return this.nodeName + " " + this.filestructure;
    }
    
    
}

class git
{
    node head;
    List<node> Branches = new ArrayList<node>();
    
    String stagedArea = "";
    
    public void checkout(String BranchId)
    {
        head = findNode(BranchId);
        // return head;
    }
    
    public node findNode(String BranchId)
    {Iterator i = Branches.listIterator();
     while(i.hasNext())
     {
         node temp = (node)i.next();
         if(temp.nodeName.equals(BranchId))
         {return temp;}
     }
     return null;
        
    }
    
    public void createBranch(String BranchId)
    {
        Branches.add(new node("f1:sdsd,f2:sds",true,BranchId));
    }
    
    public void stage(String xyz)
    {
        this.stagedArea = xyz;
    }
    
    public void commit(String commitMessage)
    {
        node commitNode = new node(this.stagedArea,false,"commit" + Math.random());
        // System.out.println(commitNode);
        commitNode.assignParent(this.head);
        this.head = commitNode;
        this.stagedArea = "";
    }
    
    public void printAllNodes()
    {
        this.print(this.head);
    }
    
    public void printHeadsParents()
    {
        System.out.println(this.head.parents);
    }
    public void print(node x)
    {
        if(x!=null)
        {for(int i=0;i< x.parents.size();i++)
        {
            print(x.parents.get(i));
        }
        
        System.out.println(x);
        }
    }
}

public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");
        git test = new git();
//      test.createBranch("myfirstBranch");
//      System.out.println(test.findNode("myfirstBranch"));
        test.stage("new file created");
        test.commit("adding a new commit");
        test.stage("new file created2");
        test.commit("adding a new commit2");
        // test.printHeadsParents();
        test.printAllNodes();
        
    }
}
