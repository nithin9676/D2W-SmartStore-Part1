package com.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.CustomerDetailsDTO;
import com.DTO.CustomerOrderHistoryDTO;
import com.DTO.CustomerReportDTO;
import com.DTO.CustomerReportRowDTO;
import com.DTO.DeadStockDTO;
import com.DTO.InventoryReportRowDTO;
import com.DTO.InventorySummaryDTO;
import com.DTO.LowStockItemDTO;
import com.DTO.LowStockReportDTO;
import com.DTO.ProfitReportDTO;
import com.DTO.SalesOrderRowDTO;
import com.DTO.SalesReportDTO;
import com.DTO.StorePerformanceDTO;
import com.DTO.TopBrandDTO;
import com.DTO.TopCategoryDTO;
import com.DTO.TopSellingProductDTO;
import com.DTO.TopVehicleDTO;
import com.Entity.OrderMaster;
import com.Entity.StoreInventory;
import com.Repostory.CustomerRepository;
import com.Repostory.OrderItemRepository;
import com.Repostory.OrderMasterRepository;
import com.Repostory.ProductFitmentRepository;
import com.Repostory.ProductItemRepository;
import com.Repostory.StoreInventoryRepository;

@Service
public class ReportsService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    private StoreInventoryRepository storeInventoryRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    
    @Autowired
    private ProductFitmentRepository productFitmentRepository;
    
    @Autowired
    private ProductItemRepository productItemRepository;

    public SalesReportDTO getSalesReport() {

        SalesReportDTO dto = new SalesReportDTO();
        Long totalOrders=orderMasterRepository.count();
        Double totalRevenue=orderMasterRepository.getTotalRevenue();
        Long coustomers=customerRepository.count();
        Double avergeOrderValue=totalOrders>0?totalRevenue/totalOrders:0.0;

        dto.setTotalOrders(
            orderMasterRepository.getTotalOrders()
        );

        dto.setTotalRevenue(
            orderMasterRepository.getTotalRevenue()
        );
        dto.setTotalOrders(totalOrders);
        dto.setTotalRevenue(totalRevenue);
        dto.setTotalCustomers(coustomers);
        dto.setAverageOrderValue(avergeOrderValue);

        return dto;
    }
    
    public List<SalesOrderRowDTO> getSalesOrders() {

        return orderMasterRepository.findAll()
                .stream()
                .map(order -> new SalesOrderRowDTO(

                        order.getId(),
                        order.getCustomerName(),
                        order.getPhone(),
                        order.getTotalAmount(),
                        order.getPaymentMethod(),
                        order.getOrderDate()

                ))
                .collect(Collectors.toList());
    }
    public InventorySummaryDTO getInventorySummary() {

        InventorySummaryDTO dto =
            new InventorySummaryDTO();

        dto.setTotalProducts(
            storeInventoryRepository
                .getTotalProducts()
        );

        dto.setTotalStockQuantity(
            storeInventoryRepository
                .getTotalStockQuantity()
        );

        dto.setLowStockItems(
            storeInventoryRepository
                .getLowStockItems()
        );

        dto.setOutOfStockItems(
            storeInventoryRepository
                .getOutOfStockItems()
        );

        return dto;
    }
    public List<InventoryReportRowDTO>
    getInventoryReportRows() {

        List<StoreInventory> items =
            storeInventoryRepository.findAll();

        return items.stream()
            .map(item -> {

                String status;

                if(item.getQuantity() == 0) {

                    status = "OUT OF STOCK";

                } else if(
                    item.getQuantity()
                    <= item.getMinimumStock()
                ) {

                    status = "LOW STOCK";

                } else {

                    status = "IN STOCK";
                }

                return new InventoryReportRowDTO(
                    item.getId(),
                    item.getProductItem()
                        .getItemName(),
                    item.getStore()
                        .getStoreName(),
                    item.getQuantity(),
                    item.getMinimumStock(),
                    status
                );
            })
            .toList();
    }
    public LowStockReportDTO getLowStockReport() {

        LowStockReportDTO dto =
                new LowStockReportDTO();

        dto.setTotalLowStockItems(
                storeInventoryRepository
                .getTotalLowStockItems());

        dto.setCriticalItems(
                storeInventoryRepository
                .getCriticalItems());

        return dto;
    }
    public List<LowStockItemDTO>
    getLowStockItems() {

        return storeInventoryRepository
                .getLowStockItems1();
    }
    public CustomerReportDTO
    getCustomerReport() {

        CustomerReportDTO dto =
            new CustomerReportDTO();

        dto.setTotalCustomers(
            customerRepository.count()
        );

        dto.setTotalOrders(
            orderMasterRepository
            .getTotalOrdersCount()
        );

        dto.setTotalPurchaseAmount(
            orderMasterRepository
            .getTotalPurchaseAmount()
        );

        return dto;
    }
    public List<CustomerReportRowDTO>
    getCustomerReportRows() {

        return orderMasterRepository
            .getCustomerReportRows();
    }
    public List<CustomerOrderHistoryDTO>
    getCustomerOrderHistory(
        Long customerId
    ) {

        return orderMasterRepository
            .getCustomerOrderHistory(
                customerId
            );
    }
    public CustomerDetailsDTO
    getCustomerDetails(
        Long customerId
    ) {

        return orderMasterRepository
            .getCustomerDetails(
                customerId
            );
    }
    public List<TopSellingProductDTO>
    getTopSellingProducts() {

        return orderItemRepository
                .getTopSellingProducts();
    }
    public List<TopCategoryDTO>
    getTopSellingCategories() {

        return orderItemRepository
                .getTopSellingCategories();
    }
    public List<TopBrandDTO>
    getTopSellingBrands() {

        return orderItemRepository
                .getTopSellingBrands();
    }
    public List<TopVehicleDTO>
    getTopSellingVehicles() {

        return productFitmentRepository
                .getTopSellingVehicles();
    }
    public List<DeadStockDTO>
    getDeadStockProducts() {

        List<Long> soldIds =
                orderItemRepository
                .getSoldProductIds();

        return productItemRepository
                .getDeadStockProducts(
                        soldIds
                );
    }
    public List<StorePerformanceDTO>
    getStorePerformance() {

        return orderMasterRepository
                .getStorePerformance();
    }
    public ProfitReportDTO
    getProfitReport() {

        return orderItemRepository
                .getProfitReport();
    }
}