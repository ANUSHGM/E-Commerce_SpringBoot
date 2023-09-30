package ecommerceapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProductEntity")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pId ; 
	
	@Column(name = "pName")
	String pName;
	
	@Column(name = "status")
	String status; 
	
	@Column(name = "cost")
	Double cost; 
	
	@Column(name = "Category")
	String Category;

	
	
	public ProductEntity() {
	}


	public ProductEntity(int pId, String pName, String status, Double cost, String category) {
		this.pId = pId;
		this.pName = pName;
		this.status = status;
		this.cost = cost;
		this.Category = category;
	}
	
	

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	} 
	
}
