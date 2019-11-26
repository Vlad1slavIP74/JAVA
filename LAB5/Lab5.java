public class Lab5 {

	

	public static void main(String[]args) {
		String artk = "Resizable-array implementation of the List interface."+"\n"+
	" Implements all optional List operations, and permits all elements, including null."+"\n"
	+ " In addition to implementing the List interface, ArrayList provides methods to manipulate the size of the array that is used internally to store the List.";
		Article art = new Article(artk);
		System.out.println(art);
		
		art.Replace(3, "OwOUwU");
		System.out.println(art);
	}
	
	
	
}
