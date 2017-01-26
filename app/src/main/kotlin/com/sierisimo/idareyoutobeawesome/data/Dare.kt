package com.sierisimo.idareyoutobeawesome.data

import com.sierisimo.idareyoutobeawesome.util.USE_MOCKS

/**
 *
 * Created by sierisimo on 1/26/17.
 */

/**
 * This class represent a current Dare fetch by the server
 * This will be used everywhere, it's the main type of object used by viewholders and detail views.
 */
data class Dare(val id: Long, val title: String, val description: String, val dateCreated: Long, val dateSolved: Long)

object DareProvider {
    fun getDares(): List<Dare> {
        return if (USE_MOCKS) getMockDares()
        else fetchDares()
    }

    private fun getMockDares(): List<Dare> = emptyList()

    private fun fetchDares(): List<Dare> = emptyList()
}