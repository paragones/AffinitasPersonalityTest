package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.interactors.QuestionnaireInteractor
import affinitas.com.affinitaspersonalitytest.model.AnswerKey
import affinitas.com.affinitaspersonalitytest.schedulers.ThreadScheduler
import affinitas.com.affinitaspersonalitytest.ui.base.BasePresenter
import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
class MainPresenter @Inject constructor(private val interactor: QuestionnaireInteractor,
                                        scheduler: ThreadScheduler) : BasePresenter<MainView>(scheduler) {

    fun loadData() {
        interactor.personalityTests()
                .compose(observeOn())
                .subscribe({
                    view?.displayTest(it)
                }, {
                    view?.displayError()
                })
    }

    fun loadAnswerKeys(): List<AnswerKey>? = interactor.loadAnswerKeys()

    fun saveAnswer(answerKey: AnswerKey) {
        interactor.saveAnswer(answerKey)
    }


}