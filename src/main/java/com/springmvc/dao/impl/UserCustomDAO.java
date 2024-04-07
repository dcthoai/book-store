package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.IUserCustomDAO;
import com.springmvc.mapper.MapperUserCustom;
import com.springmvc.model.UserCustom;

@Repository
public class UserCustomDAO extends AbstractDAO<UserCustom> implements IUserCustomDAO{
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public int insert(UserCustom user) {
		String sql = "INSERT INTO `bookstore`.`user` (`username`, "
												   + "`password`, "
												   + "`enabled`, "
												   + "`accountNonExpired`, "
												   + "`credentialsNonExpired`, "
												   + "`accountNonLocked`) "
												   + "VALUES (?, ?, ?, ?, ?, ?)";
		
		int isEnabled = user.isEnabled() ? 1 : 0;
		int isAccountNonExpired = user.isAccountNonExpired() ? 1 : 0;
		int isCredentialsNonExpired = user.isCredentialsNonExpired() ? 1 : 0;
		int isAccountNonLocked = user.isAccountNonLocked() ? 1 : 0;

		int userId = executeInsert(sql, user.getUsername(),
										user.getPassword(),
										isEnabled,
										isAccountNonExpired,
										isCredentialsNonExpired,
										isAccountNonLocked);
		if (userId > 0) {
			user.setUserId(userId);
			int insertStatus = roleDAO.insertAllUserRoles(user);
			
			if (insertStatus > 0)
				return userId;
			else
				return 0;
		}
		
		return 0;
	}

	@Override
	public int update(UserCustom user) {
		String sql = "UPDATE `bookstore`.`user` SET "
					+ "`username` = ?, "
					+ "`password` = ?, "
					+ "`enabled` = ?, "
					+ "`accountNonExpired` = ?, "
					+ "`credentialsNonExpired` = ?, "
					+ "`accountNonLocked` = ? WHERE (`id` = ?)";
		
		int isEnabled = user.isEnabled() ? 1 : 0;
		int isAccountNonExpired = user.isAccountNonExpired() ? 1 : 0;
		int isCredentialsNonExpired = user.isCredentialsNonExpired() ? 1 : 0;
		int isAccountNonLocked = user.isAccountNonLocked() ? 1 : 0;
		int userId = user.getUserId();
		
		int affectedRows = executeUpdate(sql, user.getUsername(),
											  user.getPassword(),
											  isEnabled,
											  isAccountNonExpired,
											  isCredentialsNonExpired,
											  isAccountNonLocked,
											  userId);

		if (affectedRows > 0) {
			int deleteStatus = roleDAO.deleteAllUserRoles(userId);
			
			if (deleteStatus > 0) {
				int insertStatus = roleDAO.insertAllUserRoles(user);
				
				if (insertStatus > 0)
					return 1;
				else
					return 0;
			} else {
				return 0;
			}
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`user` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		roleDAO.deleteAllUserRoles(id);
		
		return affectedRows;
	}

	@Override
	public UserCustom getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE (`id` = ?)";
		
		List<UserCustom> listUsers = executeQuery(sql, new MapperUserCustom(roleDAO), id);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public UserCustom getUserByUsername(String username) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE (`username` = ?)";
		
		List<UserCustom> listUsers = executeQuery(sql, new MapperUserCustom(roleDAO), username);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}
}
