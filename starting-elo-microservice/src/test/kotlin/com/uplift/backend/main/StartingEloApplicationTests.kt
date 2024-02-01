package com.uplift.backend.main

import com.uplift.backend.dao.CalculateStartingELO
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

/**
 * This class tests the functions of the microservices
 * with a variety of different users.
 *
 * @author David
 */
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
	
	/**
	 * This function tests if a users ELO comes back as an integer.
	 */
	@Test
	fun calculateMethodBasicTest() {
		// println(usr1StartingELO)
		assertInstanceOf(Integer::class.java, usr1StartingELO)
	}
	
	/**
	 * This function tests if a second users ELO comes back as an integer.
	 */
	@Test
	fun calculateUsr2FemaleELO() {
		// println(usr2FemaleStartingELO)
		assertInstanceOf(Integer::class.java, usr2FemaleStartingELO)
	}
	
	/**
	 * This function tests if a second users ELO
	 * returns higher than the first.
	 */
	@Test
	fun calculateUsr1GreaterThanUsr2() {
		// println("usr1: $usr1StartingELO usr2: $usr2FemaleStartingELO")
		assertTrue(usr1StartingELO > usr2FemaleStartingELO)
	}
	
	/**
	 *  This function tests two male lifters with the same
	 *  numbers but with a different weight.
	 */
	@Test
	fun calculateSameNumbersDifferentWeightDifference() {
		println("usr1: $usr1StartingELO usr2: $usr1HeavyStartingELO")
		assertTrue(usr1StartingELO > usr1HeavyStartingELO)
	}
	
	/**
	 *  This function tests two female lifters with the same
	 *  numbers but with a different weight.
	 */
	@Test
	fun calculateSameNumbersDifferentWeightDifferenceFemale() {
		// println("usr1: $usr2FemaleStartingELO usr2: $usr2FemaleHeavyStartingELO")
		assertTrue(usr2FemaleStartingELO > usr2FemaleHeavyStartingELO)
	}
	
	/**
	 *  This function tests two male lifters with the same numbers
	 *  but at a different age.
	 */
	@Test
	fun oldMaleTest() {
		// println("usr1: $usr1StartingELO usr2: $usr1OldStartingELO")
		assertTrue(usr1OldStartingELO > usr1StartingELO)
	}
	
	/**
	 *  This function tests two female lifters with the same numbers
	 *  but at a different age.
	 */
	@Test
	fun oldFemaleMaleTest() {
		// println("usr1: $usr2FemaleStartingELO usr2: $usr2FemaleOldStartingELO")
		assertTrue(usr2FemaleOldStartingELO > usr2FemaleStartingELO)
	}
}
