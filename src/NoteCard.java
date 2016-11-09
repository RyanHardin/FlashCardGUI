
public class NoteCard {

	public String challenge;
	public static String response;

	public String front;
	public String back;

	public NoteCard(String front1, String back2) {
		// determines which side of the card will be the challenge and which
		// will be the response	
		
		front = front1;
		back = back2;	
	}

	@Override
	public String toString() {
		// return "The challenge:" + challenge + " " + "The response: " +
		// response;
		return "The Front: " + front + " " + "The Back: " + back;
	}

	public String getChallenge() {
		// returns either the front or back of the card
		challenge = front;
		return challenge;
	}

	public String getResponse() {
		// returns the front or back of the card based on what is in challenge
		response = back;
		return response;
	}

	public static void main(String[] args) {
		NoteCard test = new NoteCard("Ryan", "Hardin");

		System.out.println("The challenge: " + test.getChallenge());
		System.out.println("The response: " + test.getResponse());
	}
}
