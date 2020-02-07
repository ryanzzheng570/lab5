package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBookRepository;


    @PostMapping("/newAB")
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping(value = "/addressBook")
    public AddressBook getAddressBook(@RequestParam("id") Integer id){
        return addressBookRepository.findById(id).orElse(null);
    }
}