package com.sierisimo.idareyoutobeawesome.data

import android.support.annotation.IntDef
import com.sierisimo.idareyoutobeawesome.util.USE_MOCKS
import java.util.*

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
data class Dare(val id: Long, val title: String, val description: String, val dateCreated: Long, val dateSolved: Long, @DareStatus val currentState: Long)

object DareProvider {
    fun getDares(): List<Dare> {
        return if (USE_MOCKS) getMockDares()
        else fetchDares()
    }

    //HACK: 2/1/17 Fast way to fetch fake data.
    private fun getMockDares(): List<Dare> {
        val listOfDares = mutableListOf<Dare>()

        //HACK: 2/1/17 This is only a function to take a set of words and put it as part of the info
        val randomWord: () -> String = {
            val words = listOf("Push ups", "km running", "nights without sleeping", "meals without water", "run naked streets", "smile to unkown persons")

            words[Random().nextInt(words.size)]
        }

        (1..15).mapTo(listOfDares) {
            Dare(it * 1000L, "You have to $it ${randomWord()}", "This is a description to this dare, it involves doing a lot of work", Calendar.getInstance().timeInMillis, -1L, DareStatusValues.PENDING)
        }

        return listOfDares
    }

    //TODO: 2/1/17 Add the call for firebase...
    private fun fetchDares(): List<Dare> = emptyList()
}