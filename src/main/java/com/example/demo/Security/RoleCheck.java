package com.example.demo.Security;

import org.springframework.stereotype.Component;
import com.example.demo.Model.Role;

@Component
public class RoleCheck {

    public void checkAdmin(Role role) {
        if (role != Role.ADMIN) {
            throw new RuntimeException("Access Denied");
        }
    }

    public void checkAnalyst(Role role) {
        if (role == Role.VIEWER) {
            throw new RuntimeException("Access Denied");
        }
    }
}