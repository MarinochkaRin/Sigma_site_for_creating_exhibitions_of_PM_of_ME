package com.mryndina.exhibitions.service;

import com.mryndina.exhibitions.entity.UserIdNameRole;
import com.mryndina.exhibitions.repository.UserIdNameRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserIdNameRoleService {
    private final int PAGE_SIZE = 10;

    private final UserIdNameRoleRepository userIdNameRoleRepository;

    public Page<UserIdNameRole> getAllUsers(int page) {
        return userIdNameRoleRepository.findAll(PageRequest.of(page, PAGE_SIZE));
    }
}

