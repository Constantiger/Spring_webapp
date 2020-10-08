//package com.example.webapp.service;
//
//import com.example.webapp.domain.Admin;
//import com.example.webapp.repos.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AdminService implements UserDetailsService {
//
//    @PersistenceContext
//    private EntityManager em;
//    @Autowired
//    AdminRepository adminRepository;
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin = adminRepository.findByUsername(username);
//
//        if (admin == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return (UserDetails) admin;
//    }
//
//    public Admin findUserById(Long userId) {
//        Optional<Admin> adminFromDb = adminRepository.findById(userId);
//        return adminFromDb.orElse(new Admin());
//    }
//
//    public List<Admin> allAdmins() {
//        return adminRepository.findAll();
//    }
//
//
//    public boolean saveAdmin(Admin admin) {
//        Admin adminFromDB = adminRepository.findByUsername(admin.getUsername());
//
//        if (adminFromDB != null) {
//            return false;
//        }
//        admin.setRoles(Collections.singleton(new Role(1L, "ROLE_ADMIN")));
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        adminRepository.save(admin);
//        return true;
//    }
//
//
//    public boolean deleteAdmin(Long adminId) {
//        if (adminRepository.findById(adminId).isPresent()) {
//            adminRepository.deleteById(adminId);
//            return true;
//        }
//        return false;
//    }
//
//    public List<Admin> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM Admin u WHERE u.id > :paramId", Admin.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
//}
