package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.R
import affinitas.com.affinitaspersonalitytest.config.ActivitiesComponent
import affinitas.com.affinitaspersonalitytest.config.ActivityModule
import affinitas.com.affinitaspersonalitytest.config.DaggerActivitiesComponent
import affinitas.com.affinitaspersonalitytest.config.NetworkModule
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
        Log.e(this.javaClass.simpleName, "categorySpinner.selectedItemPosition : " + categorySpinner.selectedItemPosition )
        savedInstanceState.putInt(SPINNER_POSITION, categorySpinner.selectedItemPosition)
    }

    private fun setupView() {
        presenter.attach(this)
        presenter.loadData()
    }

    private fun setupDependencies() {
        activitiesComponent = DaggerActivitiesComponent.builder()
                .networkModule(NetworkModule())
                .activityModule(ActivityModule())
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
        subQuestionnaireItems?.let { questionnairePager.adapter = MainPagerAdapter(it) }
        questionnairePager.adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    companion object {
        lateinit var activitiesComponent: ActivitiesComponent
        val SPINNER_POSITION = "SPINNER_POSITION"
    }
}
