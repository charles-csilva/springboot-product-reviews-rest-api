package com.charlessilva.customerreview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlessilva.customerreview.model.UserModel;

public interface UserDao extends JpaRepository<UserModel, Long> {
}
