package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    //localhost:8080/api/products/1
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    //örnek path: localhost:8080/api/products?categoryId=1
    //RequestParam -> aynı özelliğe sahip 1+ ürün olduğu zaman filtreliyoruz (ürünü sadece 1 özelliğini kullanarak çağırmak için)
    @GetMapping("/")
    public Product findById(@RequestParam int id) {
        return service.getById(id);
    }

    //RequestBody -> örneğin json formatında ürüne 1+ değer girmek için kullanılır
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product) {
        return service.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) //ttpStatus hazır olan enumlar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
