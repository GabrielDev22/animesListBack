package com.animes.animesFavoritos.controller;


import com.animes.animesFavoritos.model.Animes;
import com.animes.animesFavoritos.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
@CrossOrigin("http://127.0.0.1:5173/")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/getAll")
    public List<Animes> getAllAnimes(){
        if(animeService.getAllAnimes() == null){
              return null;
        }
        return animeService.getAllAnimes();
    }

    @GetMapping("/get/{id}")
    public Animes getAnimesById(@PathVariable Integer id){
        if(animeService.getAnimesById(id) == null){
            return null;
        }
        return animeService.getAnimesById(id);
    }

    @PostMapping("/create")
    public Animes createAnimes(@RequestBody Animes animes){
        if(animeService.createAnimes(animes) == null){
            return null;
        }
        return animeService.createAnimes(animes);
    }

    @PutMapping("/update")
    public Animes updateAnimes(@RequestBody Animes animes){
        if(animeService.updateAnimes(animes) == null){
            return null;
        }
        return animeService.updateAnimes(animes);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnimesById(@PathVariable Integer id) {
        animeService.deleteAnimesById(id);
    }



}
