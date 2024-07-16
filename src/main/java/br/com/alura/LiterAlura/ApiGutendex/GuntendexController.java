package br.com.alura.LiterAlura.ApiGutendex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuntendexController {

    @Autowired
    private Gutendex gutendex;

}
