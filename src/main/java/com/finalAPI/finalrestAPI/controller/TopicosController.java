package com.finalAPI.finalrestAPI.controller;

import com.finalAPI.finalrestAPI.excepciones.Duplicidad;
import com.finalAPI.finalrestAPI.excepciones.ResourceNotFoundException;
import com.finalAPI.finalrestAPI.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")

public class TopicosController {
    @Autowired
    private TopicoRepositorio topicoRepositorio;
    @PostMapping
    public ResponseEntity<DatosRespuestasTopicos> registrarTopicos(@RequestBody @Valid DatosRegistrosTopicos datosRegistroTopicos,
                                           UriComponentsBuilder uriComponentsBuilder){
        if (topicoRepositorio.existsByTituloAndMensaje(datosRegistroTopicos.titulo(), datosRegistroTopicos.mensaje())) {
            throw new Duplicidad("El tópico con el título y mensaje proporcionados ya existe");
        }
        //topicoRepositorio.save(new Topicos(datosRegistroTopicos));
        Topicos topico = topicoRepositorio.save(new Topicos(datosRegistroTopicos));
        DatosRespuestasTopicos datosRespuestasTopicos= new DatosRespuestasTopicos(topico.getId(),
                topico.getTitulo(),topico.getMensaje(),topico.getAutor(),topico.getCurso());
        //URI url="http://localhost:8080/topicos/"+topico.getId();
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestasTopicos);
    }

    /*public List<ListadoRegistro> listadoMedicos(){
        //Crea un nuevo registro por cada registro que llega de la lista
        return iMedico.findAll().stream().map(ListadoRegistro::new).toList();
    }*/


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size=3) Pageable paginacion){
        //Crea un nuevo registro por cada registro que llega de la lista
        //return iMedico.findAll(paginacion).map(ListadoRegistro::new);
        return ResponseEntity.ok(topicoRepositorio.findByActivoTrue(paginacion).map(DatosListadoTopicos::new));
    }
    @GetMapping("/{id}")
    @Transactional
    public Topicos detallandoTopico(@PathVariable Long id) {
        return topicoRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado con id " + id));
    }


    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody DatosRegistrosTopicos datosRegistrosTopicos) {
        Optional<Topicos> optionalTopico = topicoRepositorio.findById(id);
        if (optionalTopico.isPresent()) {
            Topicos topico = optionalTopico.get();
            topico.actualizarDatos(datosRegistrosTopicos);
            topicoRepositorio.save(topico);
            return ResponseEntity.ok(new DatosRespuestasTopicos(topico.getId(),
                    topico.getTitulo(),topico.getMensaje(),topico.getAutor(),topico.getCurso()));
        }  else {
            throw new ResourceNotFoundException("Tópico no encontrado con id " + id);
        }
        //Topicos topico = topicoRepositorio.getReferenceById(datosActualizarTopicos.id());
        //topico.actualizarDatos(datosActualizarTopicos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topicos> optionalTopico = topicoRepositorio.findById(id);

        if (optionalTopico.isPresent()) {
            topicoRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("Tópico no encontrado con id " + id);
        }
    }



    /* Crea una eliminacion por id en la base de datos cuando se escribe desde la URL
    public void eliminarRegistro(@PathVariable Long id){
        Medico medico = iMedico.getReferenceById(id);
        iMedico.delete(medico);
    }*/


    /*
    @DeleteMapping("/{id}")
    @Transactional
    //DELETE LOGICO-NO BORRA LOS REGISTROS DE BASES DE DATOS
    public void eliminarTopico(@PathVariable Long id) {
        Topicos topico = topicoRepositorio.getReferenceById(id);
        topico.desactivarTopicos();
    }*/
}

