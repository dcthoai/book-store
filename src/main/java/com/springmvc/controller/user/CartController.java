package com.springmvc.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

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
import com.springmvc.model.ResponseJSON;
import com.springmvc.service.impl.BookService;
import com.springmvc.service.impl.CartService;
import com.springmvc.service.impl.MediaService;

@Controller("userCartController")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MediaService mediaService;

	@GetMapping(value = "/cart")
	public ModelAndView shoppingCart(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/cart");
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			Integer customerId = (Integer) session.getAttribute("customerId");
			Boolean isUserAuthenticated = (Boolean) session.getAttribute("isUserAuthenticated");
			
			if (isUserAuthenticated != null && isUserAuthenticated) {
				if (customerId != null && customerId > 0) {
					Cart cart = cartService.getCartByCustomerId(customerId);
					
					if (cart != null) {
						List<Pair<Book, CartProduct>> cartProductPairs = cartService.getAllCartProducts(cart.getId());
					 	
						mav.addObject("mediaService", mediaService);
						mav.addObject("bookService", bookService);
						mav.addObject("quantityCart", cart.getQuantity());
						mav.addObject("cartProductPairs", cartProductPairs);
					}
				}
			}
		}
		
		return mav;
	}
	
	private int updateCartQuantity(HttpServletRequest request) {
		 HttpSession session = request.getSession(false);
		 
		 if (session != null) {
			 try {
				 int cartId = (Integer) session.getAttribute("cartId");
				 int quantityCart = cartService.countTotalQuantityCart(cartId);
				 Cart cart = cartService.getCartById(cartId);
				 
				 System.out.println("new quantity cart:" + quantityCart);
				 
				 cart.setQuantity(quantityCart);
				 if (cartService.updateCart(cart)) {
					 session.setAttribute("quantityCart", quantityCart);
					 
					 return 1;
				 }
				 
				 return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		 }
		 return 0;
	}

	@PostMapping(value = "/cart/add")
	public ResponseEntity<?> addToCart(@RequestBody String jsonString, HttpServletRequest request) {
	    try {
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Check data format from client
	        if (!jsonObject.has("bookId") || !jsonObject.has("quantity")) {
	            return new ResponseJSON(false, "Missing required data attributes from client.").badRequest();
	        }

	        HttpSession session = request.getSession(false);
	        
	        if (session != null) {
	        	if ((Boolean) session.getAttribute("isUserAuthenticated")) {
	        		int customerId = (Integer) session.getAttribute("customerId");
	        		Cart cart = cartService.getCartByCustomerId(customerId);
	        		
	        		if (cart != null) {
	        			CartProduct cartProduct = new CartProduct();
	        			cartProduct.setCartId(cart.getId());
	        	        cartProduct.setBookId(jsonObject.getInt("bookId"));
	        	        cartProduct.setQuantity(jsonObject.getInt("quantity"));
	        	        
	        	        int cartProductId = cartService.addCartProduct(cartProduct);
	        	        
	        	        if (cartProductId > 0 && updateCartQuantity(request) > 0)
	        	        	return new ResponseJSON(true, "Successful!").ok();
	        	        
	        	        return new ResponseJSON(false, "Add cart product failure, server error.").serverError(); 
	        		}
	        		
	        		return new ResponseJSON(false, "Can not create a customer cart, server error.").serverError();
	        	}
	        	
	        	return new ResponseJSON(false, "User was not authenticated! Please login again.").badRequest();
	        }
	        	
	        return new ResponseJSON(false, "Not found session! Please login again.").badRequest();
	        
	    } catch (JSONException e) {
	        e.printStackTrace();
	        return new ResponseJSON(false, "Exception when converting data to JSON!").badRequest();
	    }
	}

	@PostMapping(value = "/cart/update")
	public ResponseEntity<?> updateCartProduct(@RequestBody String jsonString, HttpServletRequest request) {
		try {
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Check data format from client
	        if (!jsonObject.has("cartProductId") || !jsonObject.has("quantity")) {
	        	return new ResponseJSON(false, "Missing required data attributes from client.").badRequest();
	        }

	        CartProduct cartProduct = new CartProduct();
	        cartProduct.setId(jsonObject.getInt("cartProductId"));
	        cartProduct.setQuantity(jsonObject.getInt("quantity"));

	        boolean status = cartService.updateCartProduct(cartProduct);
	        
	        if (status && updateCartQuantity(request) > 0)
	        	return new ResponseJSON(true, "Successful!").ok();
	        	
	        return new ResponseJSON(false, "Update cart product failure! Server error.").serverError();
	        
	    } catch (JSONException e) {
	        e.printStackTrace();
	        return new ResponseJSON(false, "Exception when converting data to JSON!").badRequest();
	    }
	}

	@PostMapping(value = "/cart/delete")
	public ResponseEntity<?> deleteCartProduct(@RequestBody String jsonString, HttpServletRequest request) {
		try {
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Check data format from client
	        if (!jsonObject.has("cartProductId")) {
	        	return new ResponseJSON(false, "Missing required data attributes from client.").badRequest();
	        }

	        boolean status = cartService.deleteCartProduct(jsonObject.getInt("cartProductId"));
	        
	        if (status && updateCartQuantity(request) > 0) 
	        	return new ResponseJSON(true, "Successful!").ok();
	        	
	        return new ResponseJSON(false, "Delete cart product failure! Server error.").serverError();

	    } catch (JSONException e) {
	        e.printStackTrace();
	        return new ResponseJSON(false, "Exception when converting data to JSON!").badRequest();
	    }
	}
}