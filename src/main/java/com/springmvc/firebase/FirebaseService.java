
package com.springmvc.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Service
public class FirebaseService {

	@Autowired
	private FirebaseDatabase firebaseDatabase;

	public void saveUserToken(String username, String token) {
		DatabaseReference databaseReference = firebaseDatabase.getReference("user/token");

		databaseReference.child(username).setValue(token, null);
	}
}
