package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//Servisten repoya ulaşmalıyız.
@Service
public class ProductManager implements ProductService {
    private final ProductRepository repository; //oto InMemoryProductRepository oluşturur (birbirine bağlı olduğu için)

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id, product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
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
