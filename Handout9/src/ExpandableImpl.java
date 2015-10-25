
public class ExpandableImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpandableArray myList = new ExpandableArray();
		myList.set(14, "Bob");
		myList.set(21, "Sally");
		myList.set(29, "Saly");

		String value = (String) myList.get(14); // Note the cast
		if (value != null) {
		System.out.println("Got value: " + value);
		}
	}

}
