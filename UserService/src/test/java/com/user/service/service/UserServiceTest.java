package com.user.service.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.user.service.entities.User;
import com.user.service.repositories.UserRepository;
import com.user.service.request.dto.UserRequestDto;
import com.user.service.response.dto.UserResponseDto;
import com.user.service.services.impl.UserServiceImpl;

@SpringBootTest
@SuppressWarnings("unchecked")
public class UserServiceTest<T> {

	@InjectMocks
	private UserServiceImpl<T> userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ModelMapper modelMapper;
	
	private List<User> users;
	private User user;
	private UserResponseDto userResponseDto;
	private UserRequestDto userRequestDto;
	
	@BeforeEach
	void setUp() {
		users = Stream
				.of(new User("3855a7f1-3ff9-439a-9afc-112366cc1303", "test1", "test1@dev.in", "test1", "test1", "indore", "ROLE_NORMAL", false, null),
				new User("3855a7f1-3ff9-439a-9afc-112366cc1303", "test2", "test2@dev.in", "test2", "test2", "indore", "ROLE_NORMAL", false, null))
				.collect(Collectors.toList());
		userRequestDto = new UserRequestDto("Test 1", "test1@dev.in", "test1", "test1", "indore");
		user = new  User("3855a7f1-3ff9-439a-9afc-112366cc1303", "test1", "test1@dev.in", "test1", "test1", "indore", "ROLE_NORMAL", false, null);
		userResponseDto = new UserResponseDto("3855a7f1-3ff9-439a-9afc-112366cc1303", "Test 1", "test1@dev.in", "test1", "indore", new ArrayList<>());
	}
	
	@Test
	@DisplayName("test_get_all_users")
	void getAllUsersTest() {
		when(userRepository.findAll()).thenReturn(users);
		List<User> allUsers = (List<User>) this.userService.getAllUsers();
		assertEquals(2, allUsers.size());
	}
	
//	@Test
//	@DisplayName("test_get_user_By_id")
//	void getUserByIdTest() {
//		String userId = "3855a7f1-3ff9-439a-9afc-112366cc1303";
//		when(this.userRepository.findById(userId)).thenReturn(Optional.of(user));
//		UserResponseDto user2 = (UserResponseDto) this.userService.getUserById(userId);
//		assertEquals(userResponseDto, user2);
//	}
//	
//	@Test
//	@DisplayName("test_delete_user")
//	void testDeleteUser() {
//		
//		when(userRepository.findById("3855a7f1-3ff9-439a-9afc-112366cc1303")).thenReturn(Optional.of(user));
////		doNothing().when(this.userRepository).delete(user);
//		UserResponseDto actualResult =  (UserResponseDto) this.userService.deleteUser(user.getId());
//		assertEquals("3855a7f1-3ff9-439a-9afc-112366cc1303", actualResult.getId());
//		assertEquals("test1@dev.in", actualResult.getEmail());
//		
//	}
//	
//	@Test
//	@DisplayName("test_create_user")
//	void testCreateUser() {
//		when(userRepository.save(user)).thenReturn(user);
//		UserResponseDto createUser = (UserResponseDto) this.userService.registerUser(userRequestDto);
//		assertThat(createUser).isNotNull();
////		assertThat(createUser.getUserId()).isGreaterThan("0");
//		assertTrue(createUser.getId().length() > 0 );
//	}
}
