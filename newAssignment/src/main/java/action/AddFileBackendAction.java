package action;

import java.util.Scanner;

import backend.Backend;
import backend.FileBackend;
import helper.FileAddressBookHelper;
import menu.MenuItem;

public class AddFileBackendAction implements Action {
	
	ManageBackendMenuAction manage;
	FileBackend fileBackend;
	public AddFileBackendAction(MenuItem adfiledb, ManageBackendMenuAction action) {
		this.manage=action;
	}

	public void actionPerformed() {
		create();
		manage.save();
	}
	public void create() {
		FileBackend fileBackend=new FileBackend();
		System.out.println("enter the path");
	    Scanner scanner=new Scanner(System.in);
	    fileBackend.setPath(scanner.nextLine());
	    System.out.println(fileBackend);
	    manage.addPathList(fileBackend);
	}
	
	
	public void findInstance() {
		   int i=0;
		   for(Backend b:manage.getMenuList()) {
			   System.out.println(""+(i++)+"."+b);
		   }
		   System.out.println("Enter the file number to select");
		   Scanner scanner=new Scanner(System.in);
		   int ch=scanner.nextInt();
		   for(Backend b:manage.getMenuList()) {
		   if(ch==manage.getMenuList().indexOf(b)) {
			 manage.setCurrentBackend(b);  
			 manage.setSetHelper(new FileAddressBookHelper(manage)); 
		   }
		   
	     }
	     }
}
