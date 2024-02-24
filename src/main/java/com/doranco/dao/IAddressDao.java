package com.doranco.dao;

import java.util.List;

import com.doranco.entity.uers.Address;

public interface IAddressDao {

	Address addAddress(Address address) throws Exception;

	Address getAddressById(Long id) throws Exception;

	List<Address> getAddresses() throws Exception;

	void updateAddress(Address address) throws Exception;

	void removeAddress(Long id) throws Exception;

}
