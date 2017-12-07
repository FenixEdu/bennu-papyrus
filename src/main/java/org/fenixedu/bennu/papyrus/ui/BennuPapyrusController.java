package org.fenixedu.bennu.papyrus.ui;

import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bennu-papyrus")
@SpringApplication(group = "logged", path = "bennu-papyrus", title = "title.BennuPapyrus")
@SpringFunctionality(app = BennuPapyrusController.class, title = "title.BennuPapyrus")
public class BennuPapyrusController {

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("world", "World");
        return "bennu-papyrus/home";
    }

}
