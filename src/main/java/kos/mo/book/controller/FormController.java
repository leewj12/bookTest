package kos.mo.book.controller;

import kos.mo.book.dto.FormDTO;
import kos.mo.book.entity.FormEntity;
import kos.mo.book.service.FormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FormController {

    private final FormService formService;

    @GetMapping("/form")
    public String getForm(Model model) {
        List<FormDTO> formDTOList = formService.getAll();
        model.addAttribute("saveForm", new FormDTO());
        model.addAttribute("forms", formDTOList);
        return "form";
    }

    @PostMapping("/saveData")
    public String saveForm(FormDTO formDTO) {
        formService.saveForm(formDTO);
        return "redirect:/form";
    }

//    @PostMapping("/updateData")
//    public String updateForm(@RequestParam("id") Long id) {
//        formService.saveById(id);
//        return "redirect:/form";
//    }

    @PostMapping("/deleteData")
    public String deleteForm(@RequestParam("id") Long id) {
        log.info("id========={}",id);
        formService.deleteById(id);
        return "redirect:/form";
    }

}
