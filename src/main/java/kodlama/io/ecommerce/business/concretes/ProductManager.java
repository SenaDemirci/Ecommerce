package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//Servisten repoya ulaşmalıyız.
@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private final ProductRepository repository; //oto InMemoryProductRepository oluşturur (birbirine bağlı olduğu için)

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    //ctrl + w (bütün bloğu açar)
    //ctrl + alt + shift + t (açılan menüden extract method seç)
    //!Business rules
    private void validateProduct(Product product) {
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfLengthValid(product);
    }
    private void checkIfUnitPriceValid(Product product) {
        if (product.getUnitPrice() <= 0) throw new IllegalArgumentException("Price cannot be less than zero");
    }
    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new IllegalArgumentException("Quantity cannot be less than zero");
    }
    private void checkIfLengthValid(Product product) {
        if (product.getDescription().length() < 10 ||  product.getDescription().length() > 50) throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }
}
