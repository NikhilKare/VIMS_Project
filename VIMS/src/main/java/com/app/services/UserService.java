package com.app.services;

import java.time.LocalDate;
import java.util.HashSet;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.StatusEnum;
import com.app.entities.User;
import com.app.entities.UserRoles;
import com.app.repository.IRolesRepository;
import com.app.repository.IUserRepository;

import DTO.UserDto;
import DTO.UserUpdate;

@Service
@Transactional
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepo;
	@Autowired
	IRolesRepository roleRepo;
	@Autowired
	ModelMapper mapper;
	
	@Override
	public User findByEmailAndPass(String email,String pass) {
		System.out.println(email+" "+pass);
		return userRepo.findByEmailAndPassword(email, pass);
	}
	@Override
	public boolean RegisterUser(UserDto u) {
		if(u==null) {
			return false;
		}
		User u1=mapper.map(u, User.class);
		u1.setStatus(StatusEnum.ACTIVE);
		HashSet<UserRoles> hs=new HashSet<UserRoles>();
		u.getRoles().forEach(i->hs.add(roleRepo.findByRoleName(i)));
		u1.setRoles(hs);
		u1.setDateCreated(LocalDate.now());
		userRepo.save(u1);
		return true;
	}
	@Override
	public boolean updatePasswrod(UserUpdate user1) {
		User user=userRepo.findByEmailAndPassword(user1.getEmail(),user1.getOldPass());
		if(user==null)
			return false;
		user.setPassword(user1.getNewPass());
		userRepo.save(user);
		return true;
	}
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}
	@Override
	public User getById(long userId) {
		User u=userRepo.getById(userId);
		u.getRoles();
		return u;
		
	}
}
