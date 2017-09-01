package affinitas.com.affinitaspersonalitytest.repositories

import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import rx.Observable

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
interface QuestionnaireRepository {
    fun persontalityTest(): Observable<Pair<List<Category>, List<QuestionItem>>>
}