package affinitas.com.affinitaspersonalitytest

import affinitas.com.affinitaspersonalitytest.interactors.QuestionnaireInteractor
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.schedulers.ThreadScheduler
import affinitas.com.affinitaspersonalitytest.ui.main.MainPresenter
import affinitas.com.affinitaspersonalitytest.ui.main.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import rx.Observable

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/2/2017.
 */
class MainPresenterTest {
    private lateinit var presenter: MainPresenter
    private lateinit var interactor: QuestionnaireInteractor
    private lateinit var scheduler: ThreadScheduler
    private lateinit var view: MainView
    private lateinit var pojoResults: Pair<List<Category>, List<QuestionItem>>

    @Before
    fun setup() {
        interactor = Mockito.mock(QuestionnaireInteractor::class.java)
        view = Mockito.mock(MainView::class.java)
        scheduler = Mockito.mock(ThreadScheduler::class.java)
        presenter = MainPresenter(interactor, TestScheduler())
        presenter.attach(view)
        pojoResults = TestUtil.pojoResults()
    }

    @Test
    fun shouldDisplayPOJOCategoryAndQuestionnaireItems() {
        Mockito.`when`(interactor.personalityTests()).thenReturn(Observable.just(pojoResults))
        presenter.loadData()

        Mockito.verify(view, Mockito.times(1)).displayTest(pojoResults)
    }

    @Test
    fun shouldDisplayErrorViewIfTheresNoJSONRetrievedFromBackend() {
        Mockito.`when`(interactor.personalityTests()).thenReturn(Observable.error(Exception()))
        presenter.loadData()

        Mockito.verify(view, Mockito.times(1)).displayError()
    }
}