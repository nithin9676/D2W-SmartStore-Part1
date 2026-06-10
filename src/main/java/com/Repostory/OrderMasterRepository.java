package com.Repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DTO.CustomerDetailsDTO;
import com.DTO.CustomerOrderHistoryDTO;
import com.DTO.CustomerReportRowDTO;
import com.DTO.StorePerformanceDTO;
import com.Entity.OrderMaster;

public interface OrderMasterRepository
        extends JpaRepository<OrderMaster, Long> {

    List<OrderMaster> findByStoreId(Long storeId);

    @Query("""
            SELECT COALESCE(SUM(o.totalAmount),0)
            FROM OrderMaster o
            """)
    Double getTotalRevenue();

    @Query("""
            SELECT COUNT(o)
            FROM OrderMaster o
            """)
    Long getTotalOrders();

    @Query("""
            SELECT COUNT(o)
            FROM OrderMaster o
            """)
    Long getTotalOrdersCount();

    @Query("""
            SELECT new com.DTO.CustomerReportRowDTO(
                c.id,
                c.customerName,
                c.mobileNumber,
                COUNT(o),
                COALESCE(SUM(o.totalAmount),0)
            )
            FROM OrderMaster o
            JOIN o.customer c
            GROUP BY
                c.id,
                c.customerName,
                c.mobileNumber
            ORDER BY SUM(o.totalAmount) DESC
            """)
    List<CustomerReportRowDTO> getCustomerReportRows();

    @Query("""
            SELECT COALESCE(SUM(o.totalAmount),0)
            FROM OrderMaster o
            """)
    Double getTotalPurchaseAmount();

    @Query("""
            SELECT new com.DTO.CustomerDetailsDTO(
                c.id,
                c.customerName,
                c.mobileNumber,
                c.address,
                COUNT(o),
                COALESCE(SUM(o.totalAmount),0)
            )
            FROM OrderMaster o
            JOIN o.customer c
            WHERE c.id = :customerId
            GROUP BY
                c.id,
                c.customerName,
                c.mobileNumber,
                c.address
            """)
    CustomerDetailsDTO getCustomerDetails(
            @Param("customerId") Long customerId
    );

    @Query("""
            SELECT new com.DTO.CustomerOrderHistoryDTO(
                o.id,
                o.customerName,
                o.totalAmount,
                o.paymentMethod,
                o.orderDate
            )
            FROM OrderMaster o
            WHERE o.customer.id = :customerId
            ORDER BY o.orderDate DESC
            """)
    List<CustomerOrderHistoryDTO> getCustomerOrderHistory(
            @Param("customerId") Long customerId
    );
    
    @Query("""
    		SELECT new com.DTO.StorePerformanceDTO(
    		    o.store.storeName,
    		    COUNT(o),
    		    SUM(o.totalAmount)
    		)
    		FROM OrderMaster o
    		GROUP BY o.store.storeName
    		ORDER BY SUM(o.totalAmount) DESC
    		""")
    		List<StorePerformanceDTO>
    		getStorePerformance();
}