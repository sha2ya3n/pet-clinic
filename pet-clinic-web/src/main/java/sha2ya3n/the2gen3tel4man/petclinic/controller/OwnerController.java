package sha2ya3n.the2gen3tel4man.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sha2ya3n.the2gen3tel4man.petclinic.services.OwnerService;

@Slf4j
@Controller
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "index", "templates/index.html"})
    public String listOfOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        log.info("log for model ${}", model);
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        log.info("findOwners ${}", model);
        return "owners/findowner";
    }
}
