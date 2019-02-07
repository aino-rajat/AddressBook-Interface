package action;

import menu.Menu;
import menu.MenuItem;

public class ExitAction implements Action {

	public ExitAction(MenuItem m) {
		
	}

	public void actionPerformed() {
		System.exit(0);
		
	}

}
