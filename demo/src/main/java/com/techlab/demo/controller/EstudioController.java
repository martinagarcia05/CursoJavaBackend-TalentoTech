package demo.src.main.java.com.techlab.demo.controller;

import demo.src.main.java.com.techlab.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//debe controlar lo que entra desde afuera:
@RestController
public class EstudioController {

    private ProductService service;

    public EstudioController(ProductService productService) {
        this.service = productService;
    }

//configuracion de los endpoints
    @GetMapping("/hello")//localhost:8080 + "ruta que estamos configurando"
    public String helloWorld(){
        return "Hello World desde spring boot";
    }

    @PostMapping("/product")
    public String crearProducto(@RequestBody Product product){
        System.out.print(product);
        return "Creando Producto";
    }

    //editarProducto
    @PutMapping("/products/{id}") //put o patch es lo mismo en este caso
    public String editarProducto(@PathVariable int id){
        return "editando";
    }

    @GetMapping("/products/precio")
    public List<String> buscarPordxPre(@RequestParam int precio){
        return List.of("producto1");
    }
}
