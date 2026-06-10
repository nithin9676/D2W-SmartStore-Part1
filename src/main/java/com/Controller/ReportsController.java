package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
import com.Service.ReportsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @GetMapping("/reports/sales")
    public SalesReportDTO getSalesReport() {

        return reportsService.getSalesReport();
    }
    
    @GetMapping("/reports/sales/orders")
    public List<SalesOrderRowDTO> getSalesOrders()
    {
    	return reportsService.getSalesOrders();
    }
    @GetMapping("/reports/inventory")
    public InventorySummaryDTO getInventoryReport() {

        return reportsService
            .getInventorySummary();
    }
    @GetMapping("/reports/inventory/items")
    public List<InventoryReportRowDTO> getInventoryItems() {

        return reportsService
            .getInventoryReportRows();
    }
    @GetMapping("/reports/low-stock")
    public LowStockReportDTO
    getLowStockReport() {

        return reportsService
                .getLowStockReport();
    }
    @GetMapping("/reports/low-stock/items")
    public List<LowStockItemDTO>
    getLowStockItems() {

        return reportsService
                .getLowStockItems();
    }
    @GetMapping("/reports/customers")
    public CustomerReportDTO
    getCustomerReport() {

        return reportsService
            .getCustomerReport();
    }
    @GetMapping("/reports/customers/list")
    public List<CustomerReportRowDTO>
    getCustomerReportRows() {

        return reportsService
            .getCustomerReportRows();
    }
    @GetMapping(
    		"/reports/customers/{customerId}"
    		)
    		public CustomerDetailsDTO
    		getCustomerDetails(@PathVariable("customerId") Long customerId) {

    		    return reportsService
    		        .getCustomerDetails(
    		            customerId
    		        );
    		}
    @GetMapping(
    		"/reports/customers/{customerId}/orders"
    		)
    		public List<CustomerOrderHistoryDTO>
    		getCustomerOrders(
    		@PathVariable("customerId") Long customerId
    		) {

    		    return reportsService
    		        .getCustomerOrderHistory(
    		            customerId
    		        );
    		}
    @GetMapping( "/reports/sales/top-products")
    	public List<TopSellingProductDTO>
    	getTopSellingProducts() {

    	    return reportsService
    	            .getTopSellingProducts();
    	}
    @GetMapping(
    	    "/reports/sales/top-categories"
    	)
    	public List<TopCategoryDTO>
    	getTopSellingCategories() {

    	    return reportsService
    	            .getTopSellingCategories();
    	}
    @GetMapping(
    	    "/reports/sales/top-brands"
    	)
    	public List<TopBrandDTO>
    	getTopSellingBrands() {

    	    return reportsService
    	            .getTopSellingBrands();
    	}
    @GetMapping(
    	    "/reports/sales/top-vehicles"
    	)
    	public List<TopVehicleDTO>
    	getTopSellingVehicles() {

    	    return reportsService
    	            .getTopSellingVehicles();
    	}
    @GetMapping(
    	    "/reports/inventory/dead-stock"
    	)
    	public List<DeadStockDTO>
    	getDeadStockProducts() {

    	    return reportsService
    	            .getDeadStockProducts();
    	}
    @GetMapping(
    	    "/reports/store-performance"
    	)
    	public List<StorePerformanceDTO>
    	getStorePerformance() {

    	    return reportsService
    	            .getStorePerformance();
    	}
    @GetMapping(
    	    "/reports/profit"
    	)
    	public ProfitReportDTO
    	getProfitReport() {

    	    return reportsService
    	            .getProfitReport();
    	}
}