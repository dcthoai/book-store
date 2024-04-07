package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IAdminDAO;
import com.springmvc.mapper.MapperAdmin;
import com.springmvc.model.Admin;

@Repository
public class AdminDAO extends AbstractDAO<Admin> implements IAdminDAO{

	@Override
	public int insert(Admin admin) {
		String sql = "INSERT INTO `bookstore`.`admin` (`userId`, `fullname`, `phone`, `email`, `createdBy`) "
						+ "VALUES (?, ?, ?, ?, ?)";
		
		int adminId = executeInsert(sql, admin.getUserId(),
										 admin.getFullname(),
										 admin.getPhone(),
										 admin.getEmail(),
										 admin.getCreatedBy());
		
		return adminId;
	}

	@Override
	public int update(Admin admin) {
		String sql = "UPDATE `bookstore`.`admin` SET (`userId` = ?, `fullname` = ?, `phone` = ?, `email` = ?, `modifiedBy`) "
					+ "WHERE (`id` = ?)";

		int affectedRows = executeInsert(sql, admin.getUserId(),
											  admin.getFullname(),
											  admin.getPhone(),
											  admin.getEmail(),
											  admin.getModifiedBy(),
											  admin.getId());
		
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE `bookstore`.`admin` WHERE(`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}

	@Override
	public Admin getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`admin` WHERE(`id` = ?)";
		
		List<Admin> listAdmins = executeQuery(sql, new MapperAdmin(), id);
		return listAdmins.isEmpty() ? null : listAdmins.get(0);
	}
}
