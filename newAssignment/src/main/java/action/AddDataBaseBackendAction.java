package action;

import java.util.Scanner;

import backend.DataBaseBackend;
import menu.MenuItem;

public class AddDataBaseBackendAction implements Action{
	ManageBackendMenuAction manage;
	public AddDataBaseBackendAction(MenuItem mi,ManageBackendMenuAction action) {
		this.manage=action;
	}
	public void actionPerformed() {

		create();
		manage.save();
	}


	public void create() {

		DataBaseBackend file=new DataBaseBackend();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter User");
		file.setUsername(input.next());
		System.out.println("Enter url");
		file.setUrl(input.next());

		System.out.println("Enter password");
		file.setPassword(input.next());

		manage.addPathList(file);

	}
}