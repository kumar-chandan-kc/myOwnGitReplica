/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;


class node
{
    node parents[];
    node next;
    String filestructure;
    Boolean isBranchHead;
    String nodeName = "";
    public node(String filestructure, Boolean isBranchHead, String nodeName)
    {
        this.filestructure = filestructure;
        // parents = new node[2];
        this.isBranchHead = isBranchHead;
        this.nodeName = nodeName;
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
}

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		git test = new git();
		test.createBranch("myfirstBranch");
		System.out.println(test.findNode("myfirstBranch"));
	}
}
