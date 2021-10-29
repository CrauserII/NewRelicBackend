package com.example.demo;

import com.example.demo.dao.AppUserDAOImpl;
import org.junit.Assert;
import org.junit.Test;

public class AppUserDAOImplTest {

    @Test
    public void createSqlString(){
        //given
        //when
        String sql = AppUserDAOImpl.getSQlString(null,null,null,null);
        String sql2 = AppUserDAOImpl.getSQlString(10,"AA","Google","companyName");
        //then
//        Assert.assertEquals("SELECT * FROM appUser a LEFT JOIN company b on a.company_id=b.company_id "+
//                "WHERE (lastName LIKE '%%' OR firstName LIKE '%%') ORDER BY lastName LIMIT 10 OFFSET 0",sql.replaceAll("\\s+"," "));
//        Assert.assertEquals("SELECT * FROM appUser a LEFT JOIN company b on a.company_id=b.company_id "+
//                "WHERE (lastName LIKE '%AA%' OR firstName LIKE '%AA%') AND companyName LIKE 'Google' ORDER BY companyName LIMIT 10 OFFSET 10",sql2.replaceAll("\\s+"," "));

        Assert.assertEquals("SELECT * FROM appUser a LEFT JOIN company b on a.company_id=b.company_id "+
                "WHERE (lastName LIKE '%%' OR firstName LIKE '%%') ORDER BY lastName",sql.replaceAll("\\s+"," "));
        Assert.assertEquals("SELECT * FROM appUser a LEFT JOIN company b on a.company_id=b.company_id "+
                "WHERE (lastName LIKE '%AA%' OR firstName LIKE '%AA%') AND companyName LIKE 'Google' ORDER BY companyName",sql2.replaceAll("\\s+"," "));

    }

}
