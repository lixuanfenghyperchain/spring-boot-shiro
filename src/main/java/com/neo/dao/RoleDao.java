package com.neo.dao;

import com.neo.model.SysRole;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<SysRole, Integer> {

}