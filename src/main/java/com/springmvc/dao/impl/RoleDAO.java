package com.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.IRoleDAO;
import com.springmvc.mapper.MapperRole;
import com.springmvc.model.Role;
import com.springmvc.model.UserCustom;

@Repository
public class RoleDAO extends AbstractDAO<Role> implements IRoleDAO{

	@Override
	public int insert(Role role) {
		String sql = "INSERT INTO `bookstore`.`role` (`userId`, `isEnabled`, `authority`, `createdBy`) VALUES (?, ?, ?, ?)";
		
		int roleId = executeInsert(sql, role.getUserId(),
										role.getIsEnabled(),
										role.getAuthority(),
										role.getCreatedBy());
		
		return roleId;
	}

	@Override
	public int update(Role role) {
		String sql = "UPDATE `bookstore`.`role` SET "
					+ "`userId` = ?, `isEnabled` = ?, `authority` = ?, `modifiedBy` = ? WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, role.getUserId(),
											  role.getIsEnabled(),
											  role.getAuthority(),
											  role.getModifiedBy(),
											  role.getId());
		
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`role` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public int insertAllUserRoles(UserCustom user) {
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>(user.getAuthorities());
		int userId = user.getUserId(), affectedRows = 0;
		String username = user.getUsername();
		
		for (GrantedAuthority grantedAuthority : listAuthorities) {
			String authority = grantedAuthority.getAuthority();
			
			Role role = new Role();
			role.setUserId(userId);
			role.setIsEnabled(1);
			role.setAuthority(authority);
			role.setCreatedBy(username);
			
			int roleId = this.insert(role);
			
			if (roleId <= 0)
				return 0;
			else
				affectedRows += 1;
		}
		
		if(affectedRows == listAuthorities.size())
			return 1;
		return 0;
	}

	@Override
	public int deleteAllUserRoles(int userId) {
		List<Role> listUserRoles = this.getAllUserRoles(userId);
		int affectedRows = 0;
		
		for (Role role : listUserRoles) {
			int status = this.delete(role.getId());
			
			if(status > 0)
				affectedRows += 1;
			else
				return 0;
		}
	
		if(affectedRows == listUserRoles.size())
			return 1;
		return 0;
	}

	@Override
	public Role getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`role` WHERE(`id` = ?)";
		
		List<Role> listUserRoles = executeQuery(sql, new MapperRole(), id);
		return listUserRoles.isEmpty() ? null : listUserRoles.get(0);
	}

	@Override
	public List<Role> getAllUserRoles(int userId) {
		String sql = "SELECT * FROM `bookstore`.`role` WHERE(`userId` = ?)";
		
		List<Role> listUserRoles = executeQuery(sql, new MapperRole(), userId);
		return listUserRoles;
	}
}