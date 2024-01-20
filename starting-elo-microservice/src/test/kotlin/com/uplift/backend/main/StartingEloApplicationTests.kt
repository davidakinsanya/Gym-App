package com.uplift.backend.main

import com.uplift.backend.dao.CalculateStartingELO
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StartingEloApplicationTests {
	
	private final val calcUsr1 = CalculateStartingELO(TestUsers.usr1)
	val usr1StartingELO = calcUsr1.calculate()
	
	private final val calcUsr2Female = CalculateStartingELO(TestUsers.usr2Female)
	val usr2FemaleStartingELO = calcUsr2Female.calculate()
	
	private final val calcUsr1Heavy = CalculateStartingELO(TestUsers.usr1Heavy)
	val usr1HeavyStartingELO = calcUsr1Heavy.calculate()
	
	private final val calcUsr1Old = CalculateStartingELO(TestUsers.usr1Old)
	val usr1OldStartingELO = calcUsr1Old.calculate()
	
	private final val calcUsr2FemaleOld = CalculateStartingELO(TestUsers.usr2FemaleOld)
	val usr2FemaleOldStartingELO = calcUsr2FemaleOld.calculate()
	
	private final val calcUsr2FemaleHeavy = CalculateStartingELO(TestUsers.usr2FemaleHeavy)
	val usr2FemaleHeavyStartingELO = calcUsr2FemaleHeavy.calculate()
	
	
	@Test
	fun calculateMethodBasicTest() {
		assertInstanceOf(Integer::class.java, usr1StartingELO)
	}
	
	@Test
	fun calculateUsr2FemaleELO() {
		assertInstanceOf(Integer::class.java, usr2FemaleStartingELO)
	}
	
	@Test
	fun calculateUsr2GreaterThanUsr1() {
		// println("usr1: $usr1StartingELO usr2: $usr2FemaleStartingELO")
		assertTrue(usr2FemaleStartingELO > usr1StartingELO)
	}
	
	@Test
	fun calculateSameNumbersDifferentWeightDifference() {
		// println("usr1: $usr1StartingELO usr2: $usr1HeavyStartingELO")
		assertTrue(usr1StartingELO > usr1HeavyStartingELO)
	}
	
	@Test
	fun calculateSameNumbersDifferentWeightDifferenceFemale() {
		// println("usr1: $usr2FemaleStartingELO usr2: $usr2FemaleHeavyStartingELO")
		assertTrue(usr2FemaleStartingELO > usr2FemaleHeavyStartingELO)
	}
	
	@Test
	fun oldMaleTest() {
		// println("usr1: $usr1StartingELO usr2: $usr1OldStartingELO")
		assertTrue(usr1OldStartingELO > usr1StartingELO)
	}
	
	@Test
	fun oldFemaleMaleTest() {
		// println("usr1: $usr2FemaleStartingELO usr2: $usr2FemaleOldStartingELO")
		assertTrue(usr2FemaleOldStartingELO > usr2FemaleStartingELO)
	}
}
