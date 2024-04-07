package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Voucher;

public class MapperVoucher implements RowMapper<Voucher>{

	@Override
	public Voucher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voucher voucher = new Voucher();
		
		voucher.setId(rs.getInt("id"));
		
        voucher.setTitle(rs.getString("title"));
        voucher.setCode(rs.getString("code"));
        voucher.setDescription(rs.getString("description"));
        voucher.setDiscount(rs.getFloat("discount"));
        voucher.setQuantity(rs.getInt("quantity"));
        
        voucher.setPriceMinimumApplied(rs.getLong("priceMinimumApplied"));
        voucher.setPriceMaximumApplied(rs.getLong("priceMaximumApplied"));
        voucher.setExpirationDate(rs.getTimestamp("expirationDate"));
        
        voucher.setCreatedDate(rs.getTimestamp("createdDate"));
        voucher.setModifiedDate(rs.getTimestamp("modifiedDate"));
        voucher.setCreatedBy(rs.getString("createdBy"));
        voucher.setModifiedBy(rs.getString("modifiedBy"));
		
		return voucher;
	}

}
