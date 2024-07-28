package Dao;

import java.util.HashMap;

import java.util.Map;
import Dto.Medicine;

public class MedicineStore {

	private final static Map<Integer, Medicine> medicine_store = new HashMap<>();

	public static Map<Integer, Medicine> storeMedicines() {

		Medicine m1 = new Medicine(1, "Paracetamol", 5.00, 100, "For fever and pain relief");
		Medicine m2 = new Medicine(2, "Amoxicillin", 10.00, 50, "Antibiotic for infections");
		Medicine m3 = new Medicine(3, "Loratadine", 7.50, 75, "Antihistamine for allergies");

		medicine_store.put(m1.getId(), m1);
		medicine_store.put(m2.getId(), m2);
		medicine_store.put(m3.getId(), m3);

		return medicine_store;

	}

	public static Map<Integer, Medicine> getMedicineStore() {
		return medicine_store;
	}

	public static Medicine getMedicine(Integer id) {

		return medicine_store.get(id);

	}

	public static void updateMedicineQuantity(Integer id) {

		Medicine medicine = medicine_store.get(id);

		int quantity = medicine.getQuantity() - 1;

		medicine.setQuantity(quantity);

		// System.out.println(medicine.getQuantity());

	}

}
