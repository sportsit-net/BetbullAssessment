package com.player.market;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.player.market.dto.ContractFee;
import com.player.market.model.Player;
import com.player.market.model.PlayerTeamMapper;
import com.player.market.model.Team;
import com.player.market.service.PlayerMarketService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class PlayerMarketApplicationTests {
	@Mock
	private PlayerMarketService playerMarketService;

	@Test
	public void whenplayeriscreted_thenretrivetheplayer() {
		Mockito.when(playerMarketService.getTeamByPlayerId(Long.valueOf(1)))
				.thenReturn(new Team(Long.valueOf(1), "AJROCKS", "INR", 10.0));
		Team t = playerMarketService.getTeamByPlayerId(Long.valueOf(1));
		Assert.assertEquals("AJROCKS", t.getName());
		Assert.assertEquals(Long.valueOf(1), t.getId());
		Assert.assertEquals("INR", t.getCurrency());
		Assert.assertEquals(10.0, t.getCommission(), 10.0);
		System.out.println("whenplayeriscreted_thenretrivetheplayer success");
	}

	@Test
	public void whenteamiscreted_thenretrivetheteam() {
		ArrayList<Player> plist = new ArrayList<Player>();
		plist.add(new Player(Long.valueOf(1), "JAY", LocalDate.of(1989, 03, 23), LocalDate.of(2010, 12, 9)));
		plist.add(new Player(Long.valueOf(1), "JAY", LocalDate.of(1991, 07, 21), LocalDate.of(2012, 12, 24)));
		Mockito.when(playerMarketService.getAllPlayers()).thenReturn(plist);
		ArrayList<Player> result = playerMarketService.getAllPlayers();
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void whenplayerismapped_thenretrivethemapping() {
		ArrayList<PlayerTeamMapper> plist = new ArrayList<PlayerTeamMapper>();
		plist.add(new PlayerTeamMapper(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1)));
		plist.add(new PlayerTeamMapper(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1)));
		Mockito.when(playerMarketService.getAllPlayerTeamMappings()).thenReturn(plist);
		ArrayList<PlayerTeamMapper> result = (ArrayList<PlayerTeamMapper>) playerMarketService
				.getAllPlayerTeamMappings();
		Assert.assertEquals(2, result.size());
		System.out.println("whenteamiscreted_thenretrivetheteam:" + plist.toString());
	}

	@Test
	public void whenplayerismapped_thenretrivetheteambyplayerid() {
		ArrayList<Team> plist = new ArrayList<Team>();
		plist.add(new Team(Long.valueOf(1), "AJROCKS", "INR", 10.0f));
		plist.add(new Team(Long.valueOf(2), "ROCKANDROLL", "INR", 10.0f));
		Mockito.when(playerMarketService.getTeamsByPlayerId(new ArrayList<Long>(Arrays.asList(1L, 2L, 3L))))
				.thenReturn(plist);
		ArrayList<Team> result = (ArrayList<Team>) playerMarketService
				.getTeamsByPlayerId(new ArrayList<Long>(Arrays.asList(1L, 2L, 3L)));
		Assert.assertEquals(2, result.size());
		System.out.println("whenteamiscreted_thenretrivetheteam:" + plist.toString());
	}

	@Test
	public void whenplayeriscreted_thenupdatetheplayer() {
		Mockito.when(playerMarketService.createUpdateTeam(new Team(Long.valueOf(1), "AJROCKS", "INR", 10.0)))
				.thenReturn(new Team(Long.valueOf(1), "AJROCKS", "INR", 10.0));
		Team t = playerMarketService.createUpdateTeam(new Team(Long.valueOf(1), "AJROCKS", "INR", 10.0));
		Assert.assertEquals("AJROCKS", t.getName());
		Assert.assertEquals(Long.valueOf(1), t.getId());
		Assert.assertEquals("INR", t.getCurrency());
		Assert.assertEquals(10.0, t.getCommission(), 10.0);
		System.out.println("whenplayeriscreted_thenupdatetheplayer success");
	}

	@Test
	public void whenteamiscreted_thenupdatetheteam() {
		Mockito.when(playerMarketService.createUpdatePlayer(
				new Player(Long.valueOf(1), "JAY", LocalDate.of(1989, 03, 23), LocalDate.of(2010, 12, 9))))
				.thenReturn(new Player(Long.valueOf(1), "JAY", LocalDate.of(1989, 03, 23), LocalDate.of(2010, 12, 9)));
		Player p = playerMarketService.createUpdatePlayer(
				new Player(Long.valueOf(1), "JAY", LocalDate.of(1989, 03, 23), LocalDate.of(2010, 12, 9)));
		Assert.assertEquals("JAY", p.getName());
	}

	@Test
	public void whenplayeriscreted_thendeletetheplayer() {
		Mockito.when(playerMarketService.deletePlayer(Long.valueOf(1))).thenReturn("SUCCESS");
		String result = playerMarketService.deletePlayer(Long.valueOf(1));
		Assert.assertEquals("SUCCESS", result);
	}

	@Test
	public void whenteamiscreted_thendeletetheteam() {
		Mockito.when(playerMarketService.deleteTeam(Long.valueOf(1))).thenReturn("SUCCESS");
		String result = playerMarketService.deleteTeam(Long.valueOf(1));
		Assert.assertEquals("SUCCESS", result);
	}

	@Test
	public void getcontractForplayer() {
		Mockito.when(playerMarketService.playerContractFee(Long.valueOf(1)))
				.thenReturn(new ContractFee(800000.00, "INR"));
		ContractFee result = playerMarketService.playerContractFee(Long.valueOf(1));
		Assert.assertEquals(3, result.getCurrency().length());
		Assert.assertEquals("INR", result.getCurrency());

	}

}
