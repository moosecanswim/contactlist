package me.moosecanswim.contactlist.Controller;

import me.moosecanswim.contactlist.Model.Contact;
import me.moosecanswim.contactlist.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainControl {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/")
    public String listAll(Model model){
        model.addAttribute("allContacts",contactRepository.findAll());
        return "listAll";
    }
    @RequestMapping("/add")
    public String addContact(Model model){
        model.addAttribute("aContact", new Contact());
        return "contactForm";
    }
    @RequestMapping("/process/{id}")
    public String processContact(@PathVariable("id") long id,@Valid Contact aContact, BindingResult result){
        if(result.hasErrors()){
            return "contactForm";
        }
        contactRepository.save(aContact);
        return "redirect:/";
    }
    @RequestMapping("/update/{id}")
    public String updateContact(@PathVariable("id") long id, Model model){
        model.addAttribute("aContact", contactRepository.findOne(id));
        return "contactForm";
    }
    @RequestMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") long id){
        contactRepository.delete(id);
        return "redirect:/";
    }




}
