package affinitas.com.affinitaspersonalitytest.config

import affinitas.com.affinitaspersonalitytest.config.components.ApplicationComponent
import affinitas.com.affinitaspersonalitytest.config.components.DaggerApplicationComponent
import affinitas.com.affinitaspersonalitytest.config.modules.*
import affinitas.com.affinitaspersonalitytest.services.ServiceManager
import android.support.multidex.MultiDexApplication
import javax.inject.Inject

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */
class MainApplication: MultiDexApplication() {
    @Inject
    lateinit var serviceManager: ServiceManager

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    protected fun initialize() {
        setupDependencies()
        serviceManager.initializeServices(this)
    }

    private fun setupDependencies() {
        applicationComponent = DaggerApplicationComponent.builder()
                .interactorModule(InteractorModule())
                .mapperModule(MapperModule())
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .serviceModule(ServiceModule())
                .build()
        applicationComponent.inject(this)
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
}