package com.bntn.smartstore.controller;

import com.bntn.smartstore.model.Phone;
import com.bntn.smartstore.model.User;
import com.bntn.smartstore.service.PhoneService;
import com.bntn.smartstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private PhoneService phoneService;

    @RequestMapping("/searchByBrand")
    public String searchByBrand(@RequestParam("brand") String brand,
                                   Model model,
                                   Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }

        String classActiveBrand = "active" + brand;
        classActiveBrand = classActiveBrand.replaceAll("\\s+", "");
        classActiveBrand = classActiveBrand.replaceAll("&", "");
        model.addAttribute(classActiveBrand, true);

        List<Phone> phoneList = phoneService.findByBrand(brand);

        if (phoneList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "smartStore";
        }

        model.addAttribute("phoneList", phoneList);

        return "smartStore";
    }

    @RequestMapping("/searchPhone")
    public String searchPhone(@ModelAttribute("keyword") String keyword,
                             Principal principal,
                             Model model) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }

        List<Phone> phoneList = phoneService.blurrySearch(keyword);

        if (phoneList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "smartStore";
        }

        model.addAttribute("phoneList", phoneList);

        return "smartStore";
    }

}
