package crud;

import action.Action;
import action.FileBackendAction;
import action.ManageBackendMenuAction;
import helper.FileAddressBookHelper;
import menu.MenuItem;

public class CreateAddressFileSystem implements Action {

	ManageBackendMenuAction manage;
	FileAddressBookHelper filehelper;
	 
	
	public CreateAddressFileSystem(MenuItem create, ManageBackendMenuAction action) {
		this.manage=action;
	}

	public void actionPerformed() {
		manage.getSetHelper().createAddressBook();
		
	}

}
