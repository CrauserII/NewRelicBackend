package com.example.demo.dao;

import com.example.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AppUserDAOImpl extends JdbcDaoSupport implements AppUserDAO{
    private static int limit = 10;
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public static String getSQlString(Integer offset, String search,String company, String order){
        offset = offset != null?offset:0;
        search = search != null?search:"";
        String adtCompany= (company ==null || company.equalsIgnoreCase("All"))?"":" AND companyName LIKE '"+company+"'";
        order = order==null?" ORDER BY lastName":" ORDER BY "+order;
        return "SELECT * FROM appUser a LEFT JOIN company b on a.company_id=b.company_id "+
                "WHERE (lastName LIKE '%"+search+"%' OR firstName LIKE '%"+search+"%') "+
                adtCompany +
                order;
//                " LIMIT "+limit+
//                " OFFSET "+offset;
    }

    @Override
    public List<AppUser> getAllEmployees(Integer offset, String search,String company, String order) {
        String sql = getSQlString(offset,search,company,order);

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<AppUser> result = new ArrayList<AppUser>();
        for (Map<String, Object> row : rows) {
            AppUser emp = new AppUser();
            emp.setLastName((String) row.get("lastName"));
            emp.setFirstName((String) row.get("firstName"));
            emp.setCompany_name((String) row.get("companyName"));
            result.add(emp);
        }

        return result;
    }

    @Override
    public void insertAppUser(AppUser appUser) {
        String sql = "INSERT INTO appUser " + "(lastName,firstName,company_id) VALUES (?, ?,?)";
        getJdbcTemplate().update(sql, new Object[] {
                appUser.getLastName(),appUser.getFirstName(),appUser.getCompany_id()});

    }
}
