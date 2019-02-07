package action;

import menu.Menu;
import menu.MenuItem;


public class ListBackendMenuAction implements Action {
	
	
		ManageBackendMenuAction manage;
		
		public ListBackendMenuAction(MenuItem menuitem,Action action) {
			this.manage=(ManageBackendMenuAction) action;
		}
	public void actionPerformed() {
		
		System.out.println("List Of Backends");
		manage.display();
		manage.display1();

		
	}
}