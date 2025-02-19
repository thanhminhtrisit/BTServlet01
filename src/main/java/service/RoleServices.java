package service;

import java.util.List;

import entity.RoleEntity;
import repository.RoleRepository;

public class RoleServices {
	private RoleRepository roleRepository = new RoleRepository();

	public List<RoleEntity> getRole() {
		List<RoleEntity> entities = roleRepository.findAll();
		return entities;
	}

	public boolean insertRole(String roleName, String description) {
		return roleRepository.insertRole(roleName, description) > 0;
	}

	public boolean deleteRole(int id) {
		return roleRepository.deleteRole(id) > 0;
	}

	public boolean updateRole(int id, String roleName, String description) {
		return roleRepository.updateRole(id, roleName, description) > 0;
	}

	public RoleEntity getRoleById(int id) {
		return roleRepository.findById(id);
	}
}
