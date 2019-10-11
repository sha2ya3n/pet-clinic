package sha2ya3n.the2gen3tel4man.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("oups")
public class ErrorController {

    @RequestMapping({"", "/", "error", "error.html"})
    public String errorHandler(){
        return "error/error";
    }
}
