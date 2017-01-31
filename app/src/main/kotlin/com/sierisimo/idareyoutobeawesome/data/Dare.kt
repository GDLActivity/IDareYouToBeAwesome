package com.sierisimo.idareyoutobeawesome.data

import android.support.annotation.IntDef
import com.sierisimo.idareyoutobeawesome.util.USE_MOCKS

/**
 *
 * Created by sierisimo on 1/26/17.
 */

@IntDef(DareStatusValues.PENDING, DareStatusValues.IN_PROGRESS, DareStatusValues.SOLVED, DareStatusValues.REJECTED, DareStatusValues.SENT)
@Retention(AnnotationRetention.SOURCE)
annotation class DareStatus

object DareStatusValues {
    const val PENDING = 0L
    const val IN_PROGRESS = 1L
    const val SOLVED = 2L
    const val REJECTED = -1L
    const val SENT = 5L
}

/**
 * This class represent a current Dare fetch by the server
 * This will be used everywhere, it's the main type of object used by viewholders and detail views.
 */
data class Dare(val id: Long, val title: String, val description: String, val dateCreated: Long, val dateSolved: Long, @DareStatus val currentState: Int)

object DareProvider {
    fun getDares(): List<Dare> {
        return if (USE_MOCKS) getMockDares()
        else fetchDares()
    }

    private fun getMockDares(): List<Dare> = emptyList()

    private fun fetchDares(): List<Dare> = emptyList()
}