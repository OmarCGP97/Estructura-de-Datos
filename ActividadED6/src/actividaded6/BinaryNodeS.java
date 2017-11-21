/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividaded6;

/**
 *
 * @author Omar Castañeda
 */
import java.util.Scanner;

public class BinaryNodeS {
    public BinaryNodeS LeftChild,RigthChild;
    public String value;
    
    public BinaryNodeS(String val){
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
    
    public void Registrar(){
        String respuesta=this.value;
        Scanner in=new Scanner(System.in);
        String r,p,s;
        System.out.println("¿En que animal estabas pensando?");
        r=in.nextLine();
        System.out.println("¿Cual seria la pregunta para diferenciarlo de "+respuesta+"?");
        p=in.nextLine();
        System.out.println("¿La respuesta para "+r+" seria si?");
        s=in.nextLine();
        if(s.equalsIgnoreCase("S")||s.equalsIgnoreCase("Si")){
            this.LeftChild=new BinaryNodeS(r);
            this.RigthChild=new BinaryNodeS(respuesta);
        }
        else{
            this.LeftChild=new BinaryNodeS(respuesta);
            this.RigthChild=new BinaryNodeS(r);
        }
        this.value=p;
    }
    
    public void Pensar(){
        if(this==null)
            System.out.println("Gracias por participar");
        Scanner in=new Scanner(System.in);
        boolean respuesta=false;
        BinaryNodeS actual=this;
        String r;
        while(!respuesta){
            if(actual.LeftChild==null && actual.RigthChild==null)
                respuesta=true;
            else{
                System.out.println(actual.value);
                r=in.nextLine();
                if(r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si"))
                    actual=actual.LeftChild;
                else if (r.equalsIgnoreCase("n") || r.equalsIgnoreCase("no"))
                    actual=actual.RigthChild;
                else
                    System.out.println("Error, ingrese otra respuesta");
            }
        }
        while(respuesta){
        System.out.println("Estas pensando en un/una "+actual.value+"?");
        r=in.nextLine();
        if(r.equalsIgnoreCase("Si") || r.equalsIgnoreCase("Si")){
            System.out.println("Lo logre, he ganado");
            respuesta=false;
        }
        else if (r.equalsIgnoreCase("N") || r.equalsIgnoreCase("No")){
            respuesta=false;
            actual.Registrar();
        }
        else
            System.out.println("Error, ingrese otra respuesta");
        }
    }
}
