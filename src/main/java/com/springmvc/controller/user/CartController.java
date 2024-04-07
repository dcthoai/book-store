package com.springmvc.controller.user;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.CartProduct;

@Controller("userCartController")
public class CartController {
	
	@RequestMapping(value = "/user/cart", method = RequestMethod.GET)
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