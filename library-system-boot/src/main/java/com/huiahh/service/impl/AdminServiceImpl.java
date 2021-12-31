package com.huiahh.service.impl;

import com.huiahh.mapper.AdminMapper;
import com.huiahh.pojo.Admin;
import com.huiahh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int createAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int deleteAdminById(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public List<Admin> selectAdmins() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin selectAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin validateUserAndPassword(Admin admin) {
        Admin queryed = adminMapper.selectByUser(admin.getUser());
        if (queryed.getPwd().equals(admin.getPwd())) {
            return queryed;
        }
        return null;
    }
}
