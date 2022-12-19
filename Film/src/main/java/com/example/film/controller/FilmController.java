package com.example.film.controller;

import com.example.film.model.FilmEntity;
import com.example.film.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Film")
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Operation(summary="Menambahkan Film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Film berhasil ditambahkan.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmEntity create(@RequestBody FilmEntity filmEntity){
        return filmService.savefilm(filmEntity);
    }

    @Operation(summary="Menampilkan Film")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Film Berhasil Ditampilkan.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
    @GetMapping("/get")
    public List<FilmEntity> getall(){
        return filmService.findallfilm();
    }

    @Operation(summary="Mengupdate Film")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Film berhasil diupdate.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
    @PutMapping("/update/{id}")
    public FilmEntity update(@PathVariable Long id, @RequestBody FilmEntity filmEntity){
        return filmService.updateFilm(id,filmEntity);
    }

    @Operation(summary="Menghapus Film")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Film berhasil dihapus.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return filmService.deleteFilm(id);
    }



}

