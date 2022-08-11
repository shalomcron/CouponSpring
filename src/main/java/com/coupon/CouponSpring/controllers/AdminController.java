package com.coupon.CouponSpring.controllers;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Customer;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginException;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.session.ClientsSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final String adminServiceKey = "adminService";
    @Autowired
    ClientsSession clientsSession;
    @Autowired
    private LoginManager loginManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String logIn(@RequestParam String email, @RequestParam String password) throws LoginException {
        AdminService adminService = (AdminService) loginManager
                .login(email, password, ClientType.Admin);
        clientsSession.setAdminSession(adminServiceKey, adminService);
        return "Admin logged in ok";
    }

    @DeleteMapping("/deleteCompany/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCompany(@PathVariable int companyId) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).deleteCompany(companyId);
        return "Company " + companyId + " deleted";
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCustomer(@PathVariable int customerId) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).deleteCustomer(customerId);
        return "Customer " + customerId + " deleted";
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public String addCustomer(@RequestBody Customer customer) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).addCustomer(customer);
        return "Customer " + customer.getFirsName() + " added";
    }

    @GetMapping("/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable int customerId) throws Exception {
        return clientsSession.getAdminSession(adminServiceKey).geSingleCustomer(customerId);
    }

    @PutMapping("/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).updateCustomer(customerId, customer);
        return "Customer " + customer.getFirsName() + " updated";
    }

    @PostMapping("/addCompany")
    @ResponseStatus(HttpStatus.OK)
    public String addCompany(@RequestBody Company company) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).addCompany(company);
        return "Company " + company.getName() + " added";
    }

    @PutMapping("/updateCompany/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateCompany(@PathVariable int companyId, @RequestBody Company company) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).updateCompany(companyId ,company);
        return "Company " + companyId + " updated";
    }

    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() throws Exception {
        return clientsSession.getAdminSession(adminServiceKey).getAllCompanies();
    }

    @GetMapping("/companies/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public Company getCompany(@PathVariable int companyId) throws Exception {
        return clientsSession.getAdminSession(adminServiceKey).getCompany(companyId);
    }
}


