package affinitas.com.affinitaspersonalitytest.model

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/31/2017.
 * Copyright © 2017 Dojo Madness GmbH. All rights reserved.
 */
enum class QuestionType(val value: String) {
    SINGLE_CHOICE("single_choice"),
    SINGLE_CHOICE_CONDITIONAL("single_choice_conditional"),
    NUMBER_RANGE("number_range");

    companion object {

        fun getType(type: String): QuestionType =
                when (type) {
                    "single_choice" -> SINGLE_CHOICE
                    "single_choice_conditional" -> SINGLE_CHOICE_CONDITIONAL
                    else -> NUMBER_RANGE
                }
    }
}