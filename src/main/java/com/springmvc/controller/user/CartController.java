package com.springmvc.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller("userCartController")
public class CartController {

	@GetMapping(value = "/cart")
	public ModelAndView shoppingCart() {
		ModelAndView mav = new ModelAndView("user/cart");
		
		return mav;
	}

	
//	
//	@PostMapping(value = "/cart/add")
//	public ResponseEntity<?> addToCart(@RequestBody String jsonString) {
//	    try {
//	        JSONObject jsonObject = new JSONObject(jsonString);
//
//	        // Check data format from client
//	        if (!jsonObject.has("bookId") || !jsonObject.has("cartId") || !jsonObject.has("quantity")) {
//	            return ResponseEntity.badRequest().body(new JSONObject()
//	                .put("success", false)
//	                .put("message", "Missing required data attributes from client")
//	                .toString());
//	        }
//
//	        CartProduct cartProduct = new CartProduct();
//	        cartProduct.setBookId(jsonObject.getInt("bookId"));
//	        cartProduct.setCartId(jsonObject.getInt("cartId"));
//	        cartProduct.setQuantity(jsonObject.getInt("quantity"));
//
//	        JSONObject response = new JSONObject();
//	        int cartProductId = cartService.addCartProduct(cartProduct);
//	        
//	        if (cartProductId > 0) {
//	            response.put("success", true);
//	            return ResponseEntity.ok(response.toString());
//	        } else {
//	            response.put("success", false);
//	            response.put("message", "Add cart product failure");
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
//	        }
//	    } catch (JSONException e) {
//	        e.printStackTrace();
//	        return ResponseEntity.badRequest().body(new JSONObject()
//	            .put("success", false)
//	            .put("message", "Exception when converting data to JSON")
//	            .toString());
//	    }
//	}
//
//	
//	@PostMapping(value = "/cart/update")
//	public ResponseEntity<?> updateCartProduct(@RequestBody String jsonString) {
//		try {
//	        JSONObject jsonObject = new JSONObject(jsonString);
//
//	        // Check data format from client
//	        if (!jsonObject.has("cartProductId") || !jsonObject.has("quantity")) {
//	            return ResponseEntity.badRequest().body(new JSONObject()
//	                .put("success", false)
//	                .put("message", "Missing required data attributes from client")
//	                .toString());
//	        }
//
//	        CartProduct cartProduct = new CartProduct();
//	        cartProduct.setId(jsonObject.getInt("cartProductId"));
//	        cartProduct.setQuantity(jsonObject.getInt("quantity"));
//
//	        JSONObject response = new JSONObject();
//	        boolean status = cartService.updateCartProduct(cartProduct);
//	        
//	        if (status) {
//	            response.put("success", true);
//	            return ResponseEntity.ok(response.toString());
//	        } else {
//	            response.put("success", false);
//	            response.put("message", "Update cart product failure");
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
//	        }
//	    } catch (JSONException e) {
//	        e.printStackTrace();
//	        return ResponseEntity.badRequest().body(new JSONObject()
//	            .put("success", false)
//	            .put("message", "Exception when converting data to JSON")
//	            .toString());
//	    }
//	}
//	
//	@PostMapping(value = "/cart/delete")
//	public ResponseEntity<?> deleteCartProduct(@RequestBody String jsonString) {
//		try {
//	        JSONObject jsonObject = new JSONObject(jsonString);
//
//	        // Check data format from client
//	        if (!jsonObject.has("cartProductId")) {
//	            return ResponseEntity.badRequest().body(new JSONObject()
//	                .put("success", false)
//	                .put("message", "Missing required data attributes from client")
//	                .toString());
//	        }
//
//	        JSONObject response = new JSONObject();
//	        boolean status = cartService.deleteCartProduct(jsonObject.getInt("cartProductId"));
//	        
//	        if (status) {
//	            response.put("success", true);
//	            return ResponseEntity.ok(response.toString());
//	        } else {
//	            response.put("success", false);
//	            response.put("message", "Delete cart product failure");
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
//	        }
//	    } catch (JSONException e) {
//	        e.printStackTrace();
//	        return ResponseEntity.badRequest().body(new JSONObject()
//	            .put("success", false)
//	            .put("message", "Exception when converting data to JSON")
//	            .toString());
//	    }
//	}
}