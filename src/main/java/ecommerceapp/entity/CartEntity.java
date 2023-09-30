package ecommerceapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CartEntity1")
public class CartEntity {

	@Id
	int CartItemId;
	
	@Column(name = "CartItemName")
	String CartItemName;
	
	@Column(name = "CartItemStatus")
	String CartItemStatus; 

	@Column(name = "CartItemCost")
	Double CartItemCost;

	@Column(name = "Category")
	String Category ;
	
	@Column(name = "ItemCount")
	int count;
	
	

	
	public CartEntity() {
	}

	

	public CartEntity(int cartItemId, String cartItemName, String cartItemStatus, Double cartItemCost, String category
			,int count) {
		this.CartItemId = cartItemId;
		this.CartItemName = cartItemName;
		this.CartItemStatus = cartItemStatus;
		this.CartItemCost = cartItemCost;
		this.Category = category;
		this.count = count;
	}

	public int getCartItemId() {
		return CartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.CartItemId = cartItemId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCartItemName() {
		return CartItemName;
	}

	public void setCartItemName(String cartItemName) {
		this.CartItemName = cartItemName;
	}

	public String getCartItemStatus() {
		return CartItemStatus;
	}

	public void setCartItemStatus(String cartItemStatus) {
		this.CartItemStatus = cartItemStatus;
	}

	public Double getCartItemCost() {
		return CartItemCost;
	}

	public void setCartItemCost(Double cartItemCost) {
		this.CartItemCost = cartItemCost;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	} 
	
	
	
	
	
}
