package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vn.com.iviettech.service.FileUploadService;

@Controller
@RequestMapping("files")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/add")
    public String upload(@RequestParam("imageFile") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String imagePath = fileUploadService.uploadFile(imageFile);
                System.out.println(imagePath);
            }

        } catch (Exception e) {
        }

        return "file-upload";
    }

    @GetMapping("/add")
    public String showUploadForm() {
        return "file-upload";
    }
}
