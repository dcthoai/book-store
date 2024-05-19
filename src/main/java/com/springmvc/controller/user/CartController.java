package com.springmvc.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Book;
import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;
import com.springmvc.model.Pair;
import com.springmvc.service.impl.CartService;
import com.springmvc.service.impl.MediaService;

@Controller("userCartController")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private MediaService mediaService;

	@GetMapping(value = "/cart")
	public ModelAndView shoppingCart(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/cart");
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			String username = (String) session.getAttribute("username");
			Boolean isUserAuthenticated = (Boolean) session.getAttribute("isAuthenticated");
			
			if (username != null && isUserAuthenticated) {
				Cart cart = cartService.getCartByUsername(username);
					
				if (cart != null) {
					List<Pair<Book, CartProduct>> cartProductPairs = cartService.getAllCartProducts(cart.getId());
				 	
					mav.addObject("mediaService", mediaService);
					mav.addObject("quantityCart", cart.getQuantity());
					mav.addObject("cartProductPairs", cartProductPairs);
				}
			}
		}
		
		return mav;
	}
	
	private boolean updateCartQuantity(int cartId) {
		int quantityCart = cartService.countTotalQuantityCart(cartId);
		
		Cart cart = cartService.getCartById(cartId); 
		cart.setQuantity(quantityCart);
		
		boolean isUpdateCart = cartService.updateCart(cart);
	
		return isUpdateCart;
	}

	@PostMapping(value = "/cart/add")
	public ResponseEntity<?> addToCart(@RequestBody String jsonString, HttpServletRequest request) {
	    return null;
	}

	@PostMapping(value = "/cart/update")
	public ResponseEntity<?> updateCartProduct(@RequestBody String jsonString, HttpServletRequest request) {

		return null;
	}

	@PostMapping(value = "/cart/delete")
	public ResponseEntity<?> deleteCartProduct(@RequestBody String jsonString, HttpServletRequest request) {

		return null;
	}
}