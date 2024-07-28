package Controller_Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Dao.Cart;
import Dao.MedicineStore;
import Dao.UserStore;
import Dto.Medicine;
import Dto.MedicineCart;
import Dto.User;

public class HomePage {
	
	private Cart userCart; 

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		HomePage homePage = new HomePage();

		int choice;

		while (true) {

			System.out.println("\n===== Online Medical Shopping System =====");

			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Browse Medicines");
			System.out.println("4. View Cart");
			System.out.println("5. Checkout");
			System.out.println("6. Exit");

			System.out.print("\nEnter your choice: ");
			choice = input.nextInt();

			if (choice < 1 || choice > 6) {
				System.out.println("Not a valid choice selected do you want to select again");
				System.out.print("Enter y to continue or n to close: ");
				char yn = input.next().charAt(0);

				if (yn == 'n') {
					System.out.println("thank you");
					break;
				}
			}
			if (choice == 1) {

				homePage.login();

			} else if (choice == 2) {

				homePage.register();

			} else if (choice == 3) {

				homePage.displayAllMedicines();

			} else if (choice == 4) {

				homePage.viewCart(); 
				
			} else if(choice == 5) {
				
				homePage.checkOut(); 
				
			}else if (choice == 6) {
				System.out.println("\nThanks for using Online Medicine Shopping System!"); 
				break; 
			}
		} 
		input.close();
	}

	public void register() {

		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter username: ");
		String userName = input.nextLine();

		System.out.println("Enter password: ");
		String password = input.nextLine();

		System.out.println("Enter email: ");
		String email = input.nextLine();

		UserStore.userDetailsStore(userName, password, email);

		System.out.println("\nRegistration successful you can now login\n");

	}

	public void login() {

		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter username: ");
		String userName = input.nextLine();

		System.out.println("Enter password: ");
		String password = input.nextLine();

		User user = UserStore.getUser(userName);

		try {

			if (userName.equals(user.getUserName()) && password.equals(user.getPassword()))
				System.out.println("\nLogin Successful\n");

		} catch (NullPointerException e) { 
			System.out.println("\nInvalid Credentials\n");
		}

	}

	public void displayAllMedicines() {

		Scanner input = new Scanner(System.in);

		MedicineStore.storeMedicines();

		Map<Integer, Medicine> medicines = MedicineStore.getMedicineStore();

		System.out.println("ID     |  Name     |  Price($)  |  Quantitty  |  Description");

		Set<Integer> set = medicines.keySet();

		Iterator<Integer> keys = set.iterator();

		while (keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(medicines.get(key));
		}

		System.out.print("Enter the ID of the Medicine to add to cart (0 to exit): ");
		int id = input.nextInt();

		if (id != 0) {

			Medicine medicine = MedicineStore.getMedicine(id);
			
			userCart = new Cart(); 

			userCart.addToCart(medicine); 

			MedicineStore.updateMedicineQuantity(id);

			System.out.println(medicine.getName() + " added to cart\n");

			return;
		}

		System.out.println("Exit Done\n");

	}

	public void viewCart() {

		List<MedicineCart> medicines = userCart.getCartDetails(); 

		System.out.println("\n======= Shopping Cart =======");
		System.out.println("ID  |    Name    |  Price($) ");

		for (MedicineCart medicine : medicines) {

			System.out.println(medicine.getId() + "\t" + medicine.getName() + "\t" + medicine.getPrice());

		}

	}
	
	public void checkOut() {
		
		List<MedicineCart> medicines = userCart.getCartDetails();
		
		double totalAmount = 0;
		
		for (MedicineCart medicine : medicines) {

			totalAmount += medicine.getPrice(); 
			
		}
		
		System.out.println("Order confirmed! Total amount: $"+totalAmount); 
		
	}

}
