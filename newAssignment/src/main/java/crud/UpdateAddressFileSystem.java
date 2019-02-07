package crud;

import action.Action;
import action.ManageBackendMenuAction;
import menu.MenuItem;

public class UpdateAddressFileSystem implements Action{
	ManageBackendMenuAction  manage;
	 public UpdateAddressFileSystem( MenuItem menu, ManageBackendMenuAction action) {
			
			this.manage=action;
		}

	

		public void actionPerformed() {
			manage.getSetHelper().updateAdressBook();			
		}

}
