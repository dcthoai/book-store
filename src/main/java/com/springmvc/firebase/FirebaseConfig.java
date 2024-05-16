package com.springmvc.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

	@Bean
    public FirebaseApp firebaseApp() throws IOException {
        String databaseUrl = "https://bookstore-47b38-default-rtdb.asia-southeast1.firebasedatabase.app";
        String storageBucket = "bookstore-47b38.appspot.com";
        Resource resource = new ClassPathResource("/firebase/serviceAccountKey.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
                .setDatabaseUrl(databaseUrl)
                .setStorageBucket(storageBucket)
                .build();

        return FirebaseApp.initializeApp(options);
    }

	@Bean
	public Storage firebaseStorage(FirebaseApp firebaseApp) {
	    return StorageOptions.newBuilder()
	            .setProjectId(firebaseApp.getOptions().getProjectId())
	            .build()
	            .getService();
	}


    @Bean
    public FirebaseDatabase firebaseDatabase() throws IOException {
        return FirebaseDatabase.getInstance(firebaseApp());
    }
}
