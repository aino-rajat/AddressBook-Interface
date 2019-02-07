package action;


import java.util.ArrayList;
import java.util.Scanner;

import backend.Backend;
import backend.DataBaseBackend;
import crud.CreateAddressFileSystem;
import crud.DeleteAddressFileSystem;
import crud.ReadAddressFileSystem;
import crud.UpdateAddressFileSystem;
import helper.DatabaseAddressBookHelper;
import menu.Menu;
import menu.MenuItem;

public class DataBaseBackendAction implements Action {
	
	//ArrayList<Backend> temporary;
	Menu mi;
	ManageBackendMenuAction manage;	
	public DataBaseBackendAction(Menu dbBackend, ManageBackendMenuAction manageBackendMenuAction) {
		this.manage=manageBackendMenuAction;
		
	//	temporary=new ArrayList<Backend>();

		MenuItem create=new MenuItem(1,"Create");
		create.setAction(new CreateAddressFileSystem(create, manageBackendMenuAction));
		dbBackend.addMenuItem(create);   

		MenuItem read=new MenuItem(2,"Read");
		read.setAction(new ReadAddressFileSystem(read,manageBackendMenuAction));
		dbBackend.addMenuItem(read);   

		MenuItem update=new MenuItem(3,"Update");
		update.setAction(new UpdateAddressFileSystem(update,manageBackendMenuAction));
		dbBackend.addMenuItem(update);   

		MenuItem delete=new MenuItem(4,"Delete");
		delete.setAction(new DeleteAddressFileSystem(delete,manageBackendMenuAction));
		dbBackend.addMenuItem(delete);   

		MenuItem exit=new MenuItem(5,"Exit");
		exit.setAction(new ExitAction(exit));
		dbBackend.addMenuItem(exit);    
		
		manage=manageBackendMenuAction;
		
		
	}

	

	public void actionPerformed() {
	display();
	selectList();	
	manage.actionPerformed();
	
	}
	void display() {
		int i=0;
		for(Backend b : manage.getMenuList()) {
			
			if(b instanceof DataBaseBackend ) {
				
				System.out.println(i++  +"."+b);
			}

		}
	}
	
	void selectList() {
		System.out.println("Select the back end you want to work");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		for(Backend b : manage.getMenuList()) {
			
			if(choice == manage.getMenuList().indexOf(b) ) {
				manage.setCurrentBackend(b);
				manage.setSetHelper(new DatabaseAddressBookHelper(manage));
			}
			
		}
	}

	}
