package com.springmvc.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.SlideRequest;
import com.springmvc.model.Media;
import com.springmvc.model.ResponseJSON;
import com.springmvc.model.Slide;
import com.springmvc.service.impl.MediaFileService;
import com.springmvc.service.impl.MediaService;
import com.springmvc.service.impl.SlideService;

@Controller
@RequestMapping(value = "/admin/dashboard/slide")
public class AdminSlideController {
	
	@Autowired
	private SlideService slideService;
	
	@Autowired
	private MediaService mediaService;
	
	@Autowired
	private MediaFileService mediaFileService;
	
	@GetMapping
	public ModelAndView slide(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/slide");
				mav.addObject("slides", slideService.getAllSlides());
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@GetMapping(value = "/add")
	public ModelAndView addSlideView(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/add-slide");
				mav.addObject("slides", slideService.getAllSlides());
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateSlideView(HttpServletRequest request, @RequestParam("id") Integer slideId) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				if (slideId == null)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/edit-slide");
				mav.addObject("slide", slideService.getById(slideId));
				mav.addObject("mediaService", mediaService);
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
    @PostMapping(value = "/add")
    public ResponseEntity<?> addSlide(HttpServletRequest request,
    								  @ModelAttribute SlideRequest slideRequest) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				Slide slide = new Slide();
				slide.setCaption(slideRequest.getCaption());
				slide.setContent(slideRequest.getContent());
				slide.setLink(slideRequest.getLink());
				slide.setCreatedBy((String) session.getAttribute("username"));
				
				if (mediaFileService.isUploadFile(slideRequest.getThumbnail())) {
					String path = mediaFileService.saveFile(slideRequest.getThumbnail());
					Media media = new Media();
					media.setPath(path);
					int thumbnailId = mediaService.insertMedia(media);
				
					if (thumbnailId > 0) {
						slide.setThumbnailId(thumbnailId);
						
						int slideId = slideService.insertSlide(slide);
						
						if (slideId > 0)
							return ResponseJSON.ok("Save slide success");
						
						return ResponseJSON.serverError("cannot save slide, server error");
					}
					
					return ResponseJSON.serverError("Cannot save slide thumbnail");
				}
				
				return ResponseJSON.badRequest("Missing thumbnail from client");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseJSON.badRequest(e.getMessage());
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
    
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateSlide(HttpServletRequest request,
    									@ModelAttribute SlideRequest slideRequest) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				Slide slide = slideService.getById(slideRequest.getId());
				
				if (slide == null) 
					return ResponseJSON.badRequest("Data invalid");
						
				if (slideRequest.getCaption() != null)
					slide.setCaption(slideRequest.getCaption());
				
				if (slideRequest.getContent() != null)
					slide.setContent(slideRequest.getContent());
				
				if (slideRequest.getLink() != null)
					slide.setLink(slideRequest.getLink());
				
				if (mediaFileService.isUploadFile(slideRequest.getThumbnail())) {
					String path = mediaFileService.saveFile(slideRequest.getThumbnail());
					Media media = new Media();
					media.setPath(path);
					int thumbnailId = mediaService.insertMedia(media);
				
					if (thumbnailId > 0)
						slide.setThumbnailId(thumbnailId);
					else
						return ResponseJSON.serverError("Cannot save slide thumbnail");
				} else 
					return ResponseJSON.badRequest("Missing thumbnail from client");
				
				slide.setModifiedBy((String) session.getAttribute("username"));
				boolean isSuccess = slideService.updateSlide(slide);
				
				if (isSuccess)
					return ResponseJSON.ok("Update slide success");
				
				return ResponseJSON.serverError("Cannot update slide, server error");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseJSON.badRequest(e.getMessage());
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
    
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteSlide(HttpServletRequest request, @RequestParam("id") Integer slideId) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				if (slideId == null)
					return ResponseJSON.badRequest("Missing data from client");
				
				slideService.deleteSlide(slideId);
				
				return ResponseJSON.ok("Delete slide success");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseJSON.badRequest(e.getMessage());
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
}
