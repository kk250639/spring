package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getInt("CustomerId"));
            customerDto.setName(resultSet.getString("CustomerName"));
            customerDto.setAddress(resultSet.getString("Address"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setContactName(resultSet.getString("ContactName"));
            customerDto.setCountry(resultSet.getString("Country"));
            customerDto.setPostalCode(resultSet.getString("PostalCode"));
            customerDtoList.add(customerDto);
        }
        model.addAttribute("customerList", customerDtoList);

        return "main16/sub1";
    }

    @PostMapping("sub1")
    public String process(CustomerDto customer) throws Exception {
//        System.out.println(customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.executeQuery(); // select
        statement.executeUpdate(); // insert, delete, update

        return "redirect:/main16/sub1";
    }

    // 연습:
    // 새 공급자 등록 로직 작성
    // handler method * 2 (get, post)
    // html * 1
    @GetMapping("sub2")
    public String form2(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<SupplierDto> supplierDtoList = new ArrayList<>();
        while (resultSet.next()) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(resultSet.getInt("SupplierId"));
            supplierDto.setName(resultSet.getString("SupplierName"));
            supplierDto.setAddress(resultSet.getString("Address"));
            supplierDto.setCity(resultSet.getString("City"));
            supplierDto.setCountry(resultSet.getString("Country"));
            supplierDto.setPostalCode(resultSet.getString("PostalCode"));
            supplierDto.setPhone(resultSet.getString("Phone"));
            supplierDto.setContact(resultSet.getString("ContactName"));
            supplierDtoList.add(supplierDto);
        }
        model.addAttribute("supplierList", supplierDtoList);

        return "main16/sub2";
    }

    @PostMapping("sub2")
    public String process2(SupplierDto supplier) throws Exception {
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplier.getName());
        statement.setString(2, supplier.getContact());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());
        statement.executeUpdate();

        return "redirect:/main16/sub2";
    }

    @GetMapping("sub3")
    public String form3(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc://localhost:3306/w3schools";
            String username = "root";
            String password = "@#DUSVLF3524";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

//        stm.executeUpdate();    // insert, update, delete
            ResultSet rs = stm.executeQuery();  // select
            if (rs.next()) {
                // 조회 결과가 있을 떄만
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(rs.getInt("CustomerId"));
                customerDto.setName(rs.getString("CustomerName"));
                customerDto.setAddress(rs.getString("Address"));
                customerDto.setCity(rs.getString("City"));
                customerDto.setContactName(rs.getString("ContactName"));
                customerDto.setCountry(rs.getString("Country"));
                customerDto.setPostalCode(rs.getString("PostalCode"));

                model.addAttribute("customer", customerDto);
            }
        }

        return "main16/sub3";
    }

    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws SQLException {
        String sql = """
                DELETE 
                FROM Customers
                WHERE CustomerId = ?
                """;

        String url = "jdbc://localhost:3306/w3schools";
        String username = "root";
        String password = "@#DUSVLF3524";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        rttr.addFlashAttribute("id", "id");

        return "redirect:/main16/sub3";
    }
    // 연습:
    // 공급자 조회 후 삭제 로직 완성
    // request handler method * 2, html * 1

    @GetMapping("sub4")
    public String form4(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "@#DUSVLF3524";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                SupplierDto dto = new SupplierDto();
                dto.setId(rs.getInt("SupplierId"));
                dto.setName(rs.getString("SupplierName"));
                dto.setContact(rs.getString("ContactName"));
                dto.setAddress(rs.getString("Address"));
                dto.setCity(rs.getString("City"));
                dto.setPostalCode(rs.getString("PostalCode"));
                dto.setCountry(rs.getString("Country"));
                dto.setPhone(rs.getString("Phone"));
                model.addAttribute("supplier", dto);
            }
        }
        return "main16/sub4";
    }

    @PostMapping("sub4")
    public String process4(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE 
                FROM Suppliers
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "@#DUSVLF3524";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();
        rttr.addFlashAttribute("id", id);
        return "redirect:/main16/sub4";
    }

    // update
    // get
    @GetMapping("sub5")
    public String select1(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "@#DUSVLF3524";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(rs.getInt("CustomerId"));
                customerDto.setName(rs.getString("CustomerName"));
                customerDto.setContactName(rs.getString("ContactName"));
                customerDto.setAddress(rs.getString("Address"));
                customerDto.setCity(rs.getString("City"));
                customerDto.setCountry(rs.getString("Country"));
                customerDto.setPostalCode(rs.getString("PostalCode"));
                model.addAttribute("customer", customerDto);
            }
        }
        return "main16/sub5";
    }

    // post
    @PostMapping("sub5")
    public String update1(CustomerDto dto, RedirectAttributes rttr) throws Exception {
//            System.out.println("dto = " + dto);
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                    WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "@#DUSVLF3524";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, dto.getName());
        stm.setString(2, dto.getContactName());
        stm.setString(3, dto.getAddress());
        stm.setString(4, dto.getCity());
        stm.setString(5, dto.getPostalCode());
        stm.setString(6, dto.getCountry());
        stm.setInt(7, dto.getId());
        stm.executeUpdate();    // update
        rttr.addAttribute("id", dto.getId());
        return "redirect:/main16/sub5";

    }

    // 연습 :
    // 공급자 정보 조회/수정
    // request handler method * 2, html * 1
    @GetMapping("sub6")
    public String select2(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "@#DUSVLF3524";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                SupplierDto dto = new SupplierDto();
                dto.setId(rs.getInt("SupplierId"));
                dto.setName(rs.getString("SupplierName"));
                dto.setContact(rs.getString("ContactName"));
                dto.setAddress(rs.getString("Address"));
                dto.setCity(rs.getString("City"));
                dto.setPostalCode(rs.getString("PostalCode"));
                dto.setCountry(rs.getString("Country"));
                dto.setPhone(rs.getString("Phone"));
                model.addAttribute("supplier", dto);
            }
        }
        return "main16/sub6";
    }

    @PostMapping("sub6")
    public String update2(SupplierDto dto, RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Suppliers
                SET SupplierName = ?,
                ContactName = ?,
                Address = ?,
                City = ?,
                PostalCode = ?,
                Country = ?,
                Phone = ?
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "@#DUSVLF3524";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, dto.getName());
        stm.setString(2, dto.getContact());
        stm.setString(3, dto.getAddress());
        stm.setString(4, dto.getCity());
        stm.setString(5, dto.getPostalCode());
        stm.setString(6, dto.getCountry());
        stm.setString(7, dto.getPhone());
        stm.setInt(8, dto.getId());
        stm.executeUpdate();
        rttr.addAttribute("id", dto.getId());
        return "main16/sub6";
    }
}
