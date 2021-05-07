package Service;

import Model.Product;
import Repository.ProductRepository;
import Repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl  implements ProductService{
    ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public List<Product> search(String search) {
        return null;
    }
}
