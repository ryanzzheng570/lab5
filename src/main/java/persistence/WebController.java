package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/list")
    public String addressBookSubmit(@RequestParam("id") Integer id, Model model){
        AddressBook ab = addressBookRepository.findById(id).orElse(null);
        model.addAttribute("addressBook", ab);
        return "addressBook";
    }
}