package com.FirstSpringProject.dao;

import com.FirstSpringProject.model.Cart;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by sicluceatlux on 2017-03-16.
 */

public interface CartDao {
	
	Cart getCartById (int cartId);
	
	Cart validate(int cartId) throws
							  IOException;
	
	void update(Cart cart);
}

