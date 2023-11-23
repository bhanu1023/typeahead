package dev.bhanu.typeahead.Controller;

import dev.bhanu.typeahead.DTO.SuggestionDTO;
import dev.bhanu.typeahead.Service.TypeAheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeahead")
public class TypeAheadController {

    TypeAheadService typeAheadService;

    @Autowired
    public TypeAheadController(TypeAheadService typeAheadService) {
        this.typeAheadService = typeAheadService;
    }

    @GetMapping("/{prefix}")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getTopSuggestions(@PathVariable String prefix) {
        return typeAheadService.getTopSuggestions(prefix);
    }

}
