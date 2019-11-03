package com.bntn.smartstore.controller;

import com.bntn.smartstore.model.Phone;
import com.bntn.smartstore.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping("/add")
    public String addPhone(Model model) {
        Phone phone = new Phone();
        model.addAttribute("phone", phone);
        return "addPhone";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPhonePost(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);

        MultipartFile phoneImage = phone.getPhoneImage();

        try {
            byte[] bytes = phoneImage.getBytes();
            String name = phone.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("src/main/resources/static/image/phone/" + name));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:phoneList";
    }

    @RequestMapping("/phoneInfo")
    public String phoneInfo(@RequestParam("id") Long id, Model model) {
        Phone phone = phoneService.findOne(id);
        model.addAttribute("phone", phone);

        return "phoneInfo";
    }

    @RequestMapping("/updatePhone")
    public String updatePhone(@RequestParam("id") Long id, Model model) {
        Phone phone = phoneService.findOne(id);
        model.addAttribute("phone", phone);

        return "updatePhone";
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.POST)
    public String updatePhonePost(@ModelAttribute("phone") Phone phone, HttpServletRequest request) {
        phoneService.save(phone);

        MultipartFile phoneImage = phone.getPhoneImage();

        if (!phoneImage.isEmpty()) {
            try {
                byte[] bytes = phoneImage.getBytes();
                String name = phone.getId() + ".png";

                Files.delete(Paths.get("src/main/resources/static/image/phone/" + name));

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("src/main/resources/static/image/phone/" + name));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/phone/phoneInfo?id="+phone.getId();
    }

    @RequestMapping("/phoneList")
    public String phoneList(Model model) {
        List<Phone> phoneList = phoneService.findAll();

        model.addAttribute("phoneList", phoneList);

        return "phoneList";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@ModelAttribute("id") String id,
                         Model model) {
        phoneService.removeOne(Long.parseLong(id.substring(8)));
        List<Phone> phoneList = phoneService.findAll();
        model.addAttribute("phoneList", phoneList);

        return "redirect:/admin/phone/phoneList";
    }

}
