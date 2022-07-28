package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		long customer_Id = resultSet.getLong("customer_Id");
		long itemId = resultSet.getLong("item_Id");
		Integer quantity = resultSet.getInt("quantity");
		float price = resultSet.getFloat("price");		
		return new Order(id, customer_Id, itemId, quantity, price);
	}
	
	@Override
	public List<Order> readAll() {
	       try (Connection connection = DBUtils.getInstance().getConnection();
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
	            List<Order> orders = new ArrayList<>();
	            while (resultSet.next()) {
	                orders.add(modelFromResultSet(resultSet));
	            }
	            return orders;
	        } catch (SQLException e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return new ArrayList<>();
	}

	private Order readLatest() {
	   	try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY id DESC LIMIT 1");) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
	 		return null;
	}
	
	@Override
	public Order create(Order orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO order_items (customer_id) VALUES (?)");) {
            statement.setLong(1, orders.getCustomerId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
	}

	@Override
	public Order read(Long id) {
    	try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
				.prepareStatement("UPDATE order_items SET id = ?, customer_id = ? WHERE id = ?");) {
			statement.setLong(1, orders.getId());
			statement.setLong(2, orders.getCustomerId());
			statement.setLong(3, orders.getId());
			statement.executeUpdate();
			return read(orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orders) {
	  	try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE id = ?");) {
			statement.setLong(1, orders);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

}
