package com.LensCart.service;


import com.LensCart.entity.Cart;
import com.LensCart.entity.Product;
import com.LensCart.entity.User;
import com.LensCart.repository.CartRepository;
import com.LensCart.repository.ProductRepository;
import com.LensCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public void addCart(Cart cart){
        cartRepository.save(cart);
    }
    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }
    public  void deleteCart(int id){
        cartRepository.deleteById(id);
    }

    public void enrollCart(int cartId, int productId) {
        Cart cart= cartRepository.findById(cartId).get();
        Product product= productRepository.findById(productId).get();

        cart.addProducts(product);
        cartRepository.save(cart);

    }

    public void enrollUser(int cartId, long userId) {
        Cart cart= cartRepository.findById(cartId).get();


            User users = userRepository.findById(userId).get();

            users.setCart(cart);
            userRepository.save(users);


    }

    public void removeProduct(int cartId, int productId) {

        Cart cart=cartRepository.findById(cartId).get();
        Product product=productRepository.findById(productId).get();
        cart.setCartTotal(cart.getCartTotal()-product.getPrize());
        cart.getProducts().remove(product);
        cartRepository.save(cart);

    }
}
