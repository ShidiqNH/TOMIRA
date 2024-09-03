package com.store.convenienceStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PembayaranBerhasilController {
	
    @GetMapping("/Pembayaran-Berhasil")
    public String showRegisPage() {
        return "user/succes"; // This will return the login.html page
    }
}
