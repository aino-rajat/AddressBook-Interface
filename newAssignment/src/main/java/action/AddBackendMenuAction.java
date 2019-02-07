package action;



import menu.Menu;
import menu.MenuItem;

public class AddBackendMenuAction implements Action {
	
	Menu menu1;
	
	public AddBackendMenuAction(Menu m, ManageBackendMenuAction action) {
	
		MenuItem dbBackend=new MenuItem(1,"DataBase Backend");
		dbBackend.setAction(new AddDataBaseBackendAction(dbBackend,action));
        m.addMenuItem(dbBackend);
        
        MenuItem fileBackend=new MenuItem(2,"File Backend");
        fileBackend.setAction(new AddFileBackendAction(fileBackend,action));
        m.addMenuItem(fileBackend);
        
        MenuItem exit=new MenuItem(3,"Exit");
        exit.setAction(new ExitAction(exit));
        m.addMenuItem(exit);    
        
        
		
	}

	

	


	 






	public void actionPerformed() {
	
		//menu1.actionPerformed();
		
	}

}
