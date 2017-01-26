package com.sierisimo.idareyoutobeawesome.data

/**
 *
 * Created by sierisimo on 1/26/17.
 */

/**
 * This class represent a current Dare fetch by the server
 * This will be used everywhere, it's the main type of object used by viewholders and detail views.
 */
data class Dare(val id: Long, val title: String, val description: String, val dateCreated: Long, val dateSolved: Long)