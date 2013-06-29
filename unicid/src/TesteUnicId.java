import java.util.UUID;


public class TesteUnicId {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			UUID idOne = UUID.randomUUID();
			UUID id2 = UUID.randomUUID();
			System.out.println(idOne.equals(id2));
			System.out.println(idOne);
			System.out.println(id2);
		}

	}

}
