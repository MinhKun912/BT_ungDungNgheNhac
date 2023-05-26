package controller;

import entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ISongService;

import java.io.File;
import java.io.IOException;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/")
    public ModelAndView listCustomers(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", songService.findAll());
        return modelAndView;
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("mp3") MultipartFile image, Model model) throws IOException {
        String uploadPath = "C:\\Users\\MinhKun\\Desktop\\nghenhac\\src\\main\\resources\\mp3";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = image.getOriginalFilename();
        FileCopyUtils.copy(image.getBytes(),new File(uploadPath+File.separator + fileName));
        model.addAttribute("fileName",fileName);
        return "index";
    }
}
