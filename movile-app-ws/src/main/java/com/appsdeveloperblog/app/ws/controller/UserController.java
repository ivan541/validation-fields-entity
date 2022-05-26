package com.appsdeveloperblog.app.ws.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("users") // http:/localhost:8080/users
public class UserController {
	Map<String, UserRest> users;
	
	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "Se llamo a Obtener Usuario con page = " + page + " y limit = " + limit;
		// get user was called with page and limit
	}

	@GetMapping(path = "/{userId}", 
				produces = { MediaType.APPLICATION_XML_VALUE, 
							 MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		/*UserRest usuario = new UserRest();
		usuario.setFirstName("Ivan");
		usuario.setLastName("Sojo");
		usuario.setEmail("ivan_541@hotmail.com");
		usuario.setUserId("1");*/
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

	/*
	 * @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE}) public UserRest getUser(@PathVariable
	 * String userId) {
	 * 
	 * UserRest usuario = new UserRest(); usuario.setFirstName("Ivan");
	 * usuario.setLastName("Sojo"); usuario.setEmail("ivan_541@hotmail.com");
	 * usuario.setUserId("1"); return usuario;
	 * }
	 */

	/*
	 * @GetMapping("/{userId}") public String getUser(@PathVariable String userId) {
	 * return "Se llamo a Obtener Usuario con userId = " + userId; // get user was
	 * called with userId }
	 */

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, 
			 				  MediaType.APPLICATION_JSON_VALUE },
				 consumes =  { MediaType.APPLICATION_XML_VALUE, 
						 	   MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest usuario = new UserRest();
		usuario.setFirstName(userDetails.getFirstName());
		usuario.setLastName(userDetails.getLastName());
		usuario.setEmail(userDetails.getEmail());
		
		String userId =  UUID.randomUUID().toString();
		usuario.setUserId(userId);
		
		if(users == null) {
			users = new HashMap<>();
		}
		
		users.put(userId, usuario);	
		
		return new ResponseEntity<UserRest>(usuario, HttpStatus.OK); // create user was called
	}

	@PutMapping
	public String updateUser() {
		return "Se llamo a Actualizacion Usuario"; // update user was called
	}

	@DeleteMapping
	public String deleteUser() {
		return "Se llamo a Eliminacion Usuario"; // delete user was called
	}

}
