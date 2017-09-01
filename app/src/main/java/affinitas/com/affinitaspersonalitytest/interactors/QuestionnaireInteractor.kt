package affinitas.com.affinitaspersonalitytest.interactors

import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import rx.Observable

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

//Todo: Change the jsonobject to pojo
interface QuestionnaireInteractor {
    fun personalityTests(): Observable<Pair<List<Category>, List<QuestionItem>>>
}