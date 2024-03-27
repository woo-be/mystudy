package bitcamp.myapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

  public String upload(String bucketName, String path, MultipartFile multipartFile) throws Exception;
}
