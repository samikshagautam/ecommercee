package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
  //add new Product
    public Product addProduct(Product product) throws Exception {
        if(product == null){
            throw new Exception("Product not found!");
        }
        Product product1 = productRepository.findByNameAndCategoryId(product.getName() , product.getCategoryId());
        if(product1 != null){
            throw  new Exception("Product is already registered by this name");
        }

        return productRepository.save(product);

    }

   //get product by category id
    public List<Product> getProductsByCategory(Long catId){
        return productRepository.findAllByCatrgoryId(catId);
    }

    //get all products
    public List<Product>  getAllProducts(){
        return productRepository.findAll();
    }

    //find product By Id
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    //delete product By product id
    public Product deleteProduct(Long id) throws Exception {
       Product product = getProductById(id);
       if(product == null){
           throw  new Exception("Product doesn't exist");
       }
       productRepository.delete(product);
       return product;
    }

    //update Product
    public Product updateProduct(Long id, Product product) throws Exception{
        Product product1 = getProductById(id);
        if(product1 == null){
            throw  new Exception("Product doesn't exist");
        }
        product1.setName(product.getName());
        product1.setDesc(product.getDesc());
        product1.setPrice(product.getPrice());

        productRepository.save(product1);
        return product1;
            }

}
