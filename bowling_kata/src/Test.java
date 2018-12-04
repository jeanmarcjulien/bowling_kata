import java.util.Scanner;

class Test {
	
	public static void main(String args[]) {
		
		//Set up needed variables
		Scanner reader = new Scanner(System.in);
		LinkedPositionalList d = new LinkedPositionalList();
		int sum=0;
		char c;
		
		//prompt the user to enter a series of rolls
		System.out.println("Please enter a series of rolls: ");
		String roll = reader.nextLine();
		
		//iterate through each character of the user's input and add to linkedlist
		for(int i = 0;i<roll.length();i++) {
			
			//determine each type of roll
			c = roll.charAt(i);
			if(c=='x') {
				d.addLast(10);
			}else if(c=='/') {
				d.addLast(-1);
			}else if(c=='-') {
				d.addLast(0);
			}else if(c==' '){
			}else {
				//if roll is not special character, add as integer
				d.addLast(Integer.parseInt(String.valueOf(c)));
			}
		}
		
		//iterate through the linked list of rolls
		while(d.hasNext()) {
			d.next();
			
			//if the roll was a strike
			if (d.cursor.getData() == 10) {
				
				//add the current roll and the next 2 rolls
				sum = sum + (d.cursor.getData());
				sum = sum + (d.cursor.getNextNode().getData());
				sum = sum + (d.cursor.getNextNode().getNextNode().getData());
				
				//exit the loop if it's the 10th frame
				if(d.cursor.getNextNode().getNextNode() == d.last()) {
					break;
				}
				
			}else if(d.cursor.getData() <= 9) {// if it is not a strike
				
				if(d.cursor.getData() == -1) {//if it is a spare
					
					//add the current remaining pins and the next roll to the score
					sum = sum + (10-d.cursor.getPrevNode().getData());
					sum = sum + (d.cursor.getNextNode().getData());
				}else { 
					
					// if it is not a spare just add the current roll
					sum = sum+d.cursor.getData();
				}
				//exit the loop if it's the 10th frame
				if(d.cursor.getNextNode() == d.last()) {
					break;
				}	
			}
		}
		//print out the score
		System.out.println("The score is: "+sum);
	}
}
