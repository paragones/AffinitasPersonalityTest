package affinitas.com.affinitaspersonalitytest.model

import com.fasterxml.jackson.annotation.JsonCreator

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/31/2017.
 */
enum class Category(val value: String) {
    HARD_FACT("hard_fact"),
    LIFESTYLE("lifestyle"),
    INTROVERSION("introversion"),
    PASSION("passion");

    companion object {

        fun getCategory(category: String): Category =
                when (category) {
                    "hard_fact" -> HARD_FACT
                    "lifestyle" -> LIFESTYLE
                    "introversion" -> INTROVERSION
                    else -> PASSION
                }
    }
}