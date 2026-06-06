package com.uploading.csvfile;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

record InnerUploadTestController(String filename) {}

@RestController
public class UploadTestController {

    @GetMapping("/upload-csv")
    public InnerUploadTestController getFile(@RequestParam String filename) {
        return new InnerUploadTestController(filename);
    }
    
}
