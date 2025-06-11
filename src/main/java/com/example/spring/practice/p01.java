package com.example.spring.practice;

import com.example.spring.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
@RequestMapping("p01")
public class p01 {
    //Categories 테이블의 CategoryName 들을 조회/출력
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT CategoryName
                FROM Categories
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        var list = new ArrayList<String>();

        while (rs.next()) {
            String name = rs.getString("CategoryName");
            list.add(name);
        }
        model.addAttribute("list", list);
        return "p01/sub1";
    }

    //OrderDetatils 에서 수량(Quantity) 상위 5개 조회
    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
        String sql = """
                SELECT Quantity
                FROM OrderDetails
                ORDER BY Quantity DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        var list = new ArrayList<String>();
        while (rs.next()) {
            String qtt = rs.getString("Quantity");
            list.add(qtt);
        }
        model.addAttribute("list", list);
        return "p01/sub2";
    }
}

    //고객테이블에서 미국, 영국에 사는 고객이름과 국가를 조회
    //모든 고객의 정보를 출력
    //모든 상품 조회, 출력
    //특정 카테고리 번호의 상품들 조회, 출력
    //특정 가격 사이의 상품들 조회, 출력
    //특정 국가에 있는 공급자들 조회
    //고객명 조회하는 코드
    //한 페이지에 5개의 공급자 출력
    //검색 + 페이징
    //상품명 조회 로직 (w/ paging) 페이지네이션 완성(이전, 다음)
    //새 공급자 등록 로직
    //삭제 로직
    //업데이트 로직
//    @GetMapping("sub15")
//    public String select15(Integer id,Model model) throws Exception {
//        String sql = """
//                SELECT *
//                FROM Products
//                WHERE ProductID = ?
//                """;
//        String url = "jdbc:mysql://localhost:3306/w3schools";
//        String username = "root";
//        String password = "1234";
//        Connection connection = DriverManager.getConnection(url, username, password);
//        PreparedStatement stm = connection.prepareStatement(sql);
//        stm.setInt(1, id);
//        ResultSet rs = stm.executeQuery();
//        while(rs.next()){
//            ProductDto dto = new ProductDto();
//            dto.setId(rs.getInt("ProductID"));
//            dto.setName(rs.getString("ProductName"));
//            dto.setSupplier(rs.getString(""));
//        }
//    }
//
//    @PostMapping("sub15")
//    public String process15(Model model, RedirectAttributes) throws Exception {
//        return "redirective:p01/sub15";
//    }
//}
