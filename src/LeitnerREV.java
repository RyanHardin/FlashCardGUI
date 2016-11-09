
public class LeitnerREV {

	public static String Question;
	public static String Answer;
	public Box chosen;

	public LeitnerREV(Box one, Box two, Box three) {

		int randBox = (int) (Math.random() * (2 - 0 + 1));
		if (randBox == 0) {
			this.chosen = one;
		}
		if (randBox == 1) {
			if (Box.size(two) > 0) {
				this.chosen = two;
			} else {
				this.chosen = one;
			}
		}

		if (randBox == 2) {
			if (Box.size(three) > 0) {
				this.chosen = three;
			} else {
				this.chosen = one;
			}
		}

	}

	public static NoteCard pickCard(LeitnerREV a) {
		int random = (int) (Math.random() * Box.size(a.chosen));

		if (random > Box.size(a.chosen)) {
			random = random - 1;
		}

		NoteCard need = Box.getCard(a.chosen, random);
		System.out.println("Card chosen: " + need);
		return need;

	}

	public static String getQuestion(NoteCard a) {
		String question = a.getChallenge();
		System.out.println(question);

		return question;

	}

	public static String getAnswer(NoteCard a) {
		String answer = a.getResponse();
		System.out.println(answer);

		return answer;

	}

	public static void checkAnswer(String a, String b)

	{

		a.toLowerCase();

		b.toLowerCase();

		int x = a.compareTo(b);

		if (x != 0)
			System.out.print("Wrong");

		else
			System.out.print("Correct!");

	}
	public static LeitnerREV createLeitner(Box box1, Box box2, Box box3) { 
		LeitnerREV run = new LeitnerREV(box1, box2, box3);
		return run;
	}
}