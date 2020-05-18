package com.persona.persons.controller;

import com.persona.persons.domain.Person;
import com.persona.persons.service.PersonService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;


// får inte vara restcontroller
@Controller
public class PersonController {
    private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //metod för att visa startsidan. ( index) göra en string metod som returnernar index.

    @GetMapping ("/")// går med request mapping också
    public String viewHomeP(Model model){
        List<Person> personLists=personService.listAll();
        model.addAttribute("listPersons", personLists);
        return "index"; }

        @GetMapping("/new")
        public String showNewPersonPage(Model model) {
        Person person=new Person();
        model.addAttribute("theperson",person);
        return "new_person";
        }

        // bindingresult kollar om koppling gått rätt till


    @PostMapping("/save")
        public String savePerson(Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            //returnerar fel sidan error
            return "error";
        // annars kommer vi till save person
        personService.save(person);
        // här gör vi en redirect, för vi vill uppdatera startsidan så den nya person läggs till på startsidan, redirect till vår hemurl som visar alla personer
        return "redirect:/";
        }

        @GetMapping("/edit/{id}")
        public String showEditPage(@PathVariable long id, Model model)
        {
      Optional<Person>person=personService.findPerson(id);
      if (person.isPresent())
    {model.addAttribute("person_to_edit",person.get());
          return "edit_person";}
          else
              return "error";
    }

        @GetMapping("/delete/{id}")
public String deletePerson(@PathVariable long id){
            {personService.deletePerson(id);}


        return "redirect:/";
}
}
