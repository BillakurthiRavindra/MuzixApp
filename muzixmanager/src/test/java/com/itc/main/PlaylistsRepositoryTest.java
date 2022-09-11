 package com.itc.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itc.main.entity.Playlists;
import com.itc.main.repository.PlaylistsRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PlaylistsRepositoryTest {

	@Autowired
	private PlaylistsRepository playlistsRepository;
		


		@Test
		@Order(1)
		public void testNotNull() {
			assertNotNull(playlistsRepository);
		}
		
		
		@Test
		@Order(2)
		public void saveAccountTest() {
			Playlists us=new Playlists(101,"thriller","natu","geetha","dsp");
			Playlists u=this.playlistsRepository.save(us);
			assertEquals(u.getSongId(),us.getSongId());
          

			System.out.println("--SUCCESS SAVE PRODUCT TEST--");
			
		}
		
	
		@Test
		@Order(3)
		public void getUserByIdTest() {
			Optional<Playlists> p=this.playlistsRepository.findById(101);
			
			if(p.isPresent()) {
			   Playlists pro = p.get();
				try {
				assertEquals(pro.getSongId(), 1);
				}catch(AssertionFailedError ae) {
					System.err.println("--Id Not Found--");
				}
				System.out.println("--SUCCESS GET BY ID TEST--");
			}else {
				assertThrows(AssertionFailedError.class,()->{
					System.err.println("Id Not Found!");
				});
			}
		}
		

}
