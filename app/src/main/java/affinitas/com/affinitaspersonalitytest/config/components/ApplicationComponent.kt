package affinitas.com.affinitaspersonalitytest.config.components

import affinitas.com.affinitaspersonalitytest.config.MainApplication
import affinitas.com.affinitaspersonalitytest.config.modules.*
import affinitas.com.affinitaspersonalitytest.interactors.QuestionnaireInteractor
import affinitas.com.affinitaspersonalitytest.mapper.DataMapper
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.repositories.QuestionnaireRepository
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import affinitas.com.affinitaspersonalitytest.rest.QuestionnaireRest
import affinitas.com.affinitaspersonalitytest.schedulers.ThreadScheduler
import affinitas.com.affinitaspersonalitytest.services.DatabaseService
import affinitas.com.affinitaspersonalitytest.services.ServiceManager
import dagger.Component
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */

@Singleton
@Component(modules = arrayOf(ExecutorsModule::class,
        InteractorModule::class,
        MapperModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ServiceModule::class))
interface ApplicationComponent {
    fun inject(application: MainApplication)

    fun questionnaireRest(): QuestionnaireRest

    fun questionnaireRepository(): QuestionnaireRepository

    fun questionnaireInteractor(): QuestionnaireInteractor

    fun dataMapper(): DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>>

    fun serviceManager(): ServiceManager

    fun databaseService(): DatabaseService

    fun threadScheduler() : ThreadScheduler
}