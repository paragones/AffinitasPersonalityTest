package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.interactors.QuestionnaireInteractor
import affinitas.com.affinitaspersonalitytest.ui.base.BasePresenter
import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
class MainPresenter @Inject constructor(private val interactor: QuestionnaireInteractor) : BasePresenter<MainView>() {

    fun loadData() {
        interactor.personalityTests()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.displayTest(it)
                }, {
                    Log.e(this.javaClass.simpleName, "Error $it")
                })
    }
}