package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.R
import affinitas.com.affinitaspersonalitytest.config.MainApplication
import affinitas.com.affinitaspersonalitytest.config.components.ActivitiesComponent
import affinitas.com.affinitaspersonalitytest.config.components.ApplicationComponent
import affinitas.com.affinitaspersonalitytest.config.components.DaggerActivitiesComponent
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
class MainActivity : AppCompatActivity(), MainView, AdapterView.OnItemSelectedListener {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var questionItems: List<QuestionItem>

    private var spinnerPosition: Int = 0
    private var subQuestionnaireItems: MutableList<QuestionItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDependencies()
        savedInstanceState?.let { spinnerPosition = it.getInt(SPINNER_POSITION) }
        setupView()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(SPINNER_POSITION, categorySpinner.selectedItemPosition)
    }

    private fun setupView() {
        presenter.attach(this)
        presenter.loadData()
    }

    private fun setupDependencies() {
        activitiesComponent = DaggerActivitiesComponent.builder()
                .applicationComponent(applicationComponent())
                .build()
        activitiesComponent.inject(this)
    }

    override fun displayTest(result: Pair<List<Category>, List<QuestionItem>>) {
        setupDropdown(result.first.map { it.value })
        setupPager(result.second)
        displayQuestionnaires()
    }

    private fun displayQuestionnaires() {
        categorySpinner.visibility = View.VISIBLE
        questionnairePager.visibility = View.VISIBLE
        progressBar.hide()
    }

    override fun displayError() = Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()

    private fun setupPager(questionItems: List<QuestionItem>) {
        this.questionItems = questionItems
    }

    private fun setupDropdown(choices: List<String>) {
        val spinnerAdapter = ArrayAdapter<String>(applicationContext,
                android.R.layout.simple_spinner_item, choices)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = spinnerAdapter
        categorySpinner.setSelection(spinnerPosition)
        categorySpinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        subQuestionnaireItems?.clear()
        subQuestionnaireItems = questionItems.filter {
            it.category == Category.getCategory(parent?.getItemAtPosition(position).toString())
        }.toMutableList()
        subQuestionnaireItems?.let { questionnairePager.adapter = MainPagerAdapter(it, presenter.loadAnswerKeys(), { presenter.saveAnswer(it) }) }
        questionnairePager.adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    fun applicationComponent(): ApplicationComponent = MainApplication.applicationComponent

    companion object {
        lateinit var activitiesComponent: ActivitiesComponent
        val SPINNER_POSITION = "SPINNER_POSITION"
    }
}
