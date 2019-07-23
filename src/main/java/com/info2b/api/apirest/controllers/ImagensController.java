package com.info2b.api.apirest.controllers;


import com.info2b.api.apirest.models.Imagens;
import com.info2b.api.apirest.repository.ImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ImagensController {


    @Autowired
    private ImagensRepository imagensRepository;

    @CrossOrigin
    @GetMapping("/imagens")
    public List<Imagens> listaImagens() {

        return imagensRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/imagens/{id}")
    public Imagens listaImagens(@PathVariable(value = "id") long id) {

        return imagensRepository.findById(id);
    }

    @CrossOrigin
    @PostMapping("/imagens")
    public Imagens inserirImagens(@RequestBody Imagens imagem) {

        return imagensRepository.save(imagem);

    }

    @CrossOrigin
    @PutMapping("/imagens")
    public Imagens alterarImagens(@RequestBody Imagens imagem) {

        return imagensRepository.save(imagem);

    }

    @CrossOrigin
    @DeleteMapping("/imagens/delete/{id}")
    public void deletarImagens(@PathVariable(value = "id") long id) {

        imagensRepository.deleteById(id);

    }


}