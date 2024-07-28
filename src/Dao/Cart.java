package Dao;

import java.util.ArrayList;
import java.util.List;

import Dto.Medicine;
import Dto.MedicineCart;

public class Cart {
	
	private List<MedicineCart> userCart = new ArrayList<>();
	
	public void addToCart(Medicine medicine) {
		
		MedicineCart mCart = new MedicineCart();
		mCart.setId(medicine.getId());
		mCart.setName(medicine.getName()); 
		mCart.setPrice(medicine.getPrice());
		
		userCart.add(mCart); 
		 
	}
	
	public List<MedicineCart> getCartDetails() { 
		
		return userCart; 
		
	}

}
     