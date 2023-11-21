package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

@SpringBootApplication
@RestController
public class App {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // 20210404
    
    @GetMapping("/holiday/{holiday}")
    public String getHolidayDate(@PathVariable String holiday) {
        SqlRowSet srs = findByHolidayDate(holiday);
        
        List<JSONObject> holiday_list = new ArrayList<JSONObject>();
        

        while(srs.next()) {
            JSONObject jsonObject = new JSONObject();
            //jsonObject.put("id", srs.getString("ID"));
            jsonObject.put("date", srs.getString("Date"));
            jsonObject.put("holiday_name", srs.getString("HOLIDAY_NAME"));
            jsonObject.put("jurisdiction", srs.getString("JURISDICTION"));
            
            holiday_list.add(jsonObject);
            
        }
        return String.format(holiday_list.toString());
    }
    
    /**
     * date: <yyyyMMdd> : 20141026
     */
    public SqlRowSet findByHolidayDate(String date) {

        // TODO: clean input data
        String sql = "SELECT * FROM HOLIDAY_INFO WHERE DATE = '" + date + "'";
        return jdbcTemplate.queryForRowSet(sql);

    }

}