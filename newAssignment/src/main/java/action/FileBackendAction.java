package action;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.MidiChannel;

import backend.Backend;
import backend.FileBackend;
import crud.CreateAddressFileSystem;
import crud.DeleteAddressFileSystem;
import crud.ReadAddressFileSystem;
import crud.UpdateAddressFileSystem;
import helper.FileAddressBookHelper;
import menu.Menu;
import menu.MenuItem;

public class FileBackendAction implements Action{
ManageBackendMenuAction manage;
Menu m1;
ArrayList<Backend> temporary;
	public FileBackendAction(Menu mi, ManageBackendMenuAction manageBackendMenuAction) {
		temporary=new ArrayList<Backend>();

		MenuItem create=new MenuItem(1,"Create");
		create.setAction(new CreateAddressFileSystem(create, manageBackendMenuAction));
		mi.addMenuItem(create);   

		MenuItem read=new MenuItem(2,"Read");
		read.setAction(new ReadAddressFileSystem(read,manageBackendMenuAction));
		mi.addMenuItem(read);   

		MenuItem update=new MenuItem(3,"Update");
		update.setAction(new UpdateAddressFileSystem(update,manageBackendMenuAction));
		mi.addMenuItem(update);   

		MenuItem delete=new MenuItem(4,"Delete");
		delete.setAction(new DeleteAddressFileSystem(delete,manageBackendMenuAction));
		mi.addMenuItem(delete);   

		MenuItem exit=new MenuItem(5,"Exit");
		exit.setAction(new ExitAction(exit));
		mi.addMenuItem(exit);    
		manage=manageBackendMenuAction;
	}

	public void actionPerformed() {
		
		displayFileBackendList();
		takeInput();
	}

	
	
	
	public void displayFileBackendList(){
	
			int i=0;
			for(Backend list : manage.getMenuList()){
				if(list instanceof FileBackend)
				{
					System.out.println(++i+". FileBackend : "+list);
					temporary.add(list);
				}
			}

	}
	public void takeInput() {
		System.out.println("Enter the file number to select");
		   Scanner scanner=new Scanner(System.in);
		   int ch=scanner.nextInt();
		   Backend currentBackend=temporary.get(--ch);
			manage.setCurrentBackend(currentBackend);
			manage.setSetHelper(new FileAddressBookHelper(manage));
			System.out.println("");
			System.out.println("Current Backend Selected..");
	}
	
}
