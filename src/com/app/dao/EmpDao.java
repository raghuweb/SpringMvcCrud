package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.app.beans.Emp;

public class EmpDao {
	JdbcTemplate template;// JdbcTemplate template

	// Save:
	public int save(Emp p) {
		String sql = "insert into Emp99(name,salary,designation) values('"
				+ p.getName() + "'," + p.getSalary() + ",'"
				+ p.getDesignation() + "')";
		return template.update(sql);
	}

	// Update:
	public int update(Emp p) {
		String sql = "update Emp99 set name='" + p.getName() + "',salary="
				+ p.getSalary() + ",designation='" + p.getDesignation()
				+ "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// Delete:
	public int delete(int id) {
		String sql = "";
		return template.update(sql);
	}// delete

	// getById:
	public Emp getEmpById(int id) {
		String sql = "";
		return template.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	// List of All:
	public List<Emp> getEmployees() {
		return template.query("select * from Emp99", new RowMapper<Emp>() {

			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}// mapRow

		});// query

	}// getEmployees
	/*
	 * public JdbcTemplate getTemplate() { return template; }
	 */

}// EmpDao class
