package action;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import backend.Backend;
import backend.DataBaseBackend;
import backend.FileBackend;
import helper.BackendHelper;
import menu.Menu;
import menu.MenuItem;

public class ManageBackendMenuAction implements Action{
	 ArrayList<Backend> menuList=new ArrayList<Backend>();
	 Backend currentBackend;
	 BackendHelper setHelper;
	    
		public BackendHelper getSetHelper() {
			return setHelper;
		}
		public void setSetHelper(BackendHelper setHelper) {
			this.setHelper = setHelper;
		}
		
		public Backend getCurrentBackend() {
			return currentBackend;
		}
		public void setCurrentBackend(Backend currentBackend) {
			this.currentBackend = currentBackend;
		}
	 
	public  ArrayList<Backend> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Backend> menuList) {
		this.menuList = menuList;
	}
	
	
		public  ManageBackendMenuAction(Menu m){
			
		    load();	
			   MenuItem list=new MenuItem(1, "List Back End");
		        list.setAction(new ListBackendMenuAction(list,this));
		        m.addMenuItem(list);
			
		        Menu addBackend=new Menu(2, "Add Backend ");
		        addBackend.setAction(new AddBackendMenuAction(addBackend,this));
		        m.addMenuItem(addBackend);
		        
		        
		        
		        Menu selectBackend=new Menu(3, "Select Backend ");
		        selectBackend.setAction(new SelectBackendAction(selectBackend,this));
		        m.addMenuItem(selectBackend);
			
		        MenuItem exit=new MenuItem(4,"Exit");
		        exit.setAction(new ExitAction(exit));
		        m.addMenuItem(exit); 
		    
			
	}

		public void addPathList(Backend object) {
			getMenuList().add(object);
		}
	
		public void save() {
			try
			{  
				
				FileOutputStream file = new FileOutputStream("/home/intern3/Desktop/DEF/abc.ser");
				
				ObjectOutputStream out = new ObjectOutputStream(file); 

				// Method for serialization of object 
				out.writeObject(menuList); 

				out.close(); 
				file.close(); 

			//	System.out.println("Object has been serialized"); 

			} 
		
			catch(Exception ex) { 
				//System.out.println("IOException is caught"); 
			} 
		}
	public void actionPerformed() {
	}
	
	public void load() {		///home/intern3/Desktop/ABCD/file1.txt
		 try
	        {   
	            FileInputStream file = new FileInputStream("/home/intern3/Desktop/DEF/abc.ser"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
				try {
					setMenuList((ArrayList<Backend>)in.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} 
	            in.close(); 
	            file.close();  
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
	}
	
	public void display() {
		for(Backend b: menuList) {
			if(b instanceof FileBackend) {
			System.out.println(b);
		  }
		}
	}
	public void display1() {
		for(Backend b1: menuList) {
			if(b1 instanceof DataBaseBackend) {
			System.out.println(b1);
		  }
		}
	}
	
}
