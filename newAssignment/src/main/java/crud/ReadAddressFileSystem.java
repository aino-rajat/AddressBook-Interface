package crud;

import action.Action;
import action.ManageBackendMenuAction;
import helper.FileAddressBookHelper;
import menu.MenuItem;

public class ReadAddressFileSystem implements Action{
	ManageBackendMenuAction manage;
	FileAddressBookHelper file;

			public ReadAddressFileSystem(MenuItem menu, ManageBackendMenuAction action) {
		        this.manage=action;
			}

			
			public void actionPerformed() {
				manage.getSetHelper().readAdressBook();
				
			}

}
