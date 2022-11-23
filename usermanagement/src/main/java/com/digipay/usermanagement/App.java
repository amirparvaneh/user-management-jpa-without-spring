package com.digipay.usermanagement;


import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.service.PermissionServiceImpl;
import com.digipay.usermanagement.service.RoleServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter an operation ? ");
        System.out.println(" 1 = User Operation \n 2 = Role Operation \n 3 = Permission Operation");
        Integer inputOperation = scanner.nextInt();
        switch (inputOperation) {
            case 1: {
                System.out.println(" 1 = createUser \n 2 = deleteUser \n 3 = updateUser \n 4 = listAllUser ");
                Integer userChosen = scanner.nextInt();
                switch (userChosen) {
                    case 1: {

                    }

                    case 2: {

                    }
                    case 3: {
                    }
                    case 4: {
                    }
                }
            }
            case 2: {
                System.out.println(" 1 = Role create \n 2 = deleteRole \n  3 = updateRole \n 4 = listAllRole ");
                RoleServiceImpl roleService = new RoleServiceImpl();
                Integer roleOperation = scanner.nextInt();
                switch (roleOperation) {
                    case 1: {
                        Role role = new Role();
                        System.out.println("Enter Role Title :");
                        String roleTile = scanner.next();
                        PermissionServiceImpl permissionService = new PermissionServiceImpl();
                        List<Permission> permissions = permissionService.findAll();
                        for (Permission permission : permissions) {
                            System.out.println(permission.getId() + "##" + permission.getTitle());
                        }
                        String inputPermission = scanner.next();
                        String[] split = inputPermission.split(",");
                        List<Long> permissionIDList = new ArrayList<>();
                        List<Permission> permissionList = new ArrayList<>();
                        for (String item : split) {
                            permissionIDList.add(Long.parseLong(item));
                        }
                        for (Long permissionId : permissionIDList) {
                            Permission permission = new Permission();
                            permission.setId(permissionId);
                            permissionList.add(permission);
                        }
                        role.setPermission(permissionList);
                        role.setTitle(roleTile);
                        roleService.save(role);
                    }
                    case 2: {

                    }
                    case 3: {
                    }
                    case 4: {
                    }
                }
            }

            case 3: {
                System.out.println(" 1 = permission create \n 2 = deletePermission \n  3 = updatePermission \n 4 = listAllPermission ");
                PermissionServiceImpl permissionService = new PermissionServiceImpl();
                Integer permissionOperation = scanner.nextInt();
                switch (permissionOperation) {
                    case 1: {
                        System.out.println("Enter Permission Title :");
                        String title = scanner.next();
                        Permission permission = new Permission();
                        permission.setTitle(title);
                        permissionService.save(permission);
                    }
                    case 2: {

                    }
                    case 3: {

                    }
                    case 4: {

                    }
                }
            }
        }
    }
}
