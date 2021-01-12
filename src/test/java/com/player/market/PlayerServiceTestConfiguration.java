package com.player.market;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.player.market.service.PlayerMarketService;

@Profile("test")
@Configuration
public class PlayerServiceTestConfiguration {
	@Bean
	@Primary
	public PlayerMarketService playerMarketService() {
		return Mockito.mock(PlayerMarketService.class);
	}

}
