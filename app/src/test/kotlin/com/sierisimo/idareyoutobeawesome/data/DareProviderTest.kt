package com.sierisimo.idareyoutobeawesome.data

import org.junit.Assert.assertNotSame
import org.junit.Test

/**
 * Created by sierisimo on 3/4/17.
 */
class DareProviderTest {
    @Test
    fun getDares() {
        val listOfDares = DareProvider.getDares()

        assertNotSame("Check that list is not empty", 0, listOfDares.size)
    }
}