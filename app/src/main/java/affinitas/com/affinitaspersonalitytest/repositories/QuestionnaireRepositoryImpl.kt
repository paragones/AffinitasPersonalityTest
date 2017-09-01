package affinitas.com.affinitaspersonalitytest.repositories

import affinitas.com.affinitaspersonalitytest.mapper.DataMapper
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.rest.QuestionnaireRest
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import rx.Observable
import rx.schedulers.Schedulers

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
class QuestionnaireRepositoryImpl(val rest: QuestionnaireRest,
                                  val mapper: DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>>) : QuestionnaireRepository {

    override fun persontalityTest(): Observable<Pair<List<Category>, List<QuestionItem>>> {
        return rest.personalityTest()
                .map { mapper.transform(it) }
                .subscribeOn(Schedulers.io())
    }
}