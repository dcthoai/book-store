package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Voucher;

public class MapperVoucher implements RowMapper<Voucher>{

	@Override
	public Voucher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voucher voucher = new Voucher();
		
		voucher.setId(rs.getInt("voucherID"));
		voucher.setQuantity(rs.getInt("quantity"));
		
		voucher.setVoucherCode(rs.getString("voucherCode"));
		voucher.setVoucherName(rs.getString("voucherName"));
		voucher.setDescriptions(rs.getString("descriptions"));
		
		voucher.setPriceMaximumApplied(rs.getLong("priceMaximumApplied"));
		voucher.setPriceMinimumApplied(rs.getLong("priceMinimumApplied"));
		
		voucher.setDiscount(rs.getFloat("discount"));
		voucher.setExpirationDate(rs.getTimestamp("expirationDate"));
		
		return voucher;
	}

}
