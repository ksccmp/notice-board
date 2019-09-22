package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import board.dto.Customer;

@Repository
public class BoardDAO {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public BoardDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("customerinformation");
	}
	
	public void insert(Customer customer) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(customer);
		insertAction.execute(params);
	}
	
	public boolean login(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		List<Customer> customer = jdbc.query("select password from customerinformation where id=:id", map, BeanPropertyRowMapper.newInstance(Customer.class));
		return password.equals(customer.get(0).getPassword()) ? true : false;
	}
}
