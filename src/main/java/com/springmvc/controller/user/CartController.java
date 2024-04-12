package com.springmvc.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.springmvc.service.user.impl.BookService;
import com.springmvc.service.user.impl.CartService;
import com.springmvc.service.user.impl.MediaService;

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
					Cart cart = cartService.getCartByUserId(customerId);
					
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

	@PostMapping(value = "/cart/add")
	public ResponseEntity<?> addToCart(@RequestBody String jsonString) {
	    try {
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Check data format from client
	        if (!jsonObject.has("bookId") || !jsonObject.has("cartId") || !jsonObject.has("quantity")) {
	            return ResponseEntity.badRequest().body(new JSONObject()
	                .put("success", false)
	                .put("message", "Missing required data attributes from client")
	                .toString());
	        }

	        CartProduct cartProduct = new CartProduct();
	        cartProduct.setBookId(jsonObject.getInt("bookId"));
	        cartProduct.setCartId(jsonObject.getInt("cartId"));
	        cartProduct.setQuantity(jsonObject.getInt("quantity"));

	        JSONObject response = new JSONObject();
	        int cartProductId = cartService.addCartProduct(cartProduct);
	        
	        if (cartProductId > 0) {
	            response.put("success", true);
	            return ResponseEntity.ok(response.toString());
	        } else {
	            response.put("success", false);
	            response.put("message", "Add cart product failure!");
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
	        }
	    } catch (JSONException e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().body(new JSONObject()
	            .put("success", false)
	            .put("message", "Exception when converting data to JSON")
	            .toString());
	    }
	}

	@PostMapping(value = "/cart/update")
	public ResponseEntity<?> updateCartProduct(@RequestBody String jsonString) {
		try {
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Check data format from client
	        if (!jsonObject.has("cartProductId") || !jsonObject.has("quantity")) {
	            return ResponseEntity.badRequest().body(new JSONObject()
	                .put("success", false)
	                .put("message", "Missing required data attributes from client")
	                .toString());
	        }

	        CartProduct cartProduct = new CartProduct();
	        cartProduct.setId(jsonObject.getInt("cartProductId"));
	        cartProduct.setQuantity(jsonObject.getInt("quantity"));

	        JSONObject response = new JSONObject();
	        boolean status = cartService.updateCartProduct(cartProduct);
	        
	        if (status) {
	            response.put("success", true);
	            return ResponseEntity.ok(response.toString());
	        } else {
	            response.put("success", false);
	            response.put("message", "Update cart product failure");
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
	        }
	    } catch (JSONException e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().body(new JSONObject()
	            .put("success", false)
	            .put("message", "Exception when converting data to JSON")
	            .toString());
	    }
	}

	@PostMapping(value = "/cart/delete")
	public ResponseEntity<?> deleteCartProduct(@RequestBody String jsonString) {
		try {
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Check data format from client
	        if (!jsonObject.has("cartProductId")) {
	            return ResponseEntity.badRequest().body(new JSONObject()
	                .put("success", false)
	                .put("message", "Missing required data attributes from client")
	                .toString());
	        }

	        JSONObject response = new JSONObject();
	        boolean status = cartService.deleteCartProduct(jsonObject.getInt("cartProductId"));
	        
	        if (status) {
	            response.put("success", true);
	            return ResponseEntity.ok(response.toString());
	        } else {
	            response.put("success", false);
	            response.put("message", "Delete cart product failure");
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
	        }
	    } catch (JSONException e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().body(new JSONObject()
	            .put("success", false)
	            .put("message", "Exception when converting data to JSON")
	            .toString());
	    }
	}
}