package com.example.demo.dao;

import com.example.demo.model.AppCompany;
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
public class AppCompanyDAOImpl extends JdbcDaoSupport implements AppCompanyDAO{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<AppCompany> getAllCompanies() {
        String sql = "SELECT * FROM company ORDER BY companyName";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<AppCompany> result = new ArrayList<AppCompany>();
        for (Map<String, Object> row : rows) {
            AppCompany company = new AppCompany();
            company.setCompanyName((String) row.get("companyName"));
            company.setCompany_id((Integer) row.get("company_id"));

            result.add(company);
        }

        return result;
    }

    @Override
    public void insertAppCompany(AppCompany appCompany) {
        String sql = "INSERT INTO company " + "(companyName) VALUES (?)";
        getJdbcTemplate().update(sql, new Object[] {
                appCompany.getCompanyName()});

    }
}
