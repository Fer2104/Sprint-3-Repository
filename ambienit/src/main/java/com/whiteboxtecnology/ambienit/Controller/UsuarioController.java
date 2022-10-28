package com.whiteboxtecnology.ambienit.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiteboxtecnology.ambienit.Model.UsuarioModel;
import com.whiteboxtecnology.ambienit.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuariosRepository;

    @GetMapping(path = "/read")
    public Iterable<UsuarioModel> getAllUsuarios(){
        return usuariosRepository.findAll();
    }
    
    @PostMapping(path = "/save")
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
        return usuariosRepository.save(usuario);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteUsuarioByID(@PathVariable("id") int id){
        usuariosRepository.deleteById(id);
    }
}


