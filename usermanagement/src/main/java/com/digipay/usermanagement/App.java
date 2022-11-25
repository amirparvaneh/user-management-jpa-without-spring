package com.digipay.usermanagement;


import ch.qos.logback.classic.Logger;
import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.model.entity.User;
import com.digipay.usermanagement.service.PermissionServiceImpl;
import com.digipay.usermanagement.service.RoleServiceImpl;
import com.digipay.usermanagement.service.UserServiceImpl;


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
                UserServiceImpl userService = new UserServiceImpl();
                RoleServiceImpl roleService = new RoleServiceImpl();
                System.out.println(" 1 = createUser \n 2 = deleteUser \n 3 = updateUser \n 4 = listAllUser ");
                Integer userChosen = scanner.nextInt();
                switch (userChosen) {
                    case 1: {
                        User user = new User();
                        System.out.println("Enter user name : ");
                        String name = scanner.next();
                        System.out.println("Enter user nationalID : ");
                        Long national = scanner.nextLong();
                        System.out.println("Enter user Role among the Role below :");
                        List<Role> roleList = new ArrayList<>();
                        roleList = roleService.findAll();
                        roleList.stream().forEach(Role::toString);
                        Long inputRoleId = scanner.nextLong();
                        Role role = new Role();
//                        role = roleService.findById(inputRoleId);
                        role.setId(inputRoleId);
                        user.setName(name);
                        user.setNationalID(national);
                        user.setRole(role);
                        userService.save(user);
                        return;
                    }

                    case 2: {
                        System.out.println("Enter User Id for deleting");
                        Long userInputId = scanner.nextLong();
                        userService.delete(userInputId);
                        System.out.println("user" + userInputId + "have been deleted");
                        return;
                    }
                    case 3: {
                        System.out.println("Enter user Id for updating : ");
                        Long userInputId = scanner.nextLong();
                        User user ;
                        user = userService.findById(userInputId);
                        System.out.println("your updating : "+ user.getName() + "with role : " + "" +
                                user.getRole());
                        System.out.println("Enter new User name :");
                        String newName = scanner.next();
                        System.out.println("Enter new User Role among the below role ");
                        List<Role> roleList;
                        roleList = roleService.findAll();
                        roleList.stream().forEach(Role::toString);
                        Long newIdForUpdateUser = scanner.nextLong();
                        user.setName(newName);
                        Role role = roleService.findById(newIdForUpdateUser);
                        user.setRole(role);
                        userService.update(userInputId,user);
                        return;
                    }

                    case 4: {
                        System.out.println("below list are all users");
                        List<User> userList = userService.findAll();
                        userList.stream().forEach(a -> System.out.println(a+"\n"));
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
                            System.out.println(permission.getId() + " -> " + permission.getTitle());
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
                        return;
                    }
                    case 2: {
                        System.out.println("Enter Role Id for deleting : ");
                        Long roleId = scanner.nextLong();
                        Role role = roleService.findById(roleId);
                        roleService.delete(roleId);
                        System.out.println(role.getTitle() + " have been deleted ");
                        return;
                    }
                    case 3: {
                        System.out.println("Enter Role Id for updating : ");
                        Long roleId = scanner.nextLong();
                        Role role = roleService.findById(roleId);
                        System.out.println("Enter new title for ");
                        String newRoleTitle = scanner.next();
                        role.setTitle(newRoleTitle);
                        return;
                    }
                    case 4: {
                        System.out.println("below are role list : ");
                        List<Role> roles ;
                        roles = roleService.findAll();
                        roles.stream().forEach(a -> System.out.println(a.getTitle()+"\n"));
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
                        return;
                    }
                    case 2: {
                        System.out.println("Enter permission ID : ");
                        Long permissionId = scanner.nextLong();
                        permissionService.deleteById(permissionId);
                        System.out.println("permission with id : " + permissionId + " have been deleted");
                        return;
                    }
                    case 3: {
                        System.out.println("Enter permission Id : ");
                        Long inputPermissionId = scanner.nextLong();
                        System.out.println("Enter new title : ");
                        String newTitle = scanner.next();
                        Permission permission = new Permission();
                        permissionService.save(permission);
                        System.out.println("permission with id : " + inputPermissionId + "have been updated with new title" +
                                newTitle);
                        return;
                    }
                    case 4: {
                        System.out.println("below are permission list : ");
                        List<Permission> permissionList ;
                        permissionList = permissionService.findAll();
                        permissionList.stream().forEach(Permission::toString);
                    }
                }
            }
        }
    }
}
