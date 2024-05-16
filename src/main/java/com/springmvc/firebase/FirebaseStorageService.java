package com.springmvc.firebase;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class FirebaseStorageService {
	
	@Autowired
	private Storage firebaseStorage;
	private String bucketName = "bookstore-47b38.appspot.com";

	public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName).build();
        firebaseStorage.create(blobInfo, file.getBytes());
        return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
    }
}
