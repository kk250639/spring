package com.example.spring.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("p02")
public class p02 {
    @RequestMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM 35elbat
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", rs.getString("user"));
            map.put("money", rs.getInt("money"));
            list.add(map);
        }
        model.addAttribute("list", list);
        return "/p02/sub1";
    }

    @PostMapping("sub2")
    public String success1(Model model) throws Exception {
        String sql1 = """
                UPDATE 35elbat
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE 35elbat
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stm = connection.prepareStatement(sql1);
        stm.executeUpdate();
        PreparedStatement stm1 = connection.prepareStatement(sql2);
        stm1.executeUpdate();

        return "redirect:/p02/sub1";
    }
}
