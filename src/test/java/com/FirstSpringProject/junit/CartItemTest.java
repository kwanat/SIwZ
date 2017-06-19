package com.FirstSpringProject.junit;
import java.math.BigDecimal;

import com.FirstSpringProject.model.CartItem;
import com.FirstSpringProject.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by sicluceatlux on 2017-06-13.
 */

public class CartItemTest {
	private CartItem cartItem;
	@Before
	public void setup() {
		cartItem = new CartItem();
	}
	@Test
	public void cartItem_total_price_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
		Product testProduct = new Product();
		testProduct.setProductPrice(123);
		cartItem.setProduct(testProduct);
		double totalPrice = cartItem.getTotalPrice();
		
		Assert.assertEquals(testProduct.getProductPrice(), totalPrice, 0.01);
	}
}