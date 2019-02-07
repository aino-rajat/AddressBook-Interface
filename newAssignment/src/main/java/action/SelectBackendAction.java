package action;

import menu.Menu;
import menu.MenuItem;

public class SelectBackendAction implements Action {

	Menu m;
	public SelectBackendAction(Menu menu, ManageBackendMenuAction manageBackendMenuAction) {
	
		Menu dbBackend=new Menu(1,"Select DataBase Backend");
		dbBackend.setAction(new DataBaseBackendAction(dbBackend,manageBackendMenuAction));
        menu.addMenuItem(dbBackend);
        
        Menu fileBackend=new Menu(2,"Select File Backend",menu);
        fileBackend.setAction(new FileBackendAction(fileBackend,manageBackendMenuAction));
        menu.addMenuItem(fileBackend);
		
        MenuItem exit=new MenuItem(3,"Exit");
        exit.setAction(new ExitAction(exit));
        menu.addMenuItem(exit);    
		
	}
	public void actionPerformed() {
		//System.out.println("Hey U r in Select Backend!");

		//m.actionPerformed();
		
	}

}
