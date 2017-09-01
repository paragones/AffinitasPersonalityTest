package affinitas.com.affinitaspersonalitytest.repositories

import affinitas.com.affinitaspersonalitytest.mapper.DataMapper
import affinitas.com.affinitaspersonalitytest.model.AnswerKey
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import affinitas.com.affinitaspersonalitytest.rest.QuestionnaireRest
import affinitas.com.affinitaspersonalitytest.services.DatabaseService
import android.util.Log
import rx.Observable
import rx.schedulers.Schedulers

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
class QuestionnaireRepositoryImpl(val rest: QuestionnaireRest,
                                  val databaseService: DatabaseService,
                                  val mapper: DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>>) : QuestionnaireRepository {
    override fun persontalityTest(): Observable<Pair<List<Category>, List<QuestionItem>>> {
        return rest.personalityTest()
                .map { mapper.transform(it) }
                .subscribeOn(Schedulers.io())
    }

    override fun loadAnswerKeys(): List<AnswerKey>? = databaseService.retrieveAnswerKeys()

    override fun saveAnswer(answerKey: AnswerKey) { databaseService.saveAnswer(answerKey) }
}