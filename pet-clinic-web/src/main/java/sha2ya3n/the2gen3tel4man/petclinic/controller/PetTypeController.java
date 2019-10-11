package sha2ya3n.the2gen3tel4man.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetTypeService;

@Controller
@RequestMapping("petType")
public class PetTypeController {

    private PetTypeService petTypeService;

    @Autowired
    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String PetTypeList(Model model){
        model.addAttribute("pets", petTypeService.findAll());
        return "petType/index";
    }
}
