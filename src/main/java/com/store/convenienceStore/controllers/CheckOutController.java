package com.store.convenienceStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.store.convenienceStore.models.Products;
import com.store.convenienceStore.models.Transaction;
import com.store.convenienceStore.models.User;
import com.store.convenienceStore.services.ProductService;
import com.store.convenienceStore.services.TransactionService;
import com.store.convenienceStore.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
@SessionAttributes("totalPrice")
public class CheckOutController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/Checkout/{id}")
    public String showCheckoutPage(@PathVariable("id") Long id, Model model, HttpSession session) {
        // Lakukan apa pun yang diperlukan untuk mendapatkan informasi produk dari ID
        Products product = productService.getProductById(id);
        
        // Masukkan data produk ke dalam model
        model.addAttribute("product", product);

        // Ambil id pengguna dari sesi
        // String username = (String) session.getAttribute("username");
        
        // Lakukan apa pun yang diperlukan untuk mendapatkan informasi pengguna dari id
       // User user = userService.getUserByUsername(username);
        
        // Masukkan data pengguna ke dalam model
       // model.addAttribute("username", user.getUsername());
        
        // Kembalikan nama view
        return "user/CheckOut";
    }
    
    @PostMapping("/submit_order")
    public String submitOrder(@RequestParam("username") String username,
                              @RequestParam("email") String email,
                              @RequestParam("alamat") String alamat,
                              @RequestParam("kota") String kota,
                              @RequestParam("kode_pos") int kode_pos,
                              @RequestParam("productId") Products product,
                              @RequestParam("totalPrice") String totalPrice) {
    								
        // Create a new Transaction object
        Transaction transaction = new Transaction();
        transaction.setUsername(username);
        transaction.setEmail(email);
        transaction.setAlamat(alamat);
        transaction.setKota(kota);
        transaction.setKode_pos(kode_pos);
        transaction.setTotalPrice(totalPrice);
        transaction.setProduct(product); // Set Products object directly
        
        // Save the transaction to the database
        transactionService.saveTransaction(transaction);
        
        // Redirect to a confirmation page or any other page
        return "user/succes";
    }


    
}
