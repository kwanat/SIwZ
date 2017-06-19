package com.FirstSpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-11.
 */
@Entity public class Product
		implements Serializable {
	
	/**
	 * GUID
	 */
	private static final long serialVersionUID = 6810163679187813785L;
	
	/**
	 * Product ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    /*@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")*/
	//@Column(name = "PR_KEY")
	private int productId;
	
	/**
	 * Product name
	 */
	@NotEmpty(message = "The product name must not be null.")
	private String productName;
	/**
	 * Product category
	 */
	private String productCategory;
	/**
	 * Product description
	 */
	private String productDescription;
	/**
	 * Product price
	 */
	@Min(value = 0, message = "The product price must not be less than zero.")
	private double productPrice;
	/**
	 * Product condition
	 */
	private String productCondition;
	/**
	 * Product status
	 */
	private String productStatus;
	/**
	 * Product units
	 */
	@Min(value = 0, message = "The product unit must not be less than zero.")
	private int unitInStock;
	/**
	 * Product manufacturer
	 */
	@OneToOne
	@JoinColumn(name="manufacturerId")
	@JsonIgnore
	private Manufacturer productManufacturer;
	/**
	 * Product Image
	 */
	@Transient
	private MultipartFile productImage;
	/**
	 * Cart Items
	 */
	@OneToMany(mappedBy = "product", cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CartItem> cartItemList;
	/**
	 * Warehouse
	 */
	@OneToOne
	@JoinColumn(name="warehouseId")
	@JsonIgnore
	private Warehouse warehouse;
	
	/**
	 * getter for product ID
	 * @return product ID
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * setter for product ID
	 * @param productId product ID
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * getter for product name
	 * @return product name
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * setter for product name
	 * @param productName product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * getter for product category
	 * @return product category
	 */
	public String getProductCategory() {
		return productCategory;
	}
	
	/**
	 * setter for product category
	 * @param productCategory product category
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	/**
	 * getter for product description
	 * @return product description
	 */
	public String getProductDescription() {
		return productDescription;
	}
	
	/**
	 * setter for product description
	 * @param productDescription product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	/**
	 * getter for product price
	 * @return product price
	 */
	public double getProductPrice() {
		return productPrice;
	}
	
	/**
	 * setter for product price
	 * @param productPrice product price
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	/**
	 * getter for product condition
	 * @return product condition
	 */
	public String getProductCondition() {
		return productCondition;
	}
	
	/**
	 * setter for product condition
	 * @param productCondition product condition
	 */
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	
	/**
	 * getter for product status
	 * @return product status
	 */
	public String getProductStatus() {
		return productStatus;
	}
	
	/**
	 * setter for product status
	 * @param productStatus product status
	 */
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	/**
	 * getter for product status
	 * @return product status
	 */
	public int getUnitInStock() {
		return unitInStock;
	}
	
	/**
	 * setter for product units
	 * @param unitInStock product units
	 */
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	
	/**
	 * getter for manufacturer
	 * @return manufacturer
	 */
	public Manufacturer getProductManufacturer() {
		return productManufacturer;
	}
	
	/**
	 * setter for manufacturer
	 * @param productManufacturer manufacturer
	 */
	public void setProductManufacturer(Manufacturer productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	/**
	 * getter for image
	 * @return image
	 */
	public MultipartFile getProductImage() {
		return productImage;
	}
	
	/**
	 * getter for cart items
	 * @return
	 */
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	
	/**
	 * setter for cart items
	 * @param cartItemList cart items
	 */
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
	/**
	 * setter for image
	 * @param productImage image
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	/**
	 * getter for warehouse
	 * @return warehouse
	 */
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * setter for warehouse
	 * @param warehouse warehouse
	 */
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
