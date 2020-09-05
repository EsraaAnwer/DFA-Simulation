/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autumata;


import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Methods{
	

	 
	 public String[][] getTableData (JTable table) {
	 	
    int nRow = table.getRowCount(), nCol = table.getColumnCount();
    String[][] tableData = new String[nRow][nCol];
    for (int i = 0 ; i < nRow ; i++)
        for (int j = 0 ; j < nCol ; j++)
            tableData[i][j] = (String) table.getValueAt(i, j);
    return tableData;
}


	
	
	//save file
	   public void serializeAddress(JTable model,File f){
      
	   try{
                int count=0;
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fout);  
			
			DFA d[]=readtab(model);
		
		
			oos.writeObject(d);
				
		
	
		oos.close();
		System.out.println("Done");
 
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
   
  
   public DFA[] readtab(JTable model){
   	int count=0;
   	
   	int r=model.getRowCount();
   	
   	DFA d[]=new DFA[r];
   	
   	while(count<r){
   		
   		d[count]=new DFA((String)model.getValueAt(count,0),(String)model.getValueAt(count,1)
                        ,(String)model.getValueAt(count,2));
   		count++;
   	}
   	
   	return d;
   }
   
   //load file
   
   public void deserialzeAddress(DefaultTableModel model,File f){
 
 
	  
	  
       int count=0;
	   try{
          
		   FileInputStream fin = new FileInputStream(f);
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   DFA d[]=  (DFA[])ois.readObject();
		   
		  
		   ois.close();
while(count<d.length){
	
	 model.insertRow(count,new String[]{d[count].in,d[count].to,d[count].out});
	count++;
}
		  
 
	   }catch(Exception ex){
		   ex.printStackTrace();
		  
	   } 
   
   }
   
   //acceot putton
   public String accepted(DFA d[],String initial,String enter,String last){
  
   	int count=0;
   	
   	boolean b=false;
   	
   	
        String f=initial;
        String area=f;
 
   	while(count<enter.length()){
   		//area to print
   		area+="--"+enter.charAt(count);
   	for(int i=0;i<d.length;i++){
   		
            
   		
   		//f النطة الحالية
   		if(d[i].in.equalsIgnoreCase(f)&& d[i].to.
                        equalsIgnoreCase(""+enter.charAt(count))){
   			
   			
   			f=d[i].out;
   			area+="-->"+f;
   			
   			break;
   		}
   		
   	}		
   		
   		count++;
   	}
   	
   	if(f.equalsIgnoreCase(last))
   		return area+="\n"+last+"  is final  ==> "+enter+"  is accepted";
   		
   		else
   			
   	return area+="\n"+last+"  is final  ==> "+enter+"  is not  accepted";
   }
}