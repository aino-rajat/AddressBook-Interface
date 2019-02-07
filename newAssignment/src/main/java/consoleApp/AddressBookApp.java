package consoleApp;

import action.Action;
import action.ManageBackendMenuAction;
import menu.Menu;

public class AddressBookApp  {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book 2");
		Menu menu=new Menu(1,"Manage Backend Menu");
		menu.setAction(new ManageBackendMenuAction(menu));
		menu.actionPerformed();
		

	}
}
	
		
		
	

