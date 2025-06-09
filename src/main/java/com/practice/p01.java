package com.practice;

import com.example.spring.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("p01")
public class p01 {
    // 상품명 조회 로직
    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1")
                       Integer page,
                       @RequestParam(defaultValue = "")
                       String keyword,
                       Model model) throws Exception {
        // ?에 해당하는 상품명 나열 후 몇개의 물건을 보여줄지 계산
        String sql = """
                SELECT *
                FROM Products
                WHERE ProductName LIKE ?
                ORDER BY ProductID
                LIMIT ?, ?
                """;
        // ?에 해당하는 상품 갯수 조회 -> 총 페이지 수 계산
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Products
                WHERE ProductID LIKE ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "@#DUSVLF3524";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement selectStm = connection.prepareStatement(sql);
        selectStm.setString(1, "%" + keyword + "%");
        int offset = (page - 1) * 10;
        selectStm.setInt(2, offset);
        selectStm.setInt(3, 10);
        PreparedStatement countStm = connection.prepareStatement(countSql);
        countStm.setString(1, "%" + keyword + "%");
        ResultSet rs = countStm.executeQuery();
        rs.next();
        int count = rs.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        //        int rightPage =;
//        int leftPage =;
//        int prevPage =;
//        int nextPage =;
//        rightPage = ;
        model.addAttribute("lastPage", lastPage);

        ResultSet rs2 = selectStm.executeQuery();
        List<ProductDto> list = new ArrayList<>();
        while (rs2.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(rs2.getInt("ProductID"));
            dto.setName(rs2.getString("ProductName"));
            dto.setSupplier(rs2.getInt("SupplierID"));
            dto.setCategory(rs2.getInt("CategoryID"));
            dto.setUnit(rs2.getString("unit"));
            dto.setPrice(rs2.getDouble("price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);
        return "practice01/sub1";
    }
}
