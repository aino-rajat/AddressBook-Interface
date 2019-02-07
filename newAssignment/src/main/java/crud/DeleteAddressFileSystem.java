package crud;

import action.Action;
import action.ManageBackendMenuAction;
import menu.MenuItem;

public class DeleteAddressFileSystem implements Action{

	ManageBackendMenuAction manage;
	public  DeleteAddressFileSystem(MenuItem menu,ManageBackendMenuAction action) {
		
		 this.manage=action;
	}

	
	

	public void actionPerformed() {
		manage.getSetHelper().deleteAdressBook();
		
	}

}
