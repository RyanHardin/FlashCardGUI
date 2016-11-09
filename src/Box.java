import java.util.LinkedList;
import java.util.ListIterator;

public class Box {

	public LinkedList<NoteCard> data;

	public Box() {
		this.data = new LinkedList<NoteCard>();
	}

	public Box addCard(NoteCard a) {
		Box one = this;

		one.data.add(a);

		return one;

	}
	
	public Box removeCard(int index) {
		Box one = this;
		one.data.remove(index);
		 
		return one;
	}
	
	public static int size(Box r) {
		int size = r.data.size();
		return size;
	}
	
	public Box Iterator(int index) {
		Box one = this;
		ListIterator<NoteCard> listIterator = one.data.listIterator(0);
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
		 
		return one;
	}

	public static NoteCard getCard(Box r, int index) {

		NoteCard answer = r.data.get(index);

		return answer;
	}

	public static String listBox(Box a, int index){
		
		ListIterator itr = a.data.listIterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	
		return a.toString();
	}


	public static void main(String[] args) {
		NoteCard test = new NoteCard("Ryan", "Hardin");
		Box box1 = new Box();
		box1.addCard(test);
		
		//listBox(box1,0);
	}
}
