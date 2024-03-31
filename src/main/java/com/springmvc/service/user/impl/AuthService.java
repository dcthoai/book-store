package com.springmvc.service.user.impl;
//
//import java.util.Date;
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.springmvc.model.User;
//import com.springmvc.service.user.IAuthServive;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.SignatureException;
//import io.jsonwebtoken.UnsupportedJwtException;
//
//@Service
//public class AuthService implements IAuthServive{
//	private String _jwtKey = "E2ABD4E34E5E8352A1177";
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Override
//	public void register(User user) {
//		// Hash user's password
//        String hashedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hashedPassword);
//
//        // Set initial account status
//       // user.setAccountStatus("UNVERIFIED");  // Replace with your status logic
//
//        // Save user to database
//        userService.saveUser(user);
//
//        // Send confirmation email
////        sendConfirmationEmail(user);
//	}
//	
//	@Override
//	public String generateToken(User user) {
//		// Use JWT library to create a token
//		JwtBuilder builder = Jwts.builder()
//	            .setSubject(String.valueOf(user.getId()))
//	            .setIssuedAt(new Date(System.currentTimeMillis()))  // Set issued at time
//	            .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))  // Valid for 5 minutes
//	            .signWith(SignatureAlgorithm.HS256, _jwtKey);  // Sign with secure key
//
//	    return builder.compact();
//    }
//
//	@Override
//    public boolean isValidToken(String token, User user) {
//		try {
//	        Claims claims = Jwts.parser()
//	                .setSigningKey(_jwtKey)  // secure key
//	                .parseClaimsJws(token)
//	                .getBody();
//
//	        int userId = Integer.parseInt(claims.getSubject());
//	        return userId == user.getId() && claims.getExpiration().after(new Date());
//
//	    } catch (SignatureException ex) {
//	        ex.printStackTrace();
//	        return false;
//	    } catch (MalformedJwtException ex) {
//	    	ex.printStackTrace();
//	        return false;
//	    } catch (ExpiredJwtException ex) {
//	    	ex.printStackTrace();
//	        return false;
//	    } catch (UnsupportedJwtException ex) {
//	    	ex.printStackTrace();
//	        return false;
//	    } catch (IllegalArgumentException ex) {
//	    	ex.printStackTrace();
//	        return false;
//	    }
//    }
//
//	@Override
//	public void sendConfirmationEmail(User user) {
//		String token = generateToken(user);
//		String content = "Chào mừng " + user.getUsername() + ",\n\n" +
//	            "Bạn đã đăng ký thành công tài khoản trên hệ thống của chúng tôi.\n\n" +
//	            "Vui lòng nhấp vào liên kết sau để xác nhận tài khoản của bạn:\n\n" +
//	            "[link "+ token + " xác nhận]\n\n" +
//	            "Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!\n\n" +
//	            "Trân trọng,\n\n" +
//	            "Đội ngũ hỗ trợ";
//		String senderEmail = "cd.cskh.noreply@gmail.com";
//		// Generate a unique confirmation token for the user
//		// KBTFBHVZKP8RJ88SRAFSDJ9W
//
//	    Properties props = new Properties();
//	    props.put("mail.smtp.host", "smtp.gmail.com");
//	    props.put("mail.smtp.port", "587");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//
//	    Session session = Session.getInstance(props, new Authenticator() {
//	        @Override
//	        protected PasswordAuthentication getPasswordAuthentication() {
//	            return new PasswordAuthentication("cd.cskh.noreply@gmail.com", "qazx@noreply");
//	        }
//	    });
//
//	    try {
//	    	Message message = new MimeMessage(session);
//		    message.setFrom(new InternetAddress(senderEmail));
//		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
//		    message.setSubject("Xác nhận đăng ký tài khoản");
//		    message.setText(content);
//		    
//	        Transport.send(message);
//	    } catch (MessagingException e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	@Override
//	public void verifyAccount(String token, int userId) {
////		// Load user from database
////        User user = userService.findUserById(userId);
////
////        // Validate confirmation token
////        if (isValidToken(token, user)) {
////            // Set account status to verified
////            userService.saveUser(user);
////        } else {
////            
////        }
//	}
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.model.User;
import com.springmvc.service.user.IAuthServive;

@Service
public class AuthService implements IAuthServive{
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean isExistUser(String username, String email) {
		if (email == null && username == null)
			return false;
		
		if (email != null && email.equals("") == false) {
			if (userService.findUserByEmail(email) != null) {
				return true;
			}
		}

		if (username != null && username.equals("") == false) {
			if (userService.findUserByUsername(username) != null)
				return true;
	    }
	    
	    return false;
	}
	
	@Override
	public int register(User user) {
		String password = user.getPassword();
			
		// Encrypt password before save
		user.setPassword(password);
			
		int userId = userService.insertUser(user);
			
		return userId;
	}

	@Override
	public boolean login(User user) {
		try {
			User account = new User();
			
			if (user.getEmail() != null) {
				account = userService.findUserByEmail(user.getEmail());
			} 
			else if (user.getUsername() != null){
				account = userService.findUserByUsername(user.getUsername());
			}
			
			if (account != null) {
				return account.getPassword().equals(user.getPassword());
			}
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
//		return true;
	}
}