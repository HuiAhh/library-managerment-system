package com.huiahh.service;

import com.huiahh.pojo.Admin;

import java.util.List;

public interface AdminService {
    int createAdmin(Admin admin);

    int deleteAdminById(Integer id);

    int updateAdmin(Admin admin);

    List<Admin> selectAdmins();

    Admin selectAdminById(Integer id);

    Admin validateUserAndPassword(Admin admin);
}
