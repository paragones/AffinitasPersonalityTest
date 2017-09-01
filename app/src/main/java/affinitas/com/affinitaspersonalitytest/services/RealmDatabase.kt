package affinitas.com.affinitaspersonalitytest.services

import affinitas.com.affinitaspersonalitytest.model.AnswerKey
import affinitas.com.affinitaspersonalitytest.repositories.RealmAnswerKey
import android.content.Context
import io.realm.Realm


/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */
class RealmDatabase : DatabaseService {
    private lateinit var realm: Realm
    private val QUESTION_ITEM_ID = "questionItemId"

    override fun initializeDatabase(context: Context) {
        Realm.init(context)
        realm = Realm.getDefaultInstance()
    }

    override fun retrieveAnswerKeys(): List<AnswerKey>? {
        val realmAnswerKeys = realm.where(RealmAnswerKey::class.java).findAll()
        return realmAnswerKeys?.map { AnswerKey(it.questionItemId, it.optionSelected) }
    }

    override fun saveAnswer(answerKey: AnswerKey) {
        var realmAnswerKey = realm.where(RealmAnswerKey::class.java)
                .equalTo(QUESTION_ITEM_ID, answerKey.questionItemId)
                .findFirst()

        realm.beginTransaction()
        if (realmAnswerKey == null) {
            realmAnswerKey = realm.createObject(RealmAnswerKey::class.java, answerKey.questionItemId)
        }
        realmAnswerKey.optionSelected = answerKey.optionSelected
        realm.commitTransaction()
    }

}