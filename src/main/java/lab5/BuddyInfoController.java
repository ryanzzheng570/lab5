package lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuddyInfoController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping(value = "/getBuddy")
    public BuddyInfo getBuddy(@RequestParam("abId") Integer abId, @RequestParam("buddyId") Integer buddyId) {
        AddressBook addressBook = addressBookRepository.findById(abId).orElse(null);
        return addressBook.findById(buddyId);
    }

    @PostMapping(value = "/addBuddy")
    public BuddyInfo addBuddy(@RequestParam("abId") Integer abId, @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,@RequestParam("phoneNumber") String phoneNumber,
                              @RequestParam("address")String address) {
        AddressBook addressBook = addressBookRepository.findById(abId).orElse(null);
        BuddyInfo newBuddy = new BuddyInfo(firstName, lastName, phoneNumber, address);
        addressBook.addNewBuddy(newBuddy);
        addressBookRepository.save(addressBook);
        return newBuddy;
    }

    @DeleteMapping(value = "/buddy")
    public BuddyInfo removeBuddy(@RequestParam("id") Integer id, @RequestParam("buddyId") Integer buddyId){
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        BuddyInfo buddyInfo = addressBook.findById(buddyId);
        addressBook.removeBuddy(buddyInfo);
        addressBookRepository.save(addressBook);
        return buddyInfo;
    }
}