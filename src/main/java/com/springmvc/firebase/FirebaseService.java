
package com.springmvc.firebase;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Service
public class FirebaseService {

	@Autowired
	private FirebaseDatabase firebaseDatabase;

	public void saveUserToken(String username, String token) {
		DatabaseReference databaseReference = firebaseDatabase.getReference("user/token");

		databaseReference.child(username).setValue(token, null);
	}
	
	public CompletableFuture<String> getTokenByUsername(String username) {
	    DatabaseReference reference = firebaseDatabase.getReference().child("user/token");
	    CompletableFuture<String> future = new CompletableFuture<>();

	    reference.orderByKey().equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
	        @Override
	        public void onDataChange(DataSnapshot snapshot) {
	            if (snapshot.exists()) {
	                future.complete(snapshot.getValue(String.class));
	            } else {
	                future.complete(null); // Token do not exist
	            }
	        }

	        @Override
	        public void onCancelled(DatabaseError error) {
	            future.completeExceptionally(error.toException());
	        }
	    });

	    return future;
	}

	public void deleteUserToken(String username) {
		DatabaseReference reference = firebaseDatabase.getReference().child("user/token");
		
		if(username != null)
			reference.child(username).removeValue(null);
	}
}
