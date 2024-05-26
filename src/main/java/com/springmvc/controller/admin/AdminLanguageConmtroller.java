package com.springmvc.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Language;
import com.springmvc.model.ResponseJSON;
import com.springmvc.service.impl.BookService;

@Controller
@RequestMapping(value = "/admin/dashboard/language")
public class AdminLanguageConmtroller {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/update")
	public ModelAndView updateView(HttpServletRequest request, @RequestParam("id") Integer id) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				if (id == null)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/update-language");
				mav.addObject("language", bookService.getLanguageById(id));
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addLanguage(HttpServletRequest request, @RequestBody String jsonString) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return ResponseJSON.badRequest("You cannot does this action");
				
				JSONObject jsonObject = new JSONObject(jsonString);
				
				if (!jsonObject.has("language"))
					return ResponseJSON.badRequest("Missing data from client");
				
				Language language = new Language();
				language.setName(jsonObject.getString("language"));
				language.setCreatedBy((String) session.getAttribute("username"));
				
				int languageId = bookService.insertLanguage(language);
				if (languageId > 0)
					return ResponseJSON.ok("Save language success");
						
				return ResponseJSON.serverError("Cannot save language, server error");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<?> updateCategory(HttpServletRequest request, @RequestBody String jsonString) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return ResponseJSON.badRequest("You cannot does this action");
				
				JSONObject jsonObject = new JSONObject(jsonString);
				
				if (!jsonObject.has("language") || !jsonObject.has("id"))
					return ResponseJSON.badRequest("Missing data from client");
				
				Language language = bookService.getLanguageById(jsonObject.getInt("id"));
				language.setName(jsonObject.getString("language"));
				language.setModifiedBy((String) session.getAttribute("username"));
				
				boolean isSuccess = bookService.updateLanguage(language);
				
				if (isSuccess)
					return ResponseJSON.ok("Save language success");
				
				return ResponseJSON.serverError("Cannot save language, server error");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteCategory(HttpServletRequest request, @RequestParam("id") Integer id) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return ResponseJSON.badRequest("You cannot does this action");
				
				if (id == null)
					return ResponseJSON.badRequest("Missing data from client");
				
				bookService.deleteLanguage(id);
				return ResponseJSON.ok("Delete language success");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseJSON.serverError(e.getMessage());
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
}
