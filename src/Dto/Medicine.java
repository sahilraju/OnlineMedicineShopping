package Dto;
 
public class Medicine {

	private final Integer id;

	private String name;

	private Double price;

	private Integer quantity;
 
	private String description; 

	public Medicine(Integer id, String name, Double price, Integer quantity, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() { 
		return price; 
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description; 
	}

	@Override
	public String toString() {
		return id+"\t"+name+"\t"+price+"\t"+quantity+"\t\t"+description+"\n";
	} 
	 
	

}
