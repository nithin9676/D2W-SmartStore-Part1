package com.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.DashboardDto;
import com.Repostory.CustomerRepository;
import com.Repostory.OrderMasterRepository;
import com.Repostory.ProductItemRepository;
import com.Repostory.StoreInventoryRepository;
import com.Repostory.StoreRepository;

@Service
public class DashboardService {
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ProductItemRepository productItemRepository;
	
	@Autowired
	private StoreInventoryRepository storeInventoryRepository;
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public DashboardDto getDashboardData() {

	    DashboardDto dto =
	        new DashboardDto();

	    dto.setTotalStores( storeRepository.count() );

	    dto.setTotalProducts( productItemRepository.count() );

	    dto.setTotalCustomers( customerRepository.count() );
	    dto.setInventoryItems(storeInventoryRepository.count());
	    dto.setStockQuantity(storeInventoryRepository.getTotalStockQuantity());
	    dto.setLowStockItems(storeInventoryRepository.getLowStockItems());
	    dto.setOutOfStockItems(storeInventoryRepository.getOutOfStockItems());
	    dto.setTotalOrders(storeInventoryRepository.count());
	    dto.setTotalRevenue(orderMasterRepository.getTotalRevenue() );
	    dto.setTodaySales(0.0);
	    dto.setTodayOrders(0L);
	    dto.setPendingOrders(0L);
	    dto.setDeliveredOrders(0L);
	    dto.setCancelledOrders(0L);
	    dto.setPendingPayments(0.0);
	    return dto;
	}
}