package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.ProductDetailResponseDTO;
import com.DTO.ProductSearchResponseDTO;
import com.Entity.ProductItem;
import com.Service.ProductItemService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @PostMapping
    public String insertProductItem(@RequestBody ProductItem productItem) {

        return productItemService.insertProductItemDetails(productItem);
    }

    @GetMapping
    public List<ProductItem> getAllProducts() {

        return productItemService.getAllProductItems();
    }

    @GetMapping("/part-number")
    public Optional<ProductItem> getProductByPartNumber(@RequestParam("number") String number) {

        return productItemService.getItemByPartNumber(number);
    }

    @GetMapping("/master")
    public List<ProductItem> getProductsByMasterId(@RequestParam("id") Long id) {

        return productItemService.getByMasterId(id);
    }

    @PostMapping("/bulk-upload")
    public String bulkUpload(@RequestParam("file") MultipartFile file) {

        return productItemService.bulkUpload(file);
    }

    @GetMapping("/search")
    public List<ProductSearchResponseDTO> searchProducts(@RequestParam(value = "text", required = false) String text) {

        return productItemService.getProductBySearchText(text);
    }

    @GetMapping("/{id}")
    public ProductDetailResponseDTO getProductDetails( @PathVariable("id") Long id)
    {

        return productItemService
                .getProductDetails(id);
    }
   
}