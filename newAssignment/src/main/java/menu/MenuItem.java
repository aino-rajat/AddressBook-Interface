package menu;

import action.Action;

public class MenuItem implements Action{

		private int id=-1;
		private String name;
		Action action;
	
		
		public MenuItem(int ch,String text){
			id=ch;
			name=text;
		
		}
		
		public MenuItem(int ch,String string,Action action) {
			super();
			this.id=ch;
			this.name=string;
			this.action=action;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Action getAction() {
			return action;
		}

		public void setAction(Action action) {
			this.action = action;
		}

		public String toString() {
			return ""+id+"."+name;
		}
		
		
		public void actionPerformed() {	
			action.actionPerformed();
		}
		
		
		
	}


