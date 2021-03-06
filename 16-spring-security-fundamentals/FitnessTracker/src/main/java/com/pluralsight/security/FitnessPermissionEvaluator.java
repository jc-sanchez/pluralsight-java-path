package com.pluralsight.security;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;
import java.io.Serializable;

/**
 * Created by jsssn on 23-May-17.
 */
public class FitnessPermissionEvaluator implements PermissionEvaluator {

    private DataSource datasource;

    public DataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        JdbcTemplate template = new JdbcTemplate(datasource);

        Object [] args = {((User)authentication.getPrincipal()).getUsername(),
                targetDomainObject.getClass().getName(),
                permission.toString()};

        int count = template.queryForObject("SELECT COUNT(*) FROM permissions p WHERE " +
                "p.username = ? and p.target = ? and p.permission = ?", args, Integer.class);

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
