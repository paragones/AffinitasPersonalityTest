package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
interface MainView {
    fun displayTest(result: Pair<List<Category>, List<QuestionItem>>)
}