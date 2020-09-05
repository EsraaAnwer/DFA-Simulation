/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autumata;


 import java.io.Serializable;
public class DFA implements Serializable{
	
	String in;
	String to;
	String out;
	public DFA(String in,String to,String out){
		this.in=in;
		this.to=to;
		this.out=out;
	}
	
	public String toString() {
    	   return new StringBuffer(" Input : ")
    	   .append(this.in)
    	   .append(" To : ")
    	   .append(this.to)
    	   	.append(" Out : ")
    	   		.append(this.out).toString();
	   }
}
// Input : A To : 1 Out : B
