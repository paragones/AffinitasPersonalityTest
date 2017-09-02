package affinitas.com.affinitaspersonalitytest

import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.model.QuestionType

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/2/2017.
 * Copyright © 2017 Dojo Madness GmbH. All rights reserved.
 */
object TestUtil {

    fun pojoResults(): Pair<List<Category>, List<QuestionItem>> {
        return Pair(arrayListOf(Category.HARD_FACT, Category.LIFESTYLE),
                arrayListOf(QuestionItem(0,
                        "First Question",
                        Category.LIFESTYLE,
                        QuestionType.SINGLE_CHOICE,
                        arrayListOf("1", "2", "3"))))
    }
}