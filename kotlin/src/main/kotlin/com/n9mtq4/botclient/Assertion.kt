package com.n9mtq4.botclient

/**
 * Created by will on 1/30/16 at 4:16 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
private fun stopJavadoc() {}

@Throws(AssertionError::class)
fun assertTrue(condition: Boolean) = assertTrue(condition, "")
@Throws(AssertionError::class)
fun assertTrue(condition: Boolean, msg: String) { if (!condition) throw AssertionError(msg) }
@Throws(AssertionError::class)
fun assertFalse(antiCondition: Boolean, msg: String) = assertTrue(!antiCondition, msg)


//BOT ASSERTS
/**
 * Makes sure you can perform the action. Throws
 * an exception if you can't
 *
 * @param need How many action points you need
 * @param have How many action points you have
 * @param type The name of the desired action
 * @throws NotEnoughActionPointsException if you can't perform the action
 * */
@Throws(NotEnoughActionPointsException::class)
internal fun assertActionPoints(need: Int, have: Int, type: String) {
	if (have - need < 0) throw NotEnoughActionPointsException(need, have, type)
}

/**
 * Makes sure you can perform the action. Throws
 * an exception if you can't
 *
 * @param need How many mana points you need
 * @param have How many mana points you have
 * @param type The name of the desired action
 * @throws NotEnoughManaPointsException if you can't perform the action
 * */
@Throws(NotEnoughManaPointsException::class)
internal fun assertManaPoints(need: Int, have: Int, type: String) {
	if (have - need < 0) throw NotEnoughManaPointsException(need, have, type)
}

/**
 * Makes sure you can perform the action. Throws
 * an exception if you can't
 *
 * @param apNeed How many action points you need
 * @param apHave How many action points you have
 * @param manaNeed How many mana points you need
 * @param manaHave How many mana points you have
 * @param type The name of the desired action
 * @throws NotEnoughManaPointsException if you can't perform the action with mana
 * @throws NotEnoughActionPointsException if you can't perform the action with ap
 * */
@Throws(NotEnoughActionPointsException::class, NotEnoughManaPointsException::class)
internal fun assertActionManaPoints(apNeed: Int, apHave: Int, manaNeed: Int, manaHave: Int, type: String) {
	assertActionPoints(apNeed, apHave, type)
	assertManaPoints(manaNeed, manaHave, type)
}
