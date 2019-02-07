package menu;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.DataBaseBackendAction;
import action.FileBackendAction;


public class Menu extends MenuItem implements Action {
	
	public String title;
	public Action action;

	
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	protected ArrayList<MenuItem> menuItem=new ArrayList<MenuItem>();
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public Menu(int ch,String text) {
			super(ch, text);
			
		}
		
		public Menu(int id,String name,Action action) {
			super(id,name,action);
		}
		
		
		public void addMenuItem(MenuItem menuitem) {
			menuItem.add(menuitem);
		}

	public void actionPerformed() {
    try {
			
			if(action instanceof FileBackendAction || action instanceof DataBaseBackendAction  ) {
				action.actionPerformed();
		   do{
			System.out.println("Title:"+this);
			System.out.println("Menu items for "+getName());
			displayMenuItem();
			int choice=readAndSelectedChoice();
			matchWithTheChoice(choice); 
		}while(true);
			
		}
			while(true) {
				displayMenuItem();
				int choice=readAndSelectedChoice();
				matchWithTheChoice(choice); 
			}
     }catch(Exception e) {
				e.printStackTrace();
			}
	}

	public void displayMenuItem() {
		for(MenuItem mi:menuItem) {
			System.out.println(mi);
		}

	}
	public int readAndSelectedChoice() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nenter the choice");
		int choice=scanner.nextInt();
		return choice;
	}
	public void matchWithTheChoice(int choice) {
		boolean count=false;
		for(MenuItem mitem:menuItem) {
			if(choice==mitem.getId()) {
				count=true;
				mitem.actionPerformed();
				break;
			}
		}
		if(count==false) {
			System.out.println("Invalid Choice ");
		}

	}
	
		
}


