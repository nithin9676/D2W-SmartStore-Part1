package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.DashboardDto;
import com.Service.DashboardService;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public DashboardDto getDashboard() {

        return dashboardService.getDashboardData();
    }
}