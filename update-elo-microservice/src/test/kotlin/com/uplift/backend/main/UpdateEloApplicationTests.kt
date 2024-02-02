package com.uplift.backend.main

import com.uplift.backend.dao.CalculateUpdateELO
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UpdateEloApplicationTests {

	private final val calcUsr1 = CalculateUpdateELO(TestUsers.usr1)
	val usr1UpdatedELO = calcUsr1.calculate()
	
	private final val calcUsr1Heavy = CalculateUpdateELO(TestUsers.usr1Heavy)
	val usr1HeavyUpdatedELO = calcUsr1Heavy.calculate()
	
	/**
	 * This function tests if a users ELO comes back as an integer.
	 */
	@Test
	fun calculateMethodBasicTest() {
		println(usr1UpdatedELO)
		assertInstanceOf(Integer::class.java, usr1UpdatedELO)
	}
	
	/**
	 * This function tests if a users ELO comes back as an integer
	 * for a heavier user.
	 */
	@Test
	fun calculateUsr1HeavyELO() {
		println(usr1HeavyUpdatedELO)
		assertInstanceOf(Integer::class.java, usr1HeavyUpdatedELO)
	}
	
}
