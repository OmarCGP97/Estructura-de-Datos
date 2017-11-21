package actividaded6;
/**
 *
 * @author Omar Castañeda
 */
import java.util.Scanner;

public class BinaryNode {
    public BinaryNode LeftChild,RigthChild;
    public int value;
    
    public BinaryNode(int val){
        this.value=val;
        this.LeftChild=null;
        this.RigthChild=null;
    }
    
    public void preorderTraversal(){
        System.out.print(" "+this.value);
        if(this.LeftChild==null)
            System.out.print("");
        else
            this.LeftChild.preorderTraversal();
        if(this.RigthChild==null)
            System.out.print("");
        else
            this.RigthChild.preorderTraversal();
    }
    
    public void inorderTraversal(){
        if(this.LeftChild!=null)
            this.LeftChild.inorderTraversal();
        else
            System.out.print("");
        System.out.print(" "+this.value);
        if(this.RigthChild!=null)
            this.RigthChild.inorderTraversal();
        else
            System.out.print("");
    }
    
    public void postorderTraversal(){
        if(this.LeftChild!=null)
            this.LeftChild.postorderTraversal();
        else
            System.out.print("");
        if(this.RigthChild!=null)
            this.RigthChild.postorderTraversal();
        else
            System.out.print("");
        System.out.print(" "+this.value);
    }
    
    public void addNode(int value){
        if(this.value==value)
            System.out.println();
        else if(this.value>value){
            if(this.LeftChild==null)
                this.LeftChild= new BinaryNode(value);
            else
                this.LeftChild.addNode(value);
        }
        else{
            if(this.RigthChild==null)
                this.RigthChild=new BinaryNode(value);
            else
                this.RigthChild.addNode(value);
        }
    }
    
    public BinaryNode findNode(int target){
        if(this.value==target)
            return this;
        else if(this.value>target){
            if(this.LeftChild!=null)
                return this.LeftChild.findNode(target);
            else
                return null;
        }
        else{
            if(this.RigthChild!=null)
                return this.RigthChild.findNode(target);
            else
                return null;
        }
    }
      
}