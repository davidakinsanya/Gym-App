package com.uplift.backend.main

import dao.CalculateStartingELO
import dto.Gender
import com.uplift.backend.dto.StartingELO
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StartingEloApplicationTests {
	
	val usr1: StartingELO = StartingELO(
		gender = Gender.MALE,
		age = 18,
		dob = listOf("01", "01", "1998"),
		weight = 55.2F,
		yearsLifting = 2,
		squatMax = 180F,
		benchMax = 95F,
		deadLiftMax = 180F
	)
	
	val usr2: StartingELO = StartingELO(
		gender = Gender.FEMALE,
		age = 31,
		dob = listOf("01", "01", "1998"),
		weight = 62.2F,
		yearsLifting = 2,
		squatMax = 110F,
		benchMax = 70F,
		deadLiftMax = 130F
	)
	
	val usr3: StartingELO = StartingELO(
		gender = Gender.MALE,
		age = 18,
		dob = listOf("01", "01", "1998"),
		weight = 70.2F,
		yearsLifting = 2,
		squatMax = 180F,
		benchMax = 95F,
		deadLiftMax = 180F
	)
	
	
	@Test
	fun calculateMethodBasicTest() {
		val calcUsr1 = CalculateStartingELO(usr1)
		val usr1StartingELO = calcUsr1.calculate()
		
		println(usr1StartingELO)
		assertInstanceOf(Integer::class.java, calcUsr1.calculate())
	}
	
	@Test
	fun calculateUsr2ELO() {
		val calcUsr2 = CalculateStartingELO(usr2)
		val usr2StartingELO = calcUsr2.calculate()
		
		println(usr2StartingELO)
		assertInstanceOf(Integer::class.java, usr2StartingELO)
	}
	
	@Test
	fun calculateUsr1GreaterThanUsr2() {
		val calcUsr1 = CalculateStartingELO(usr1)
		val usr1StartingELO = calcUsr1.calculate()
		
		val calcUsr2 = CalculateStartingELO(usr2)
		val usr2StartingELO = calcUsr2.calculate()
		
		print("usr1: $usr1StartingELO usr2: $usr2StartingELO")
		
		assertTrue(usr1StartingELO - usr2StartingELO < 100)
	}
	
	@Test
	fun calculateSameNumbersDifferentWeightDifference() {
		val calcUsr1 = CalculateStartingELO(usr1)
		val usr1StartingELO = calcUsr1.calculate()
		
		val calcUsr3 = CalculateStartingELO(usr3)
		val usr3startingELO = calcUsr3.calculate()
		
		print("usr1: $usr1StartingELO usr3: $usr3startingELO")
		
		
		assertTrue(usr1StartingELO - usr3startingELO < 50)
	}
}
