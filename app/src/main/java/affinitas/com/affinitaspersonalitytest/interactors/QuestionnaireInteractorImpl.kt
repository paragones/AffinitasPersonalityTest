package affinitas.com.affinitaspersonalitytest.interactors

import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.repositories.QuestionnaireRepository
import rx.Observable

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
class QuestionnaireInteractorImpl(val repository: QuestionnaireRepository) : QuestionnaireInteractor {
    override fun personalityTests(): Observable<Pair<List<Category>, List<QuestionItem>>> = repository.persontalityTest()

}