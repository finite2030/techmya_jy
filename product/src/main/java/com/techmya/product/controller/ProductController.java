package com.techmya.product.controller;

import com.techmya.product.model.dto.ProductDTO;
import com.techmya.product.model.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String getAllProduct(Model model, @RequestParam(required = false) String productName) {
        log.info("[ProductController] getAllProduct productName = {}", productName);

        // 데이터 베이스에서 상품 전체 목록 조회
        List<ProductDTO> productList = productService.getAllProduct(productName);
        log.info("[ProductController] getAllProduct prductList = {}", productList);

        // 조회된 목록을 productList라는 이름으로 main.html에 리스트 객체로 전달
        model.addAttribute("productList", productList);

        return "product/main";
    }

    @GetMapping("/regist")
    public String registPage(Model model) {
        log.info("[ProductController] registPage");

        // 데이터 베이스에서 상품 카테고리 목록 조회
        List<String> categoryList = productService.getAllProductCategory();
        log.info("[ProductController] getAllProductCategory = {}", categoryList);

        // 조회된 목록을 categoryList라는 이름으로 regist.html에 리스트 객체로 전달
        model.addAttribute("categoryList", categoryList);

        return "product/regist";
    }

    @PostMapping("/regist")
    public String registProduct(@ModelAttribute ProductDTO newProduct,
                                RedirectAttributes rttr, Model model) {

        log.info("[ProductController] registProduct newProduct = {}", newProduct);

        productService.registNewProduct(newProduct);

        rttr.addFlashAttribute("successMessage", "신규 상품 등록에 성공하였습니다.");

        return "redirect:/product/main";
    }
}